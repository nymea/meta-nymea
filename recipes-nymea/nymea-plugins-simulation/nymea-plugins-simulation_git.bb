DESCRIPTION = "nymea-plugins-simulation"
SUMMARY = "Collection of simulation plugins for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-plugins-simulation/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-plugins-simulation.git;protocol=https;branch=qt6-qmake"
# Branch: qt6-qmake
SRCREV = "92ac6ffe446ca7ef34df632bcf183a6186db3bf5"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "nymea nymea-native"

inherit qt6-qmake pkgconfig

S = "${WORKDIR}/git"

# The package nymea-plugins-simulation is only a meta package for all plugins
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugin* after having bitbake'd nymea-plugins-simulation
python populate_packages:prepend (){
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')

    # Make sure to name the dynamic created packages in a way so they can be identified using a regexp in PACKAGES_DYNAMIC.
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-simulation-%s', 'Nymea integration plugin for simulating %s', extra_depends='libnymea')

    # Make nymea-plugins-simulation a meta package which RDEPENDS on all available nymea-plugin-simulation-* packages
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins))
}

# Note: since other plugin recipes use the same mechanism, it is important
# to have a unique way to regepx the dynamic created subset of packages in
# this PACKAGES_DYNAMIC property.
# Best practice, as of now, is to have nymea-plugin-<topic>-* naming schema.
# Warning: this might break if other layers or recipes use the same schema.

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-simulation-*"
