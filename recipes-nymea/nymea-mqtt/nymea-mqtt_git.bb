DESCRIPTION = "nymea-mqtt"
SUMMARY = "Library and utils for native MQTT support in nymea"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-mqtt/issues"

LICENSE = "(GPL-3.0-only & LGPL-3.0-only) | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = " \
	file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
	file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
	"

SRC_URI = "git://github.com/nymea/nymea-mqtt.git;protocol=https;branch=master"
# Release: 1.9.1
SRCREV = "ba455fb8653e114874a4ce547ab1fbfd4d1ef9bb"
PV = "1.9.1-git${SRCPV}"

DEPENDS += "qtbase qtwebsockets openssl"
BBCLASSEXTEND += "native"

inherit qmake5

S = "${WORKDIR}/git"

EXTRA_QMAKEVARS_PRE += "CONFIG+=disabletests"

PACKAGES =+ "lib${PN} lib${PN}-dev ${PN}-client ${PN}-server"

FILES:${PN} = ""
ALLOW_EMPTY:${PN} = "1"

FILES:${PN}-dev = ""
ALLOW_EMPTY:${PN}-dev = "1"
RDEPENDS:${PN}-dev = "lib${PN}-dev (= ${EXTENDPKGV})"

FILES:${PN}-client = "${bindir}/${PN}-client"
RDEPENDS:${PN}-client = "lib${PN}"

FILES:${PN}-server = "${bindir}/${PN}-server"
RDEPENDS:${PN}-server = "lib${PN}"

RDEPENDS:lib${PN}-dev = "lib${PN} (= ${EXTENDPKGV})"
FILES:lib${PN} = "${libdir}/libnymea-mqtt*${SOLIBS}"
FILES:lib${PN}-dev = " \
	${libdir}/libnymea-mqtt*${SOLIBSDEV} \
	${libdir}/pkgconfig/nymea-mqtt.pc \
	${includedir}/nymea-mqtt \
	"

