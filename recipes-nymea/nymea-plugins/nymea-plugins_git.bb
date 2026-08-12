DESCRIPTION = "nymea-plugins"
SUMMARY = "Collection of integration plugins for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-plugins/issues"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-plugins.git;protocol=https;branch=master"
# Release: 1.16.0
SRCREV = "262597d106df3efd4399eb9a0e571576ed2b9eff"
PV = "1.16.0-git${SRCPV}"

DEPENDS += "nymea nymea-sdk-native"

inherit qt6-qmake pkgconfig

# The package nymea-plugins is only a meta package for all plugins
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# ${PN}-dev normally depends on ${PN}. Since ${PN} is a meta package pulling in
# *all* plugins, developer images that install complementary -dev packages would
# end up installing all plugins as well. nymea-plugins does not ship headers or
# linkable libraries that need such a dependency, so drop it.
RDEPENDS:${PN}-dev = ""

# Only plugins which require a build time or runtime dependency need to be
# explicitly listed, so that they can be disabled and make the build slightly
# faster.
PACKAGECONFIG ?= " \
        nuki \
        onewire \
        serialportcommander \
        usbrelay \
        "

# PACKAGECONFIG options should **never** set WITH_PLUGINS in the leftmost argument
PACKAGECONFIG[nuki] = ", WITHOUT_PLUGINS+=nuki, libsodium"
PACKAGECONFIG[onewire] = ", WITHOUT_PLUGINS+=onewire, owfs"
PACKAGECONFIG[serialportcommander] = ", WITHOUT_PLUGINS+=serialportcommander, qtserialport"
PACKAGECONFIG[usbrelay] = ", WITHOUT_PLUGINS+=usbrelay, hidapi"

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
