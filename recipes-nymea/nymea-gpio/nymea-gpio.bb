DESCRIPTION = "nymea-gpio package"

LICENSE = "(LGPL-3.0-only & GPL-3.0-only) | NYMEA-COMMERCIAL"
LICENSE:${PN}-utils = "GPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI="git://github.com/nymea/nymea-gpio.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV="cc0e1b61be09ef21afdf35c679b250f873993681"
PV = "1.9.0-git${SRCPV}"

DEPENDS += "qtbase"

S = "${WORKDIR}/git"

PACKAGES += "${PN}-utils"

FILES:${PN} = "${libdir}/*.so.*"
FILES:${PN}-utils = "${bindir}/*"

inherit qmake5
