DESCRIPTION = "nymea-zeroconf-plugin-avahi"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI="git://github.com/nymea/nymea-zeroconf-plugin-avahi.git;protocol=https"
SRCREV="0.5"
PV = "git${SRCPV}"

DEPENDS += "nymead avahi"

inherit qmake5

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
