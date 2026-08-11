DESCRIPTION = "nymea-remoteproxy"
SUMMARY = "Daemon, utils and libraries for the nymea remote connection"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-remoteproxy/issues"

LICENSE = "(GPL-3.0-or-later & LGPL-3.0-or-later)"

LICENSE:${PN}-tunnelclient = "GPL-3.0-or-later"
LICENSE:${PN}-monitor = "GPL-3.0-or-later"
LICENSE:lib${PN} = "LGPL-3.0-or-later"
LICENSE:${PN}-dev = "LGPL-3.0-or-later"
LICENSE:lib${PN}client = "LGPL-3.0-or-later"
LICENSE:${PN}client-dev = "LGPL-3.0-or-later"

LIC_FILES_CHKSUM = " \
	file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
	file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
	"

SRC_URI = "git://github.com/nymea/nymea-remoteproxy.git;protocol=https;branch=master"
# Release: 1.16.0
SRCREV = "5eb7af14a251fe074a754ffe4117e5ad8e7fc9f8"
PV = "1.16.0-git${SRCPV}"

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

inherit qt6-qmake

EXTRA_QMAKEVARS_PRE += "CONFIG+=disabletests"

FILES:${PN} = "${bindir}/${PN}"

FILES:${PN}-dev = ""
ALLOW_EMPTY:${PN}-dev = "1"
RDEPENDS:${PN}-dev = "lib${PN}-dev (= ${EXTENDPKGV}) lib${PN}client-dev (= ${EXTENDPKGV})"

do_install:append() {
        # Drop test utils since they are only required for specific test environments
        rm -f ${D}${bindir}/nymea-tunnelproxy-testutils
}

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
