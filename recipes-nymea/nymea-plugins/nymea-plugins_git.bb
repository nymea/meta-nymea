DESCRIPTION = "nymea-plugins"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-plugins.git;protocol=https;branch=master"
# Release: 1.0.0
SRCREV="750afb77f98cb0c41c91948b6b0395d24ce6b914"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native"

inherit qmake5

S = "${WORKDIR}/git"

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

EXTRA_QMAKEVARS_PRE += "CONFIG+=selection ${PACKAGECONFIG_CONFARGS}"

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins after having bitbake'd nymea-plugins
PACKAGESPLITFUNCS_prepend = " split_nymea_plugins_packages "

python split_nymea_plugins_packages() {
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-%s', 'Nymea integration plugin for %s', extra_depends='')

    # Make nymea-plugins a meta package which RDEPENDS on all available nymea-plugin-
    d.setVar('RDEPENDS_' + d.getVar('PN'), ' '.join(plugins))
}

ALLOW_EMPTY_${PN} = "1"
FILES_${PN} = ""

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-.*"
