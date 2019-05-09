DESCRIPTION = "nymea-mqtt package"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=500948a8f0c6fefa21e8694792e6b728"

SRC_URI="git://github.com/guh/nymea-remoteproxy.git;protocol=https;branch=master"
SRCREV="master"

DEPENDS += "qtbase qtwebsockets"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5
