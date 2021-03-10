DESCRIPTION = "nymea-zigbee package"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 0.1.1
SRCREV="977938c49fb95ece49f61638113118f250ed648d"
PV = "git${SRCPV}"

DEPENDS += "qtbase qtserialport eudev"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

