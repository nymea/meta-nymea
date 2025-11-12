DESCRIPTION = "nymea-system-plugin-systemd"
SUMMARY = "System plugin for nymea in order to use systemd services"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-remoteproxy/issues"

LICENSE = "LGPL-3.0-or-later | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-system-plugin-systemd.git;protocol=https;branch=master"
# Release: 1.12.3
SRCREV = "b3596c26de1f6d598c15e9a6f969ae6d62fefee2"
PV = "1.12.3-git${SRCPV}"

DEPENDS += "nymea nymea-native systemd"
RDEPENDS:${PN} += "nymead tzdata"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_systempluginsystemd.so"
