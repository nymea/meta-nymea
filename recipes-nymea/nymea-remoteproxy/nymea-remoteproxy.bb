DESCRIPTION = "nymea-mqtt package"

#LICENSE = "GPLv2"
LICENSE = "CLOSED"

SRC_URI="git://github.com/guh/nymea-remoteproxy.git;protocol=http;branch=master"
SRCREV="cb3ef34ad3116eebe212227aa4370bf486485019"

DEPENDS += "qtbase qtwebsockets"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5

FILES_${PN} = "${libdir}/*so.* ${bindir}/*"

FILES_${PN}-dev = "${libdir}/*.so ${includedir}"
