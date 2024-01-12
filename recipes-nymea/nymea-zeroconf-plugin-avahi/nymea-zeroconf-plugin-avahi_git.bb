DESCRIPTION = "nymea-zeroconf-plugin-avahi"

LICENSE = "LGPL-2.1-or-later & (LGPL-3.0-or-later | NYMEA-COMMERCIAL)"
LIC_FILES_CHKSUM=" \
                  file://LICENSE.LGPL2;md5=4fbd65380cdd255951079008b364516c \
                  file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://zeroconfservicebrowseravahi.h;endline=29;md5=02466154ec3d6f169e687813994f869a \
                  "

SRC_URI = "git://github.com/nymea/nymea-zeroconf-plugin-avahi.git;protocol=https;branch=master"

# Release: 1.9.0
SRCREV = "b86f6a13d964140b5738ac79db8e59d13df04ad7"
PV = "git${SRCPV}"

DEPENDS += "nymead avahi"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
