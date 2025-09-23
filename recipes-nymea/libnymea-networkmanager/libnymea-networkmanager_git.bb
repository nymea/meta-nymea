DESCRIPTION = "libnymea-networkmanager"
SUMMARY = "Library for nymea in order to communicate with the network-manager using DBus"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/libnymea-networkmanager/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/libnymea-networkmanager.git;protocol=https;branch=landing-silo"
# Branch: landing-silo
SRCREV = "c9aeba7f6088982c66f5aa86b37626262d16fdfc"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "qtbase qtconnectivity"

S = "${WORKDIR}/git"

inherit qmake5

