DESCRIPTION = "nymea-mqtt package"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=500948a8f0c6fefa21e8694792e6b728"

SRC_URI="git://github.com/guh/nymea-remoteproxy.git;protocol=https;branch=experimental-silo"
SRCREV="${AUTOREV}"
PV = "git${SRCPV}"

DEPENDS += "qtbase qtwebsockets ncurses"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5

EXTRA_QMAKEVARS_PRE += "CONFIG+=disabletests"

