DESCRIPTION = "nymea-experience-plugin-energy"
SUMMARY = "Zeroconf plugin for nymea in order to interact with the avahi-daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zeroconf-plugin-avahi/issues"

LICENSE = "GPL-3.0-or-later | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-experience-plugin-energy.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "3ff137e9416bc19aeb68c30cf1a14cdc9416dcd9"
PV = "1.9.0-git${SRCPV}"

DEPENDS += "nymead sqlite3"
RDEPENDS:${PN} += "libnymea-energy"
PACKAGES =+ "libnymea-energy libnymea-energy-dev"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES:${PN} += "${libdir}/nymea/experiences/libnymea_experiencepluginenergy.so"

FILES:libnymea-energy = "${libdir}/libnymea-energy*${SOLIBS}"
FILES:libnymea-energy-dev = " \
        ${libdir}/libnymea-energy*${SOLIBSDEV} \
        ${libdir}/pkgconfig/nymea-energy.pc \
        ${incldir}/nymea-energy \
        "
