DESCRIPTION = "libnymea-networkmanager"
SUMMARY = "Library for nymea in order to communicate with the network-manager using DBus"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/libnymea-networkmanager/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/libnymea-networkmanager.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "204cdd9e1955d1445a3c81270b09ece63ff27429"
PV = "1.9.0-git${SRCPV}"

DEPENDS += "qtbase qtconnectivity"

S = "${WORKDIR}/git"

inherit qmake5

