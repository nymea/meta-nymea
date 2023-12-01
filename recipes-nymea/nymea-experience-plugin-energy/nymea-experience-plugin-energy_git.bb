DESCRIPTION = "nymea-experience-plugin-energy"

LICENSE = "GPL-3.0-or-later | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-experience-plugin-energy.git;protocol=https;branch=master"
# Release: 1.8.1
SRCREV = "4f33ca0db54d19fc7c949ada6658c4a051297aa6"
PV = "git${SRCPV}"

DEPENDS += "nymead sqlite3"
RDEPENDS:${PN} += "libnymea-energy"
PACKAGES =+ "libnymea-energy libnymea-energy-dev"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/experiences/libnymea_experiencepluginenergy.so"

FILES:libnymea-energy = "${libdir}/libnymea-energy*${SOLIBS}"
FILES:libnymea-energy-dev = " \
        ${libdir}/libnymea-energy*${SOLIBSDEV} \
        ${libdir}/pkgconfig/nymea-energy.pc \
        ${incldir}/nymea-energy \
        "
