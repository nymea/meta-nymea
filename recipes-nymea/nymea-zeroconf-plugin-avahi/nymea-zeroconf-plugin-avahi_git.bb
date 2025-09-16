DESCRIPTION = "nymea-zeroconf-plugin-avahi"
SUMMARY = "Zeroconf plugin for nymea in order to interact with the avahi-daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zeroconf-plugin-avahi/issues"

LICENSE = "LGPL-2.1-or-later & (LGPL-3.0-or-later | NYMEA-COMMERCIAL)"
LIC_FILES_CHKSUM=" \
    file://LICENSE.LGPL2;md5=4fbd65380cdd255951079008b364516c \
    file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
    "

SRC_URI = "git://github.com/nymea/nymea-zeroconf-plugin-avahi.git;protocol=https;branch=qt6-qmake"
# Branch: qt6-qmake
SRCREV = "ba922528cf9569bc16fee1ad2025a40441275248"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "nymea avahi"
RDEPENDS:${PN} += "nymea avahi-daemon"

inherit qt6-qmake pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
