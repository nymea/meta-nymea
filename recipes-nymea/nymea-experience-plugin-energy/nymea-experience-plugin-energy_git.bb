DESCRIPTION = "nymea-experience-plugin-energy"
SUMMARY = "Zeroconf plugin for nymea in order to interact with the avahi-daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zeroconf-plugin-avahi/issues"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-experience-plugin-energy.git;protocol=https;branch=master"
# Release: 1.14.2
SRCREV = "6851e83d51e716f61bcc7c4796f7495d6918935f"
PV = "1.14.2-git${SRCPV}"

DEPENDS += "nymea sqlite3"
PACKAGES =+ "libnymea-energy libnymea-energy-dev"
RDEPENDS:${PN} += "libnymea libnymea-energy (= ${EXTENDPKGV}) sqlite3"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES:${PN} += "${libdir}/nymea/experiences/libnymea_experiencepluginenergy.so"

FILES:${PN}-dev = ""
ALLOW_EMPTY:${PN}-dev = "1"
RDEPENDS:${PN}-dev = "libnymea-energy-dev"

FILES:libnymea-energy = "${libdir}/libnymea-energy*${SOLIBS}"
RDEPENDS:libnymea-energy-dev = "libnymea-energy (= ${EXTENDPKGV})"
FILES:libnymea-energy-dev = " \
        ${libdir}/libnymea-energy*${SOLIBSDEV} \
        ${libdir}/pkgconfig/nymea-energy.pc \
        ${includedir}/nymea-energy \
        "
