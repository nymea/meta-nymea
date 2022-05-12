DESCRIPTION = "nymea-gpio package"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LICENSE_${PN}-utils = "LICENSE.GPL3 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LPGL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI="git://github.com/nymea/nymea-gpio.git;protocol=https;branch=master"
# Release: 1.0.0
SRCREV="83b913ae3aec7b566b39376ceb0bc9de575a7065"
PV = "git${SRCPV}"

DEPENDS += "qtbase"

S = "${WORKDIR}/git"

PACKAGES += "${PN}-utils"

FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-utils = "${bindir}/*"

inherit qmake5
