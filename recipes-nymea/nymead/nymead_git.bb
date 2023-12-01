DESCRIPTION = "nymea"
SUMMARY = "An open source IoT server - daemon"
HOMEPAGE = "https://nymea.io"

LICENSE = "(GPL-3.0-only & LGPL-3.0-only) | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
                  file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://server/main.cpp;endline=26;md5=8a20c67e762ff092bbb93325ead286dc \
                  file://libnymea/libnymea.h;endline=26;md5=c334ac0bc498bb8b53007125752e1471"

SRC_URI="git://github.com/nymea/nymea.git;protocol=https;branch=master \
	file://init \
	"
# Release: 1.8.1
SRCREV="bb402e31271fe7e82b4454fb8042b20a5da957ff"
PV = "git${SRCPV}"

S = "${WORKDIR}/git"

inherit update-rc.d qmake5 pkgconfig systemd

BBCLASSEXTEND += "native"

DEPENDS = "qtbase"
DEPENDS:append:class-target = " qtwebsockets qtconnectivity qtdeclarative qtserialport qtserialbus nymea-gpio nymea-remoteproxy libnymea-networkmanager nymea-mqtt nymea-zigbee"

PACKAGES += "nymea-tests libnymea-tests nymea-data"
RPROVIDES:${PN} += "libnymea"
RRECOMMENDS:${PN} += "nymea-data"
RDEPENDS:nymea-tests += "libnymea-tests"

# dpkg-parsechangelog
DEPENDS += "dpkg-native"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

SYSTEMD_SERVICE:${PN} = "nymead.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES:${PN} += "${systemd_system_unitdir}/nymead.service"

FILES:nymea-data += "${datadir}/nymea/nymead/mac-addresses.db"

FILES:nymea-tests = " \
	${libdir}/nymea/plugins/libnymea_integrationpluginmock.so \
	${bindir}/nymeatest* \
	"

FILES:libnymea = "${libdir}/libnymea*${SOLIBS}"
FILES:libnymea-dev = " \
        ${libdir}/libnymea*${SOLIBSDEV} \
        ${libdir}/pkgconfig/nymea.pc \
        ${incldir}/nymea \
	${bindir}/nymea-plugininfocompiler \
        "

FILES:libnymea-tests = "${libdir}/libnymea-tests*${SOLIBS}"
FILES:libnymea-tests-dev = " \
        ${libdir}/libnymea-tests*${SOLIBSDEV} \
        ${libdir}/pkgconfig/nymea-tests.pc \
        ${incldir}/nymea-tests \
        "

EXTRA_QMAKEVARS_PRE:class-native += "CONFIG+=piconly"

do_install:append:class-target() {

	install -d ${D}${datadir}/nymea/nymead/
	install -m 0755 ${S}/data/mac-database/mac-addresses.db ${D}${datadir}/nymea/nymead/

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
