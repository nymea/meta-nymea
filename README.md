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

	DEPENDS += "nymead"

nymea-plugins can be configured to include/exclude inndividual plugins using PACKAGECONFIG. By default all plugins are built. 

In order to exclude a plugin (and its dependencies) from being built, create a nymea-plugins.bbappend recipe and add

	PACKAGECONFIG_remove += "plugin1 plugin2 ..."


Each built plugin produces a package named "nymea-plugin-name". Depend on the plugin packages you want in your image recipe. For instance:

	DEPENDS += "nymea-plugin-philipshue nymea-plugin-netatmo ..."
