DESCRIPTION = "nymea-zigbee package"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 0.1.0
SRCREV="90eb82401836f71aa78d25697b330c2cbc58eead"
PV = "git${SRCPV}"

DEPENDS += "qtbase qtserialport eudev"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

