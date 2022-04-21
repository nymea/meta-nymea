DESCRIPTION = "nymea-zigbee package"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 0.1.3
SRCREV="c5d9b119af707ea66af5545754afe4c560f518b7"
PV = "git${SRCPV}"

PACKAGECONFIG[eudev] = ", , eudev"

PACKAGECONFIG ??= "eudev"

DEPENDS += "qtbase qtserialport"

S = "${WORKDIR}/git"

inherit qmake5

