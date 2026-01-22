DESCRIPTION = "nymea-zeroconf-plugin-avahi"
SUMMARY = "Zeroconf plugin for nymea in order to interact with the avahi-daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zeroconf-plugin-avahi/issues"

LICENSE = "LGPL-2.1-or-later & (GPL-3.0-or-later)"

LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPL2;md5=4fbd65380cdd255951079008b364516c \
    file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
    "

SRC_URI = "git://github.com/nymea/nymea-zeroconf-plugin-avahi.git;protocol=https;branch=master"
# Release: 1.14.0
SRCREV = "36e3839640844f3f0568d6ee3ca8944711660b69"
PV = "1.14.0-git${SRCPV}"

DEPENDS += "nymea avahi"
RDEPENDS:${PN} += "nymea avahi-daemon"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
