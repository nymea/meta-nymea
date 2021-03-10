meta-nymea
================================

Introduction
-------------------------

OpenEmbedded/Yocto meta layer for nymea

The meta-nymea layer is currently tested with *krogoth* branches of

* Base openembedded/yocto system

	URI: git://git.yoctoproject.org/poky

* Qt5

	URI: "https://github.com/meta-qt5/meta-qt5.git"

* To build the raspberry pi image

	URI: "git://git.yoctoproject.org/meta-raspberrypi"

Usage
-------------------------

This layer mainly builds "nymead" and "nymea-plugins". 

To include nymea:core in your image, use

	IMAGE_INSTALL += "nymead"

It is recommended to include "avahi-daemon" in the image too to allow nymea:app to automatically find nymea:core.

	IMAGE_INSTALL += "avahi-daemon"

nymea-plugins can be configured to include/exclude inndividual plugins using PACKAGECONFIG. By default all plugins are built. 

In order to exclude a plugin (and its dependencies) from being built at all, create a nymea-plugins.bbappend recipe and add

	PACKAGECONFIG_remove += "plugin1 plugin2 ..."


Each built plugin produces a package named "nymea-plugin-name". It is possible to manually specify all plugins to be installed with:

	IMAGE_INSTALL += "nymea-plugin-philipshue nymea-plugin-netatmo ..."

One can also install all plugins that were built with:

	IMAGE_INSTALL += "nymea-plugins"
