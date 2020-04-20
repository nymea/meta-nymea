DESCRIPTION = "nymea"

LICENSE = "GPL-3 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI="git://github.com/guh/nymea.git;protocol=https;branch=master \
	file://init \
	"
SRCREV="9af820b69683e09bba2643fd6631b407824969ec" # 0.20.0
PV = "git${SRCPV}"

S = "${WORKDIR}/git"

inherit update-rc.d qmake5

BBCLASSEXTEND += "native"

DEPENDS = "qtbase qtwebsockets qtconnectivity qtdeclarative nymea-mqtt"
DEPENDS_append_class-target = " nymea-remoteproxy"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

EXTRA_QMAKEVARS_PRE_class-native += "CONFIG+=minimal"

do_install_append_class-target() {
       install -d ${D}${INIT_D_DIR}
       install -m 0755 ${WORKDIR}/init ${D}${INIT_D_DIR}/nymead
}

FILES_${PN}-test = "${libdir}/nymea/plugins/libnymea_devicepluginmock.so \
	/usr/tests/*"
PACKAGES += "${PN}-test"
