DESCRIPTION = "nymea-plugins"
SUMMARY = "Collection of integration plugins for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-plugins/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-plugins.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "74bda79d1000c710e1c857116fe838c5e7dbb9cc"
PV = "1.9.0-git${SRCPV}"

DEPENDS += "nymea nymea-native"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

# The package nymea-plugins is only a meta package for all plugins
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# Only plugins which require a build time or runtime dependency need to be
# explicitly listed, so that they can be disabled and make the build slightly
# faster.
PACKAGECONFIG ?= " \
        ${@incompatible_license_contains('GPL-3.0', '', 'boblight', d)} \
        nuki \
        onewire \
        serialportcommander \
        usbrelay \
        "

# PACKAGECONFIG options should **never** set WITH_PLUGINS in the leftmost argument
PACKAGECONFIG[boblight] = ", WITHOUT_PLUGINS+=boblight, boblight"
PACKAGECONFIG[nuki] = ", WITHOUT_PLUGINS+=nuki, libsodium"
PACKAGECONFIG[onewire] = ", WITHOUT_PLUGINS+=onewire, owfs"
PACKAGECONFIG[serialportcommander] = ", WITHOUT_PLUGINS+=serialportcommander, qtserialport"
PACKAGECONFIG[usbrelay] = ", WITHOUT_PLUGINS+=usbreleay, hidapi"

EXTRA_QMAKEVARS_PRE += "${PACKAGECONFIG_CONFARGS}"

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins after having bitbake'd nymea-plugins
python populate_packages:prepend (){
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')

    # Make sure to name the dynamic created packages in a way so they can be identified using a regexp in PACKAGES_DYNAMIC.
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-common-%s', 'Nymea integration plugin for %s', extra_depends='')

    # Make nymea-plugins a meta package which RDEPENDS on all available nymea-plugin-common-* packages
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins))
}

# Note: since other plugin recipes use the same mechanism, it is important
# to have a unique way to regepx the dynamic created subset of packages in
# this PACKAGES_DYNAMIC property.
# Best practice, as of now, is to have nymea-plugin-<topic>-* naming schema.
# Warning: this might break if other layers or recipes use the same schema.

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-common-*"
