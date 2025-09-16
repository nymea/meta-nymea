DESCRIPTION = "nymea-gpio"
SUMMARY = "Library and utils to interact with GPIOs for nymea"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-gpio/issues"

LICENSE = "(LGPL-3.0-only & GPL-3.0-only) | NYMEA-COMMERCIAL"
LICENSE:${PN}-utils = "GPL-3.0-only | NYMEA-COMMERCIAL"

LIC_FILES_CHKSUM=" \
	file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
	file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
	"

SRC_URI = "git://github.com/nymea/nymea-gpio.git;protocol=https;branch=qt6-qmake"
# Branch: qt6-qmake
SRCREV = "13c6e8a7e228034ff2240f20dd8a397a1265014a"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "qtbase"

inherit qt6-qmake

S = "${WORKDIR}/git"

PACKAGES += "lib${PN} ${PN}-utils lib${PN}-dev"

FILES:${PN} = ""
ALLOW_EMPTY:${PN} = "1"

FILES:${PN}-dev = ""
ALLOW_EMPTY:${PN}-dev = "1"
RDEPENDS:${PN}-dev = "lib${PN} (= ${EXTENDPKGV})"

FILES:${PN}-utils = "${bindir}/*"
RDEPENDS:${PN}-utils = "lib${PN} (= ${EXTENDPKGV})"

FILES:lib${PN} = "${libdir}/libnymea-gpio*${SOLIBS}"
FILES:lib${PN}-dev = " \
	${libdir}/libnymea-gpio*${SOLIBSDEV} \
	${libdir}/pkgconfig/nymea-gpio.pc \
	${includedir}/nymea-gpio \
	"