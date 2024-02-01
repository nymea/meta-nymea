DESCRIPTION = "nymea-plugins-zigbee"
SUMMARY = "Collection of zigbee integration plugins for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-plugins-zigbee/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-plugins-zigbee.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "fa0efc7d1cf93a6b733873bf5cc2d30e4b3150f3"
PV = "1.9.0-git${SRCPV}"

DEPENDS += "nymea nymea-native nymea-zigbee"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

# The package nymea-plugins-zigbee is only a meta package for all plugins
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# PACKAGECONFIG options should **never** set WITH_PLUGINS in the leftmost argument
# PACKAGECONFIG[zigbeelumi] = ", WITHOUT_PLUGINS+=zigbeelumi"

# EXTRA_QMAKEVARS_PRE += "${PACKAGECONFIG_CONFARGS}"

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugin-zigbee* after having bitbake'd nymea-plugins-zigbee
python populate_packages:prepend () {
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')
    
    # Make sure to name the dynamic created packages in a way so they can be identified using a regexp in PACKAGES_DYNAMIC.
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-zigbee-%s', 'Nymea zigbee integration plugin for %s', extra_depends='libnymea libnymea-zigbee')

    # Make nymea-plugins-zigbee a meta package which RDEPENDS on all available nymea-plugin-zigbee-*
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins))
}

# Note: since other plugin recipes use the same mechanism, it is important
# to have a unique way to regepx the dynamic created subset of packages in
# this PACKAGES_DYNAMIC property.
# Best practice, as of now, is to have nymea-plugin-<topic>-* naming schema.
# Warning: this might break if other layers or recipes use the same schema.

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-zigbee-*"
