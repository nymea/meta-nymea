#!/bin/bash


if [ -z "$1" ]; then
  echo "usage: $0 <branch>"
  exit 1
fi

target=$1

input="srcrevs.conf"

while IFS= read -r package
do
  recipe=`find . -name "${package}_git.bb"`
  echo "* Updating recipe: ${recipe}"
  repo=`grep SRC_URI $recipe | cut -d \" -f 2 | cut -d \; -f 1 | sed 's/git:/https:/'`
  revline=`git ls-remote $repo | grep $target | sed 's/\t/\//g'`
  rev=`echo $revline | cut -d "/" -f 1`
  if [ "$target" = "master" ]; then
    tagline=`git ls-remote --tags $repo | grep $rev | sed 's/\t/\//g'`
    tag=`echo $tagline | cut -d "/" -f 4`
  else
    tag=$target
  fi
  echo "  Revision: $rev Tag: $tag"
  sed -i "s/^SRCREV=.*$/SRCREV=\"$rev\"/" $recipe
  sed -i "s/^\# Release: .*/\# Release: $tag/" $recipe
done < "$input"

