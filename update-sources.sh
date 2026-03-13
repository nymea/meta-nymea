#!/bin/bash

# SPDX-License-Identifier: MIT

# Configs
TAG=""
BRANCH=""
VERSION=""
SET_AUTOREV=0

CURRENTDIR=$(dirname "$(realpath -s "$0")")

function listRecipeFiles() {
    find "${CURRENTDIR}/recipes-nymea" "${CURRENTDIR}/recipes-tools" \
        -maxdepth 2 -name "*_git.bb" -print 2>/dev/null | sort
}

function recipeSourceLine() {
    local recipe_file="$1"
    grep SRC_URI "$recipe_file" | grep "github.com/nymea"
}

function recipeRepositoryUrl() {
    local source_line="$1"
    echo "$source_line" | cut -d \" -f 2 | cut -d \; -f 1 | sed 's/git:/https:/'
}

function recipeRepositoryName() {
    local repository_url="$1"
    basename "$repository_url" .git
}

function usage() {
  cat <<EOF

This tool allows to update the source revision of the nymea-recipes either to a specific tag or to a specific branch.

The tool requires either a tag or a branch.
The version parameter is only valid in combination with a given branch.

The tag will be used as version unless overwritten using the version parameter.

Warning: don't call the script to many times, otherwise you reach quickly the rate limits of the api.
You can check the current rate limit with 'curl -L https://api.github.com/rate_limit'

Required dependencies: jq curl

Usage: $(basename $0) [OPTIONS]

OPTIONS:
  -t, --tag <tag>           Update all nymea recipes to the given tag. Also the version will be updated to the tag name.
  -b, --branch <branch>     Update all nymea recipes to the given branch.
  -v, --version <version>   Set all nymea packages to the given version. Optional usage with branch.
  -a, --auto-revision       Set the source revision to AUTOREV. Default sets the revision to the branch/tag hash.
  -h, --help                Show this message

EOF
}

