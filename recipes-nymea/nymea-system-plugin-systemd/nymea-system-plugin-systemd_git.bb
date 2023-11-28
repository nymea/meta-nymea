DESCRIPTION = "nymea-system-plugin-systemd"

LICENSE = "LGPL-3.0-or-later | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-system-plugin-systemd.git;protocol=https;branch=master"
# Release: 1.8.1
SRCREV="84371ab6cdbe2e82b685ad5516b56a188fc9a4d8"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native systemd"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_systempluginsystemd.so"
