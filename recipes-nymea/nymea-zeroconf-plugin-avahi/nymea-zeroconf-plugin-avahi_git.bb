DESCRIPTION = "nymea-zeroconf-plugin-avahi"
SUMMARY = "Zeroconf plugin for nymea in order to interact with the avahi-daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zeroconf-plugin-avahi/issues"

LICENSE = "LGPL-2.1-or-later & (LGPL-3.0-or-later | NYMEA-COMMERCIAL)"
LIC_FILES_CHKSUM=" \
    file://LICENSE.LGPL2;md5=4fbd65380cdd255951079008b364516c \
    file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
    "

SRC_URI = "git://github.com/nymea/nymea-zeroconf-plugin-avahi.git;protocol=https;branch=landing-silo"
# Branch: landing-silo
SRCREV = "cadf6f211de62d6105d0fbe501b27c24b3088a61"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "nymea avahi"
RDEPENDS:${PN} += "nymea avahi-daemon"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
