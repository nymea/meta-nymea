DESCRIPTION = "nymea"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

SRC_URI="git://github.com/guh/nymea.git;protocol=https;branch=fix-include-installs \
	file://init \
	"
SRCREV="${AUTOREV}"
PV = "git${SRCPV}"

S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc
inherit update-rc.d qmake5

BBCLASSEXTEND =+ "native"

DEPENDS_class-target += "qtbase qtwebsockets qtconnectivity nymea-mqtt nymea-remoteproxy avahi"
DEPENDS_class-native += "python"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

do_configure_class-native() {
}
do_compile_class-native() {
}
do_install_class-native() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/libnymea/plugin/nymea-generateplugininfo ${D}${bindir}
}

do_install_append_class-target() {
	install -d ${D}${INIT_D_DIR}
	install -m 0755 ${WORKDIR}/init ${D}${INIT_D_DIR}/nymead
}

FILES_${PN}-test = "${libdir}/nymea/plugins/libnymea_devicepluginmock.so \
	/usr/tests/*"
PACKAGES += "${PN}-test"
