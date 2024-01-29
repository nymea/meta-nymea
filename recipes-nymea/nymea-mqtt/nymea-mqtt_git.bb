DESCRIPTION = "nymea-mqtt"
SUMMARY = "Library and utils for native MQTT support in nymea"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-mqtt/issues"

LICENSE = "(GPL-3.0-only & LGPL-3.0-only) | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = " \
	file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
	file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
	"

SRC_URI = "git://github.com/nymea/nymea-mqtt.git;protocol=https;branch=add-disable-tests-option"
# Release: 1.9.0
SRCREV = "166823ab6578bdbf97c5996e84205042c9eef90b"
PV = "1.9.0-git${SRCPV}"

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

