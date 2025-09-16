DESCRIPTION = "nymea-system-plugin-systemd"
SUMMARY = "System plugin for nymea in order to use systemd services"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-remoteproxy/issues"

LICENSE = "LGPL-3.0-or-later | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-system-plugin-systemd.git;protocol=https;branch=qt6-qmake"
# Branch: qt6-qmake
SRCREV = "3d1603e8b977aa24fe37cddd1ba00d4eb466c7d7"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "nymea nymea-native systemd"
RDEPENDS:${PN} += "nymead tzdata"

inherit qt6-qmake pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_systempluginsystemd.so"
