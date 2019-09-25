DESCRIPTION = "nymea-zeroconf-plugin-avahi"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI="git://github.com/guh/nymea-zeroconf-plugin-avahi.git;protocol=https;branch=add-license-file"
SRCREV="${AUTOREV}"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native avahi"

require recipes-qt/qt5/qt5.inc
inherit qmake5

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/nymea/platform/libnymea_zeroconfpluginavahi.so"
