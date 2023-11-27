DESCRIPTION = "nymea"

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

inherit update-rc.d qmake5 pkgconfig

BBCLASSEXTEND += "native"

DEPENDS = "qtbase"
DEPENDS:append:class-target = " qtwebsockets qtconnectivity qtdeclarative qtserialport qtserialbus nymea-gpio nymea-remoteproxy libnymea-networkmanager nymea-mqtt nymea-zigbee influxdb"

# dpkg-parsechangelog
DEPENDS += "dpkg-native"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

SYSTEMD_SERVICE:${PN} = "nymead.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES:${PN} += "${systemd_system_unitdir}/nymead.service"

EXTRA_QMAKEVARS_PRE:class-native += "CONFIG+=piconly"

do_install:append:class-target() {

	install -d ${D}/usr/share/nymea/nymead/
	install -m 0755 ${S}/data/mac-database/mac-addresses.db ${D}/usr/share/nymea/nymead/

	if [ "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}" ] ; then
		install -d ${D}${systemd_unitdir}/system
		install -m 0644 ${S}/data/systemd/nymead.service ${D}${systemd_system_unitdir}/nymead.service
	else
		install -d ${D}${INIT_D_DIR}
		install -m 0755 ${WORKDIR}/init ${D}${INIT_D_DIR}/nymead
	fi
}

FILES:${PN}-test = "${libdir}/nymea/plugins/libnymea_integrationpluginmock.so \
	/usr/tests/* \
	/usr/share/nymea/nymead/"
PACKAGES += "${PN}-test"
