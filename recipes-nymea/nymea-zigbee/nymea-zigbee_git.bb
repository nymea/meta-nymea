DESCRIPTION = "nymea-zigbee package"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

SRC_URI="git://github.com/guh/nymea-zigbee.git;protocol=https;branch=add-license-file"
SRCREV="${AUTOREV}"
PV = "git${SRCPV}"

DEPENDS += "qtbase"
BBCLASSEXTEND += "native"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5

