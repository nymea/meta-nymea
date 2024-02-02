#!/bin/bash

# Configs
TAG=""
BRANCH=""
VERSION=""

CURRENTDIR=$(dirname "$(realpath -s "$0")")

function usage() {
  cat <<EOF

This tool allowes to update the source revision of the nymea-recipes either to a specific tag or to a specific branch. 

The tool requires either a tag or a branch.
The version paramter is only valid in combination with a given branch.

The tag will be used as version unless overwritten using the version parameter.

Reuired dependecies: jq curl

Usage: $(basename $0) [OPTIONS]

OPTIONS:
  -t, --tag <tag>           Update all nymea recipes to the given tag. Also the version will be updated to the tag name.
  -b, --branch <branch>     Update all nymea recipes to the given branch.
  -v, --version <version>   Set all nymea packages to the given version. Optional usage with branch.
  -h, --help                Show this message

EOF
}

function configureTag() {
    echo "Updating to tag $TAG"
    echo "Using version $VERSION"
    cd ${CURRENTDIR}/recipes-nymea
    for REPOSITORY in *; do
        echo "---------------------------------------------------------------"
        if [ ! -d ${REPOSITORY} ]; then
            echo "Skipping ${REPOSITORY} since this is not a directory..."
            continue
        fi

        if [ "${REPOSITORY}" == "nymea-app" ]; then
            echo "Skipping ${REPOSITORY} automatic source revision since the app has it's own versioning"
            continue
        fi

        echo -e "Repository:\t\t${REPOSITORY}"
        local RECIPE_FILE=$(find . -name "${REPOSITORY}_git.bb")
        echo -e "Recipe:\t\t\t${RECIPE_FILE}"
        local SOURCE_LINE="$(grep SRC_URI $RECIPE_FILE | grep "github.com/nymea")"
        local REPOSITORY_URL=$(echo $SOURCE_LINE | cut -d \" -f 2 | cut -d \; -f 1 | sed 's/git:/https:/')
        echo -e "Repository URL:\t\t${REPOSITORY_URL}"
        local CURRENT_BRANCH=$(echo $SOURCE_LINE | cut -d \" -f 2 | cut -d \; -f 3 | sed  's/^branch=//')
        echo -e "Current branch:\t\t${CURRENT_BRANCH}"

        echo "Loading tags from repository ..."
        # Fetch the online tags and get the SHA from the given tag
        local TAGS_LIST=$(curl -s -L https://api.github.com/repos/nymea/${REPOSITORY}/tags)
        local TAGS_COUNT=$(echo $TAGS_LIST | jq '. | length')
        local TAG_SHA=""

        echo "Fetched $TAGS_COUNT tags..."
        for TAG_OBJECT in $(echo $TAGS_LIST | jq -c .[]); do
            local TAG_NAME=$(echo "$TAG_OBJECT" | jq .name | tr -d '"')
            if [[ "$TAG_NAME" == "$TAG" ]]; then
                TAG_SHA=$(echo "$TAG_OBJECT" | jq .commit.sha | tr -d '"')
                echo "Found tag $TAG_NAME --> SHA hash: $TAG_SHA"
                break
            fi
        done

        echo "Updating SRCREV ..."
        sed -i "s/^SRCREV =.*/SRCREV = \"$TAG_SHA\"/" ${RECIPE_FILE}
        cat ${RECIPE_FILE} | grep "SRCREV"

        echo "Updating Release comment ..."
        sed -i "s/^# Release: .*/\# Release: ${TAG}/" ${RECIPE_FILE}
        cat ${RECIPE_FILE} | grep "# Release"

        echo "Updating PV ..."
        sed -i "s/^\PV = .*/PV = \"$TAG-git\x24{SRCPV}\"/" ${RECIPE_FILE}
        cat ${RECIPE_FILE} | grep "PV ="

    done
}


function configureBranch() {
    echo "Updating to branch $BRANCH"
    echo "Using version $VERSION"
    echo "TODO: not implemented yet"
    #   sed -i "s/\(SRC_URI=[\;\"a-z:\/\.=\-]*branch\=\)[a-z\-]*/\1$target/" $recipe
    exit 1
}


while [ "$1" != "" ]; do
    case $1 in
        -t | --tag )
            TAG="$2"
            shift;;
        -b | --branch )
            BRANCH="$2"
            shift;;
        -v | --version )
            VERSION="$2"
            shift;;
        -h | --help )
            usage && exit 0;;
        * )
            usage && exit 1;;
    esac
    shift
done


if [ -z "$TAG" ] && [ -z "$BRANCH" ]; then
    echo "Please specify either a branch (-b | --branch) or a tag (-t | --tag)."
    exit 1
fi

if [ ! -z "$TAG" ] && [ ! -z "$BRANCH" ]; then
    echo "Please specify either a branch or a tag, not both."
    exit 1
fi

target=$1

if [ ! -z "$TAG" ]; then
    if [ ! -z "$VERSION" ]; then
        VERSION="$TAG"
    fi

    configureTag
    
elif [ ! -z "$BRANCH" ]; then
    if [ -z "$VERSION" ]; then
        echo "Unknown version. Please specify also the version (-v | --version)"
        exit 1
    fi

    configureBranch
fi