DESCRIPTION = "nymea-zeroconf-plugin-avahi"

LICENSE = "LGPL-2.1+ & (LGPL-3.0+ | NYMEA-COMMERCIAL)"
LIC_FILES_CHKSUM=" \
                  file://LICENSE.LGPL2;md5=4fbd65380cdd255951079008b364516c \
                  file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://zeroconfservicebrowseravahi.h;endline=29;md5=02466154ec3d6f169e687813994f869a \
                  "

SRC_URI="git://github.com/nymea/nymea-zeroconf-plugin-avahi.git;protocol=https"
# Release: 0.9
SRCREV="15dbe87f15e11471f6f0d985ae25ce42678b3ad6"
PV = "git${SRCPV}"

DEPENDS += "nymead avahi"

inherit qmake5

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
