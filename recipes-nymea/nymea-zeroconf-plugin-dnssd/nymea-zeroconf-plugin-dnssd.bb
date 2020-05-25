DESCRIPTION = "nymea-zeroconf-plugin-dnssd"

LICENSE = "LGPL-3"
LIC_FILES_CHKSUM="file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI="git://github.com/nymea/nymea-zeroconf-plugin-dnssd.git;protocol=https;branch=initial-commit"
SRCREV="c928ca6d501be771c97e63a586318a3244044704"
PV = "git${SRCPV}"

DEPENDS += "nymead"

inherit qmake5

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/nymea/platform/libnymea_zeroconfplugindnssd.so"
