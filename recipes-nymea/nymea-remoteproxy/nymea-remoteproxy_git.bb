DESCRIPTION = "nymea-remoteproxy package"
SUMMARY = "Utils and libraries for the nymea remote connection"
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

DEPENDS += "qtbase qtwebsockets ncurses"

inherit qmake5

S = "${WORKDIR}/git"

EXTRA_QMAKEVARS_PRE += "CONFIG+=disabletests"

