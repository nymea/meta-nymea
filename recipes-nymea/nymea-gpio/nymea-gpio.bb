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

SRC_URI="git://github.com/nymea/nymea-gpio.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV="cc0e1b61be09ef21afdf35c679b250f873993681"
PV = "1.9.0-git${SRCPV}"

DEPENDS += "qtbase"

inherit qmake5

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