DESCRIPTION = "nymea-zigbee package"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 1.8.1
SRCREV="e2c9c447dd4f9050a549275bb9fcf320637e490e"
PV = "git${SRCPV}"

# Make dependency on qca2-qt5 optional if we do not want to support TI Zigbee backend
SRC_URI += "\
		file://0001-Make-qca-optional-only-required-for-TI-backend.patch \
	"

DEPENDS += "qtbase qtserialport eudev"

S = "${WORKDIR}/git"

inherit qmake5

