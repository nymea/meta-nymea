DESCRIPTION = "nymea-plugins-genericthings"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-plugins-genericthings.git;protocol=https;branch=master"
# Release: 1.8.1
SRCREV = "5e7912fce69d30802bd859a35916f24429397e59"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

EXTRA_QMAKEVARS_PRE += "${PACKAGECONFIG_CONFARGS}"

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins after having bitbake'd nymea-plugins
python populate_packages:prepend (){
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugingeneric(.*)\.so\.*', 'nymea-plugin-generic-%s', 'Nymea integration plugin for %s', extra_depends='')

    # Make nymea-plugins a meta package which RDEPENDS on all available nymea-plugin-
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins))
}

ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-generic*"
