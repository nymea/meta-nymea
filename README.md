meta-nymea
================================

Introduction
-------------------------

OpenEmbedded/Yocto meta layer for nymea

* Base openembedded/yocto system

	URI: git://git.yoctoproject.org/poky
	BRANCH: `kirkstone` or `scarthgap`

* Qt6

	URI: "https://code.qt.io/cgit/yocto/meta-qt6.git"
	BRANCH: `6.8.3`

> Note: make sure not to checkout an `lts-6.X.X` branch, since that requires a commercial license.

> Note: Currently following patch is required in order make the native build work properly: [QTBUG-140631](https://bugreports.qt.io/browse/QTBUG-140631).

Usage
-------------------------

This layer mainly builds "nymead" and all required dependencies in order to run the daemon.

If you want to include nymea:core in your image, use

	IMAGE_INSTALL += "nymead"

It is recommended to include "avahi-daemon" in the image too to allow nymea:app to automatically find nymea:core.

	IMAGE_INSTALL += "avahi-daemon"

nymea-plugins can be configured to include/exclude individual plugins using PACKAGECONFIG. By default all plugins are built. 

In order to exclude a plugin (and its dependencies) from being built at all, create a nymea-plugins.bbappend recipe and add

	PACKAGECONFIG:remove += "plugin1 plugin2 ..."


Each built plugin produces a package named "nymea-plugin-name". It is possible to manually specify all plugins to be installed with:

	IMAGE_INSTALL += "nymea-plugin-common-philipshue nymea-plugin-common-netatmo ..."

One can also install all plugins that were built with:

	IMAGE_INSTALL += "nymea-plugins"

Each plugins repository has it's own plugin package syntax in order to keep the projects as lean as possible.

| Recepie                     | All plugins meta package     | Individual plugin package name   |
|-----------------------------|------------------------------|----------------------------------|
| nymea-plugins               | `nymea-plugins`              | `nymea-plugin-common-<name>`     |
| nymea-plugins-genericthings | `nymea-plugins-genericthing` | `nymea-plugin-generic-<name>`    |
| nymea-plugins-modbus        | `nymea-plugins-modbus`       | `nymea-plugin-modbus-<name>`     |
| nymea-plugins-zigbee        | `nymea-plugins-zigbee`       | `nymea-plugin-zigbee-<name>`     |
| nymea-plugins-simulation    | `nymea-plugins-simulation`   | `nymea-plugin-simulation-<name>` |
