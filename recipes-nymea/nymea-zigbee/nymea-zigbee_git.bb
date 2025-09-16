DESCRIPTION = "nymea-zigbee"
SUMMARY = "ZigBee library for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zigbee/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=qt6-qmake"
# Branch: qt6-qmake
SRCREV = "63e9e424d3db3efb80a3b1a47767ab6ae76a8d29"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "qtbase qtserialport udev"

inherit qt6-qmake

S = "${WORKDIR}/git"
