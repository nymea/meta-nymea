DESCRIPTION = "nymea-zeroconf-plugin-dnssd"
SUMMARY = "Zeroconf plugin for nymea in order to interact with the dnssd"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zeroconf-plugin-dnssd/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-zeroconf-plugin-dnssd.git;protocol=https;branch=master"
# Release: 1.12.2
SRCREV = "f399777cf36e3c793bc2db051fb181a9f65d2fe5"
PV = "1.12.2-git${SRCPV}"

DEPENDS += "nymead mdns"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_zeroconfplugindnssd.so"
