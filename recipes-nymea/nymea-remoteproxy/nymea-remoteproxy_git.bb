DESCRIPTION = "nymea-remoteproxy"
SUMMARY = "Daemon, utils and libraries for the nymea remote connection"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-remoteproxy/issues"

LICENSE = "(GPL-3.0-only & LGPL-3.0-only) | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
    file://LICENSE.GPL3;md5=500948a8f0c6fefa21e8694792e6b728 \
    "

SRC_URI = "git://github.com/nymea/nymea-remoteproxy.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "ec9e32cae0821682e5ada6542a31b896d1ebd211"
PV = "1.9.0-git${SRCPV}"

PACKAGE_BEFORE_PN ?= ""

PACKAGES =+ " \
    lib${PN}\
    lib${PN}-dev \
    lib${PN}client \
    lib${PN}client-dev \
    ${PN}-tunnelclient \
    ${PN}-monitor \
    "

DEPENDS += "qtbase qtwebsockets ncurses"
RDEPENDS:${PN} += "libnymea-remoteproxy"

inherit qmake5 

S = "${WORKDIR}/git"

EXTRA_QMAKEVARS_PRE += "CONFIG+=disabletests"

FILES:${PN} = "${bindir}/${PN}"

FILES:${PN}-dev = ""
ALLOW_EMPTY:${PN}-dev = "1"
RDEPENDS:${PN}-dev = "lib${PN}-dev (= ${EXTENDPKGV}) lib${PN}client-dev (= ${EXTENDPKGV})"

# Client libs for the nymea-remoteproxy connections
FILES:lib${PN}client = "${libdir}/lib${PN}client.so.*"
RDEPENDS:lib${PN}client-dev = "lib${PN}client (= ${EXTENDPKGV})"
FILES:lib${PN}client-dev = " \
        ${libdir}/lib${PN}client.so \
        ${libdir}/pkgconfig/${PN}client.pc \
        ${includedir}/${PN}client \
        "

# Libs for the nymea-remoteproxy daemon
FILES:lib${PN} = "${libdir}/lib${PN}.so.*"
RDEPENDS:lib${PN}-dev = "lib${PN} (= ${EXTENDPKGV})"
FILES:lib${PN}-dev = " \
        ${libdir}/lib${PN}.so \
        ${libdir}/pkgconfig/${PN}.pc \
        ${includedir}/${PN} \
        "

FILES:${PN}-tunnelclient += "${bindir}/${PN}-tunnelclient"
RDEPENDS:${PN}-tunnelclient += "lib${PN}client (= ${EXTENDPKGV})"

FILES:${PN}-monitor += "${bindir}/${PN}-monitor"
