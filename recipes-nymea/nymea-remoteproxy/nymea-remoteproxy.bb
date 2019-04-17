DESCRIPTION = "nymea-mqtt package"

#LICENSE = "GPLv2"
LICENSE = "CLOSED"

SRC_URI="git://github.com/guh/nymea-remoteproxy.git;protocol=http;branch=master"
SRCREV="cb3ef34ad3116eebe212227aa4370bf486485019"

DEPENDS += "qtbase qtwebsockets"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
        # FIXME: Is there a better way to install to /usr/lib64?
        if [ "${libdir}" != "/usr/lib" ]; then
                mv ${D}/usr/lib/ ${D}/${libdir}
        fi
}
