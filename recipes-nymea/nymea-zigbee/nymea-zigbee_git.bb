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
# Release: 1.15.2
SRCREV = "c8fcd5388f2c9255f0f39c5546357188e8d9b65c"
PV = "1.15.2-git${SRCPV}"

DEPENDS += "qtbase qtserialport udev"

inherit qt6-qmake
