DESCRIPTION = "nymea-zigbee"
SUMMARY = "ZigBee library for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zigbee/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 1.9.1
SRCREV = "f5c45240fe21d371556d1f94f21c6eecf3cad50b"
PV = "1.9.1-git${SRCPV}"

# Make dependency on qca2-qt5 optional if we do not want to support TI Zigbee backend
SRC_URI += "file://0001-Make-qca-optional-only-required-for-TI-backend.patch"

DEPENDS += "qtbase qtserialport udev"

inherit qmake5

S = "${WORKDIR}/git"
