DESCRIPTION = "nymea-zigbee package"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

SRC_URI="git://github.com/guh/nymea-zigbee.git;protocol=https;branch=master"
SRCREV="0.0.3"
PV = "git${SRCPV}"

DEPENDS += "qtbase qtserialport"
BBCLASSEXTEND += "native"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5

