DESCRIPTION = "nymea-zigbee"
SUMMARY = "ZigBee library for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zigbee/issues"

LICENSE = " LGPL-3.0-or-later"
LIC_FILES_CHKSUM = " \
	file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
	file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
	"

SRC_URI = "git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 1.13.0
SRCREV = "b06ed4442c501dc2c02d9cf621d1c40507d0c6bb"
PV = "1.13.0-git${SRCPV}"

DEPENDS += "qtbase qtserialport udev"

inherit qmake5

S = "${WORKDIR}/git"
