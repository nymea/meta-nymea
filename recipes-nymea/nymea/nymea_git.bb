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

SRC_URI = "git://github.com/nymea/nymea.git;protocol=https;branch=experimental-silo"
SRC_URI+= "file://init"
# Branch: experimental-silo
SRCREV = "${AUTOREV}"
PV = "1.16.0-git${SRCPV}"

inherit qmake5 pkgconfig systemd update-rc.d

S = "${WORKDIR}/git"

BBCLASSEXTEND += "native"

DEPENDS = "qtbase"
DEPENDS:append:class-target = " qtwebsockets qtconnectivity qtdeclarative qtserialport qtserialbus nymea-gpio nymea-remoteproxy libnymea-networkmanager nymea-mqtt nymea-zigbee"

PACKAGES += "${PN}d lib${PN} lib${PN}-dev lib${PN}-core lib${PN}-core-dev lib${PN}-tests lib${PN}-tests-dev ${PN}-data ${PN}-tests"
PROVIDES:${PN} += "${PN}d lib${PN} "
RRECOMMENDS:${PN} += "${PN}-data"

INITSCRIPT_PACKAGES = "${PN}d"
INITSCRIPT_NAME = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

SYSTEMD_SERVICE:${PN} = "nymead.service"

FILES:${PN} = ""
ALLOW_EMPTY:${PN} = "1"
RDEPENDS:${PN} = "${PN}d (= ${EXTENDPKGV})"

FILES:${PN}-dev = ""
ALLOW_EMPTY:${PN}-dev = "1"
RDEPENDS:${PN}-dev = "lib${PN}-dev lib${PN}-core-dev lib${PN}-tests-dev"

# nymead
RDEPENDS:${PN}d += "lib${PN}-core (= ${EXTENDPKGV}) lib${PN} (= ${EXTENDPKGV})"
FILES:${PN}d = " \
	${bindir}/nymead \
	${datadir}/dbus-1/system.d \
	${systemd_system_unitdir}/nymead.service \
	"

FILES:nymea-data += "${datadir}/${PN}/nymead/mac-addresses.db"
RDEPENDS:nymea-data += "${PN}d"

FILES:nymea-tests = " \
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

EXTRA_QMAKEVARS_PRE:class-native += "CONFIG+=piconly NYMEA_VERSION=${PV}"
EXTRA_QMAKEVARS_PRE:class-target += "NYMEA_VERSION=${PV} CONFIG+=withoutpython DEFINES+=ZIGBEE_DISABLE_TI"

do_install:append:class-target() {

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
