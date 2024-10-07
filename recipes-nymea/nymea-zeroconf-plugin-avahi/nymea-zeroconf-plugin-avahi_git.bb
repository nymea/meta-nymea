DESCRIPTION = "nymea-zeroconf-plugin-avahi"
SUMMARY = "Zeroconf plugin for nymea in order to interact with the avahi-daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zeroconf-plugin-avahi/issues"

LICENSE = "LGPL-2.1-or-later & (LGPL-3.0-or-later | NYMEA-COMMERCIAL)"
LIC_FILES_CHKSUM=" \
    file://LICENSE.LGPL2;md5=4fbd65380cdd255951079008b364516c \
    file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
    "

SRC_URI = "git://github.com/nymea/nymea-zeroconf-plugin-avahi.git;protocol=https;branch=master"
# Release: 1.9.4
SRCREV = "acae9c337ff6611525feb7f9d735d55c61a864a4"
PV = "1.9.4-git${SRCPV}"

DEPENDS += "nymea avahi"
RDEPENDS:${PN} += "nymea avahi-daemon"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
