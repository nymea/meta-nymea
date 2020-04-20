DESCRIPTION = "nymea-remoteproxy package"

LICENSE = "LGPL-3 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/guh/nymea-remoteproxy.git;protocol=https;branch=master"
SRCREV="2e1217017084a3407ce467e45976703439a8d01b" # 0.1.9
PV = "git${SRCPV}"

DEPENDS += "qtbase qtwebsockets ncurses"

S = "${WORKDIR}/git"

inherit qmake5

EXTRA_QMAKEVARS_PRE += "CONFIG+=disabletests"

