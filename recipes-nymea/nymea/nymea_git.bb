DESCRIPTION = "nymea"
SUMMARY = "An open source IoT server"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea/issues"

LICENSE = "(GPL-3.0-or-later & LGPL-3.0-or-later)"

LICENSE:${PN}d = "GPL-3.0-or-later"
LICENSE:${PN}-data = "GPL-3.0-or-later"
LICENSE:${PN}-tests = "GPL-3.0-or-later"
LICENSE:lib${PN} = "LGPL-3.0-or-later"
LICENSE:lib${PN}-dev = "LGPL-3.0-or-later"
LICENSE:lib${PN}-core = "LGPL-3.0-or-later"
LICENSE:lib${PN}-core-dev = "LGPL-3.0-or-later"
LICENSE:lib${PN}-tests = "LGPL-3.0-or-later"
LICENSE:lib${PN}-tests-dev = "LGPL-3.0-or-later"

LIC_FILES_CHKSUM = " \
	file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
	file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
	"

SRC_URI = "git://github.com/nymea/nymea.git;protocol=https;branch=master"
SRC_URI += "file://init"
# Release: 1.15.0
SRCREV = "6650cb21c84ec84dbbd8cfc7ca778f6ea9faee09"
PV = "1.15.0-git${SRCPV}"

inherit qt6-qmake pkgconfig systemd update-rc.d

DEPENDS = "qtbase nymea-sdk-native"
DEPENDS:append = " qtwebsockets qtconnectivity qtdeclarative qtserialport qtserialbus qt5compat nymea-gpio nymea-remoteproxy libnymea-networkmanager nymea-mqtt nymea-zigbee"

EXTRA_QMAKEVARS_PRE += "NYMEA_VERSION=${PV} CONFIG+=withoutpython"

PACKAGES += "${PN}d lib${PN} lib${PN}-dev lib${PN}-core lib${PN}-core-dev lib${PN}-tests lib${PN}-tests-dev ${PN}-data ${PN}-tests"
PROVIDES:${PN} += "${PN}d lib${PN} "
RRECOMMENDS:${PN} += "${PN}-data"

INITSCRIPT_PACKAGES = "${PN}d"
INITSCRIPT_NAME:${PN}d = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

SYSTEMD_SERVICE:${PN}d = "nymead.service"

# Empty nymea package provides nymead
FILES:${PN} = ""
ALLOW_EMPTY:${PN} = "1"
RDEPENDS:${PN} = "${PN}d (= ${EXTENDPKGV})"

# nymea-dev is empty and provides the dev libs
FILES:${PN}-dev = ""
ALLOW_EMPTY:${PN}-dev = "1"
RDEPENDS:${PN}-dev = "lib${PN}-dev lib${PN}-core-dev lib${PN}-tests-dev"

# nymead
RDEPENDS:${PN}d += "lib${PN}-core (= ${EXTENDPKGV}) lib${PN} (= ${EXTENDPKGV})"
FILES:${PN}d = " \
	${bindir}/nymead \
	${datadir}/dbus-1/system.d \
	${sysconfdir}/init.d/nymead \
	${systemd_system_unitdir}/nymead.service \
	"

FILES:${PN}-data += "${datadir}/${PN}/nymead/mac-addresses.db"
RDEPENDS:${PN}-data += "${PN}d"

RDEPENDS:${PN}-tests = "lib${PN}-tests (= ${EXTENDPKGV})"
FILES:${PN}-tests = " \
	${libdir}/nymea/plugins/libnymea_integrationpluginmock.so \
	/usr/share/tests/${PN}/* \
	"

FILES:lib${PN} = "${libdir}/lib${PN}.so.*"
RDEPENDS:lib${PN}-dev = "lib${PN} (= ${EXTENDPKGV})"
FILES:lib${PN}-dev = " \
	${bindir}/${PN}-plugininfocompiler \
	${libdir}/lib${PN}.so \
	${libdir}/pkgconfig/${PN}.pc \
	${includedir}/${PN} \
	"

FILES:lib${PN}-core = "${libdir}/lib${PN}-core.so.*"
RDEPENDS:lib${PN}-core-dev = "lib${PN}-core (= ${EXTENDPKGV})"
FILES:lib${PN}-core-dev = " \
	${libdir}/lib${PN}-core.so \
	${libdir}/pkgconfig/${PN}-core.pc \
	${includedir}/${PN}-core \
	"

FILES:lib${PN}-tests = "${libdir}/lib${PN}-tests.so.*"
RDEPENDS:lib${PN}-tests-dev = "lib${PN}-core-dev (= ${EXTENDPKGV})"
FILES:lib${PN}-tests-dev = " \
	${libdir}/lib${PN}-tests.so \
	${libdir}/pkgconfig/${PN}-tests.pc \
	${includedir}/${PN}-tests \
	"

# FIXME: Wall error in building the libynmea-tests (error: "QT_TESTCASE_BUILDDIR" redefined).
# Allowed the libnymea-tests-dev package to be generated even when it has
# no payload by marking it as an empty package, ensuring the nymea-dev dependency
# can be satisfied. Once fixed, we can enable the tests also for yocto
ALLOW_EMPTY:lib${PN}-tests-dev = "1"

# Note: the tests have been disabled due to a Qt bug (error: "QT_TESTCASE_BUILDDIR" redefined)
# Since we don't need tests and testlib on yocot, we disable the libnymea-tests (and libnymea-tests-dev)
EXTRA_QMAKEVARS_PRE += "NYMEA_VERSION=${PV} CONFIG+=withoutpython DEFINES+=ZIGBEE_DISABLE_TI CONFIG+=disabletesting"

do_install:append() {

	install -d ${D}${datadir}/nymea/nymead/
	install -m 0644 ${S}/data/mac-database/mac-addresses.db ${D}${datadir}/nymea/nymead/

	install -d ${D}${datadir}/dbus-1/system.d/
	install -m 0644 ${S}/data/dbus-1/io.nymea.nymead.conf ${D}${datadir}/dbus-1/system.d/
	# The io.guh.nymead dbus interface is deprecated and will be removed with 1.15.0
	install -m 0644 ${S}/data/dbus-1/io.guh.nymead.conf ${D}${datadir}/dbus-1/system.d/

	if [ "${@bb.utils.filter('DISTRO_FEATURES', 'sysvinit', d)}" ] ; then
		install -d ${D}${INIT_D_DIR}
		install -m 0755 ${WORKDIR}/init ${D}${INIT_D_DIR}/nymead
	elif [ "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}" ] ; then
		install -d ${D}${systemd_system_unitdir}
		install -m 0644 ${S}/data/systemd/nymead.service ${D}${systemd_system_unitdir}/nymead.service
	else
		bbwarn "Not using sysvinit or systemd. The nymead daemon may require additional configuration."
	fi
}