function configureTag() {
    echo "Updating to tag $TAG"
    echo "Using version $VERSION"

    while IFS= read -r RECIPE_FILE; do
        echo "---------------------------------------------------------------"

        local RECIPE_DIR=$(basename "$(dirname "$RECIPE_FILE")")
        local SOURCE_LINE="$(recipeSourceLine "$RECIPE_FILE")"
        if [ -z "$SOURCE_LINE" ]; then
            echo "Skipping ${RECIPE_DIR} since it does not use a nymea GitHub SRC_URI..."
            continue
        fi

        local REPOSITORY_URL=$(recipeRepositoryUrl "$SOURCE_LINE")
        local REPOSITORY=$(recipeRepositoryName "$REPOSITORY_URL")

        if [ "${RECIPE_DIR}" == "nymea-app" ] || [ "${REPOSITORY}" == "nymea-app" ]; then
            echo "Skipping ${RECIPE_DIR} automatic source revision since the app has it's own versioning"
            continue
        fi

        echo -e "Recipe dir:\t\t${RECIPE_DIR}"
        echo -e "Repository:\t\t${REPOSITORY}"
        echo -e "Recipe:\t\t\t${RECIPE_FILE}"
        echo -e "Repository URL:\t\t${REPOSITORY_URL}"
        local CURRENT_BRANCH=$(echo "$SOURCE_LINE" | cut -d \" -f 2 | cut -d \; -f 3 | sed  's/^branch=//')
        echo -e "Current branch:\t\t${CURRENT_BRANCH}"

        echo "Loading tags from repository ..."
        # Fetch the online tags and get the SHA from the given tag
        local TAGS_LIST=$(curl -s -L https://api.github.com/repos/nymea/${REPOSITORY}/tags?per_page=200)
        local TAGS_COUNT=$(echo "$TAGS_LIST" | jq '. | length')
        local TAG_SHA=""

        echo "Fetched $TAGS_COUNT tags..."
        for TAG_OBJECT in $(echo "$TAGS_LIST" | jq -c .[]); do
            local TAG_NAME=$(echo "$TAG_OBJECT" | jq .name | tr -d '"')
            if [[ "$TAG_NAME" == "$TAG" ]]; then
                TAG_SHA=$(echo "$TAG_OBJECT" | jq .commit.sha | tr -d '"')
                echo "Found tag $TAG_NAME --> SHA hash: $TAG_SHA"
                break
            fi
        done

        echo "Updating SRCREV ..."
        if [ $SET_AUTOREV -eq 1 ]; then
            TAG_SHA='${AUTOREV}'
        fi
        sed -i "s/^SRCREV =.*/SRCREV = \"$TAG_SHA\"/" "$RECIPE_FILE"
        grep "SRCREV" "$RECIPE_FILE"

        echo "Updating Release comment ..."
        sed -i "s/^# Release: .*/\# Release: ${TAG}/" "$RECIPE_FILE"
        grep "# Release" "$RECIPE_FILE"

        echo "Updating PV ..."
        sed -i "s/^\PV = .*/PV = \"$TAG-git\x24{SRCPV}\"/" "$RECIPE_FILE"
        grep "PV =" "$RECIPE_FILE"

    done < <(listRecipeFiles)
}


function configureBranch() {
    echo "Updating to branch $BRANCH"
    echo "Using version $VERSION"

    while IFS= read -r RECIPE_FILE; do
        echo "---------------------------------------------------------------"

        local RECIPE_DIR=$(basename "$(dirname "$RECIPE_FILE")")
        local SOURCE_LINE="$(recipeSourceLine "$RECIPE_FILE")"
        if [ -z "$SOURCE_LINE" ]; then
            echo "Skipping ${RECIPE_DIR} since it does not use a nymea GitHub SRC_URI..."
            continue
        fi

        local REPOSITORY_URL=$(recipeRepositoryUrl "$SOURCE_LINE")
        local REPOSITORY=$(recipeRepositoryName "$REPOSITORY_URL")

        echo -e "Recipe dir:\t\t${RECIPE_DIR}"
        echo -e "Repository:\t\t${REPOSITORY}"
        echo -e "Recipe:\t\t\t${RECIPE_FILE}"
        echo -e "Repository URL:\t\t${REPOSITORY_URL}"
        local CURRENT_BRANCH=$(echo "$SOURCE_LINE" | cut -d \" -f 2 | cut -d \; -f 3 | sed  's/^branch=//')
        echo -e "Current branch:\t\t${CURRENT_BRANCH}"

        echo "Loading branches from repository ..."
        # Fetch the online tags and get the SHA from the given tag
        local BRANCHES_LIST=$(curl -s -L https://api.github.com/repos/nymea/${REPOSITORY}/branches?per_page=200)
        local BRANCHES_COUNT=$(echo "$BRANCHES_LIST" | jq '. | length')
        local BRANCH_SHA=""
        local BRANCH_NAME=""

        echo "Fetched $BRANCHES_COUNT branches..."
        for BRANCH_OBJECT in $(echo "$BRANCHES_LIST" | jq -c .[]); do
            local BRANCH_NAME=$(echo "$BRANCH_OBJECT" | jq .name | tr -d '"')
            if [[ "$BRANCH_NAME" == "$BRANCH" ]]; then
                BRANCH_SHA=$(echo "$BRANCH_OBJECT" | jq .commit.sha | tr -d '"')
                echo "Found branch $BRANCH_NAME --> SHA hash: $BRANCH_SHA"
                break
            fi
        done

        echo "Updating SRC_URI ..."
        sed -i "s/\(branch=\)[^\";]*/\1${BRANCH_NAME}/" "$RECIPE_FILE"
        grep "SRC_URI" "$RECIPE_FILE"

        echo "Updating SRCREV ..."
        if [ $SET_AUTOREV -eq 1 ]; then
            BRANCH_SHA='${AUTOREV}'
        fi
        sed -i "s/^SRCREV =.*/SRCREV = \"$BRANCH_SHA\"/" "$RECIPE_FILE"
        grep "SRCREV" "$RECIPE_FILE"

        echo "Updating Release comment ..."
        sed -i "s/^# Release: .*/\# Branch: ${BRANCH}/" "$RECIPE_FILE"
        grep "# Branch" "$RECIPE_FILE"

        echo "Updating PV ..."
        sed -i "s/^\PV = .*/PV = \"$VERSION-git\x24{SRCPV}\"/" "$RECIPE_FILE"
        grep "PV =" "$RECIPE_FILE"

    done < <(listRecipeFiles)

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
        -a | --auto-revision )
            SET_AUTOREV=1
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
