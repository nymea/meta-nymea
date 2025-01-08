DESCRIPTION = "nymea-zeroconf-plugin-dnssd"
SUMMARY = "Zeroconf plugin for nymea in order to interact with the dnssd"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-zeroconf-plugin-dnssd/issues"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "git://github.com/nymea/nymea-zeroconf-plugin-dnssd.git;protocol=https;branch=master"
# Release: 1.10.0
SRCREV = "6d37e4f62d6e96e6b8746c1a50422103bc96dbbf"
PV = "1.10.0-git${SRCPV}"

DEPENDS += "nymead mdns"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_zeroconfplugindnssd.so"
