DESCRIPTION = "nymead"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

SRC_URI="git://github.com/guh/nymea.git;protocol=https;branch=fix-include-installs \
	file://init \
	"

SRCREV="fix-include-installs"

require recipes-qt/qt5/qt5.inc
inherit qmake5

DEPENDS += "qtbase qtwebsockets qtconnectivity nymea-mqtt nymea-remoteproxy"

S = "${WORKDIR}/git"

inherit update-rc.d qmake5

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

do_install_append() {
	install -d ${D}${INIT_D_DIR}
	install -m 0755 ${WORKDIR}/init ${D}${INIT_D_DIR}/nymead
}

FILES_${PN}-dev += "${libdir}/nymea.pc"

FILES_${PN}-test = "${libdir}/nymea/plugins/libnymea_devicepluginmock.so \
	/usr/tests/*"
PACKAGES += "${PN}-test"
