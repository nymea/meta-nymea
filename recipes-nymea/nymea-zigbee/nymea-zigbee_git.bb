DESCRIPTION = "nymea-zigbee"
SUMMARY = "ZigBee library for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zigbee/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 1.12.0
SRCREV = "b3ae2734e80c29228f6b291c9a2f10d330f7d585"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "qtbase qtserialport udev"

inherit qmake5

S = "${WORKDIR}/git"
