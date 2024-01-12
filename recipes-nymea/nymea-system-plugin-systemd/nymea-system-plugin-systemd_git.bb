DESCRIPTION = "nymea-system-plugin-systemd"

LICENSE = "LGPL-3.0-or-later | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-system-plugin-systemd.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "ed270cbc10b46cee9987b390e4e77513ef3bfb5d"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native systemd"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_systempluginsystemd.so"
