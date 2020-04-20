DESCRIPTION = "nymea-zigbee package"

LICENSE = "LGPL-3 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/guh/nymea-zigbee.git;protocol=https;branch=master"
# Release: 0.0.5
SRCREV="9ddc4770a36ed539afcc704ea536bacc32cca62c"
PV = "git${SRCPV}"

DEPENDS += "qtbase qtserialport"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

