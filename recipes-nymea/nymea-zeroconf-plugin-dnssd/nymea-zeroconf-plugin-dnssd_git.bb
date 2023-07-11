DESCRIPTION = "nymea-zeroconf-plugin-dnssd"

LICENSE = "LGPL-3.0-only | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://platformzeroconfcontrollerdnssd.cpp;endline=29;md5=02466154ec3d6f169e687813994f869a"

SRC_URI="git://github.com/nymea/nymea-zeroconf-plugin-dnssd.git;protocol=https;branch=master"
# Release: 1.8.1
SRCREV="76d6196a5ceb98ba84ad6b19e541d50f8cf0ae64"
PV = "git${SRCPV}"

DEPENDS += "nymead mdns"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_zeroconfplugindnssd.so"
