DESCRIPTION = "nymea-zeroconf-plugin-avahi"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI="git://github.com/nymea/nymea-zeroconf-plugin-avahi.git;protocol=https"
# Release: 0.9
SRCREV="15dbe87f15e11471f6f0d985ae25ce42678b3ad6"
PV = "git${SRCPV}"

DEPENDS += "nymead avahi"

inherit qmake5

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
