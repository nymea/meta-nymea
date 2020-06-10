DESCRIPTION = "nymea-zigbee package"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://libnymea-zigbee/zigbee.h;endline=26;md5=8145dc10125aa2f5603e524b7245a070"

SRC_URI="git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 0.0.5
SRCREV="9ddc4770a36ed539afcc704ea536bacc32cca62c"
PV = "git${SRCPV}"

DEPENDS += "qtbase qtserialport"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

