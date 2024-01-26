DESCRIPTION = "nymea-zigbee"
SUMMARY = "ZigBee library for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zigbee/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "8e0d16466d86c9d60bb5d26ff44662ae2551d92d"
PV = "1.9.0-git${SRCPV}"

# Make dependency on qca2-qt5 optional if we do not want to support TI Zigbee backend
SRC_URI += "file://0001-Make-qca-optional-only-required-for-TI-backend.patch"

DEPENDS += "qtbase qtserialport udev"

inherit qmake5

S = "${WORKDIR}/git"
