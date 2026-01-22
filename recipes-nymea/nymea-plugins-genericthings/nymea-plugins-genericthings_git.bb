DESCRIPTION = "nymea-plugins-genericthings"
SUMMARY = "Collection of generic integration plugins for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-plugins-genericthings/issues"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-plugins-genericthings.git;protocol=https;branch=master"
# Release: 1.14.0
SRCREV = "1ace4943bc13f9cd9bcae536da2e7570ce4737e0"
PV = "1.14.0-git${SRCPV}"

DEPENDS += "nymea nymea-native"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

# The package nymea-plugins-genericthings is only a meta package for all plugins
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# ${PN}-dev normally depends on ${PN}. Since ${PN} is a meta package pulling in
# *all* plugins, developer images that install complementary -dev packages would
# end up installing all plugins as well. nymea-plugins-genericthings does not ship headers or
# linkable libraries that need such a dependency, so drop it.
RDEPENDS:${PN}-dev = ""

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugin* after having bitbake'd nymea-plugin-genericthings
python populate_packages:prepend (){
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')

    # Make sure to name the dynamic created packages in a way so they can be identified using a regexp in PACKAGES_DYNAMIC.
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-generic-%s', 'Nymea integration plugin for generic %s', extra_depends='libnymea')

    # Make nymea-plugins-genericthings a meta package which RDEPENDS on all available nymea-plugin-generic-* packages
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins))
}

# Note: since other plugin recipes use the same mechanism, it is important
# to have a unique way to regepx the dynamic created subset of packages in
# this PACKAGES_DYNAMIC property.
# Best practice, as of now, is to have nymea-plugin-<topic>-* naming schema.
# Warning: this might break if other layers or recipes use the same schema.

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-generic-*"
