DESCRIPTION = "nymea-plugins-modbus"
SUMMARY = "Collection of modbus integration plugins for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-plugins-modbus/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-plugins-modbus.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "aa79edac5ce18008470e1f66fed49f71f0230013"
PV = "1.9.0-git${SRCPV}"

DEPENDS += "nymead nymead-native qtserialport qtserialbus python3 i2c-tools"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

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

ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins-modbus after having bitbake'd nymea-plugins-modbus
python populate_packages:prepend (){
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-%s', 'Nymea modbus integration plugin for %s', extra_depends='')

    # Make nymea-plugins-modbus a meta package which RDEPENDS on all available nymea-plugin-
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins))
}

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-*"
