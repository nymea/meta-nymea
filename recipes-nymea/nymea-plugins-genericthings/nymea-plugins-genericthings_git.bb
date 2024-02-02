DESCRIPTION = "nymea-plugins-genericthings"
SUMMARY = "Collection of generic integration plugins for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-plugins-genericthings/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-plugins-genericthings.git;protocol=https;branch=master"
# Release: 1.9.1
SRCREV = "4f7a408f2af0fb172f6d799003549ea32600c98e"
PV = "1.9.1-git${SRCPV}"

DEPENDS += "nymea nymea-native"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

# The package nymea-plugins-genericthings is only a meta package for all plugins
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugin* after having bitbake'd nymea-plugin-genericthings
python populate_packages:prepend (){
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')

    # Make sure to name the dynamic created packages in a way so they can be identified using a regexp in PACKAGES_DYNAMIC.
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-generic-%s', 'Nymea integration plugin for generic %s', extra_depends='libnymea')

    # Make nymea-plugins-genericthings a meta package which RDEPENDS on all available nymea-plugin-generic-
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins))
}

# Note: since other plugin recipes use the same mechanism, it is important
# to have a unique way to regepx the dynamic created subset of packages in
# this PACKAGES_DYNAMIC property.
# Best practice, as of now, is to have nymea-plugin-<topic>-* naming schema.
# Warning: this might break if other layers or recipes use the same schema.

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-generic-*"
