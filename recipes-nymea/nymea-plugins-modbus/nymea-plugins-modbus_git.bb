DESCRIPTION = "nymea-plugins-modbus"
SUMMARY = "Collection of modbus integration plugins for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-plugins-modbus/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-plugins-modbus.git;protocol=https;branch=master"
# Release: 1.9.1
SRCREV = "25671f284b6fcae32ad595ceae439587619e9a29"
PV = "1.9.1-git${SRCPV}"

DEPENDS += "nymea nymea-native qtserialport qtserialbus python3 i2c-tools"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

EXTRA_QMAKEVARS_PRE += "${PACKAGECONFIG_CONFARGS}"

PACKAGES =+ " \
	nymea-modbus-cli \
	libnymea-modbus \
	libnymea-modbus-dev \
	libnymea-sunspec1 \
	libnymea-sunspec1-dev \
	"

FILES:libnymea-sunspec1 = "${libdir}/libnymea-sunspec1*${SOLIBS}"
FILES:libnymea-sunspec1-dev = " \
	${libdir}/libnymea-sunspec1*${SOLIBSDEV} \
	${libdir}/pkgconfig/nymea-sunspec.pc \
	${incldir}/nymea-sunspec \
	"

FILES:libnymea-modbus = "${libdir}/libnymea-modbus*${SOLIBS}"
FILES:libnymea-modbus-dev = " \
	${libdir}/libnymea-modbus*${SOLIBSDEV} \
	${libdir}/pkgconfig/nymea-modbus.pc \
	${incldir}/nymea-modbus \
	"
FILES:nymea-modbus-cli = "${bindir}/nymea-modbus-cli"

# The package nymea-plugins-modbus is only a meta package for all plugins
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins-modbus after having bitbake'd nymea-plugins-modbus
python populate_packages:prepend (){
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')

    # Make sure to name the dynamic created packages in a way so they can be identified using a regexp in PACKAGES_DYNAMIC.
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-modbus-%s', 'Nymea modbus integration plugin for %s', extra_depends='libnymea libnymea-modbus')

    # Make nymea-plugins-modbus a meta package which RDEPENDS on all available nymea-plugin-modbus-
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins))
}

# Note: since other plugin recipes use the same mechanism, it is important
# to have a unique way to regepx the dynamic created subset of packages in
# this PACKAGES_DYNAMIC property.
# Best practice, as of now, is to have nymea-plugin-<topic>-* naming schema.
# Warning: this might break if other layers or recipes use the same schema.

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-modbus-*"
