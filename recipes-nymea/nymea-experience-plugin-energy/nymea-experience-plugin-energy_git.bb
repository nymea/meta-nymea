DESCRIPTION = "nymea-experience-plugin-energy"

LICENSE = "GPL-3.0-or-later | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-experience-plugin-energy.git;protocol=https;branch=master"
# Release: 1.8.1
SRCREV = "4f33ca0db54d19fc7c949ada6658c4a051297aa6"
PV = "git${SRCPV}"

DEPENDS += "nymead sqlite3"

PACKAGES =+ "libnymea-energy"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/experiences/libnymea_experiencepluginenergy.so"

do_install:append:class-target() {
        install -d ${D}${libdir}
        install -m 0755 ${B}/libnymea-energy/libnymea-energy.so ${D}${libdir}
        install -m 0755 ${B}/libnymea-energy/libnymea-energy.so.1 ${D}${libdir}
        install -m 0755 ${B}/libnymea-energy/libnymea-energy.so.1.0 ${D}${libdir}
        install -m 0755 ${B}/libnymea-energy/libnymea-energy.so.1.0.0 ${D}${libdir}
}

FILES:libnymea-energy = "${libdir}/libnymea-energy.so \
        ${libdir}/libnymea-energy.so.1 \
        ${libdir}/libnymea-energy.so.1.0 \
        ${libdir}/libnymea-energy.so.1.0.0 \
        "
