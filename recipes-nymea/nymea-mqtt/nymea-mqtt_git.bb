DESCRIPTION = "nymea-mqtt"
SUMMARY = "Library and utils for native MQTT support in nymea"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-mqtt/issues"

LICENSE = "(GPL-3.0-or-later & LGPL-3.0-or-later)"

LICENSE:${PN}-client = "GPL-3.0-or-later"
LICENSE:${PN}-server = "GPL-3.0-or-later"
LICENSE:lib${PN} = "LGPL-3.0-or-later"
LICENSE:lib${PN}-dev = "LGPL-3.0-or-later"

LIC_FILES_CHKSUM = " \
	file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
	file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
	"

SRC_URI = "git://github.com/nymea/nymea-mqtt.git;protocol=https;branch=master"
# Release: 1.16.0
SRCREV = "1e9df1a15a6620ac2a0f19c79504e028b5297e9c"
PV = "1.16.0-git${SRCPV}"

DEPENDS += "qtbase qtwebsockets openssl"
BBCLASSEXTEND += "native"

inherit qt6-qmake

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

