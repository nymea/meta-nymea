DESCRIPTION = "nymea-plugins-modbus"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-plugins-modbus.git;protocol=https;branch=add-license-file"
# Release: 1.8.1
SRCREV = "b9891d605537442535913127b138d2c7e4d36d21"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native qtserialport qtserialbus python3 i2c-tools"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

# Only plugins which require a build time or runtime dependency need to be
# explicitly listed, so that they can be disabled and make the build slightly
# faster.
PACKAGECONFIG ?= ""

PACKAGES =+ "libnymea-modbus libnymea-sunspec1"

EXTRA_QMAKEVARS_PRE += "${PACKAGECONFIG_CONFARGS}"

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins-modbus after having bitbake'd nymea-plugins-modbus
python populate_packages:prepend (){
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-%s', 'Nymea integration plugin for %s', extra_depends='')

    # Make nymea-plugins a meta package which RDEPENDS on all available nymea-plugin-
    d.setVar('RDEPENDS:' + d.getVar('PN'), ' '.join(plugins) + ', libnymea-modbus')
}

do_install:append:class-target() {
        install -d ${D}${libdir}
        install -m 0755 ${B}/libnymea-sunspec/libnymea-sunspec1.so ${D}${libdir}
        install -m 0755 ${B}/libnymea-sunspec/libnymea-sunspec1.so.1 ${D}${libdir}
        install -m 0755 ${B}/libnymea-sunspec/libnymea-sunspec1.so.1.0 ${D}${libdir}
        install -m 0755 ${B}/libnymea-sunspec/libnymea-sunspec1.so.1.0.0 ${D}${libdir}
        install -m 0755 ${B}/libnymea-modbus/libnymea-modbus.so ${D}${libdir}
        install -m 0755 ${B}/libnymea-modbus/libnymea-modbus.so.1 ${D}${libdir}
        install -m 0755 ${B}/libnymea-modbus/libnymea-modbus.so.1.0 ${D}${libdir}
        install -m 0755 ${B}/libnymea-modbus/libnymea-modbus.so.1.0.0 ${D}${libdir}

	install -d ${D}${bindir}
	install -m 0755 ${B}/nymea-modbus-cli/nymea-modbus-cli ${D}${bindir}
}

ALLOW_EMPTY:${PN} = "1"
FILES:libnymea-sunspec1 = "${libdir}/libnymea-sunspec1.so \
	${libdir}/libnymea-sunspec1.so.1 \
	${libdir}/libnymea-sunspec1.so.1.0 \
	${libdir}/libnymea-sunspec1.so.1.0.0 \
	"

FILES:libnymea-modbus = "${libdir}/libnymea-modbus.so \
	${libdir}/libnymea-modbus.so.1 \
	${libdir}/libnymea-modbus.so.1.0 \
	${libdir}/libnymea-modbus.so.1.0.0 \
	"

FILES:nymea-modbus-cli = "${bindir}/nymea-modbus-cli"

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-*"
