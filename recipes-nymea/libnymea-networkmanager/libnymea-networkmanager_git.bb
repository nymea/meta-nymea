DESCRIPTION = "libnymea-networkmanager"
SUMMARY = "Library for nymea in order to communicate with the network-manager using DBus"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/libnymea-networkmanager/issues"

LICENSE = "(LGPL-3.0-or-later)"
LIC_FILES_CHKSUM = " \
	file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
	file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
	"

SRC_URI="git://github.com/nymea/libnymea-networkmanager.git;protocol=https;branch=master"
# Release: 1.15.2
SRCREV = "6aa7dcd6fbf581c4a69847ea529bd38e839323d6"
PV = "1.15.2-git${SRCPV}"

DEPENDS += "qtbase qtconnectivity"

S = "${WORKDIR}/git"

inherit qmake5

