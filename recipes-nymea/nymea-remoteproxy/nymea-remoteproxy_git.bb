DESCRIPTION = "nymea-remoteproxy package"

LICENSE = "(GPL-3.0-only & LGPL-3.0-only) | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                    file://LICENSE.GPL3;md5=500948a8f0c6fefa21e8694792e6b728 \
                    file://server/main.cpp;endline=26;md5=9fcbf3e3f5e13aa72a902b683fcb4645 \
                    file://libnymea-remoteproxyclient/proxyconnection.h;endline=26;md5=3816dea2b83fb2a2515fa26eb97b4044"

SRC_URI = "git://github.com/nymea/nymea-remoteproxy.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "ec9e32cae0821682e5ada6542a31b896d1ebd211"
PV = "git${SRCPV}"

DEPENDS += "qtbase qtwebsockets ncurses"

S = "${WORKDIR}/git"

inherit qmake5

EXTRA_QMAKEVARS_PRE += "CONFIG+=disabletests"

