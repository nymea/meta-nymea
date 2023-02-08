DESCRIPTION = "nymea"

LICENSE = "(GPL-3.0-only & LGPL-3.0-only) | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
                  file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://server/main.cpp;endline=26;md5=8a20c67e762ff092bbb93325ead286dc \
                  file://libnymea/libnymea.h;endline=26;md5=c334ac0bc498bb8b53007125752e1471"

SRC_URI="git://github.com/nymea/nymea.git;protocol=https;branch=master \
	file://init \
	"
# Release: 1.0.0
SRCREV="bb03d17c799ff4e41920f094b166e8da8009e35d"
PV = "git${SRCPV}"

S = "${WORKDIR}/git"

inherit update-rc.d qmake5 pkgconfig

BBCLASSEXTEND += "native"

DEPENDS = "qtbase"
DEPENDS:append:class-target = " qtwebsockets qtconnectivity qtdeclarative nymea-gpio nymea-remoteproxy libnymea-networkmanager nymea-mqtt nymea-zigbee"

# dpkg-parsechangelog
DEPENDS += "dpkg-native"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

EXTRA_QMAKEVARS_PRE:class-native += "CONFIG+=piconly"

do_install:append:class-target() {
       install -d ${D}${INIT_D_DIR}
       install -m 0755 ${WORKDIR}/init ${D}${INIT_D_DIR}/nymead
}

FILES:${PN}-test = "${libdir}/nymea/plugins/libnymea_integrationpluginmock.so \
	/usr/tests/*"
PACKAGES += "${PN}-test"
