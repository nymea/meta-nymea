DESCRIPTION = "nymead"

#LICENSE = "GPLv2"
LICENSE = "CLOSED"

SRC_URI="git://github.com/guh/nymea.git;protocol=http;branch=more-generic-pro"
SRCREV="bd1441ef8223f43ae90b9dea2289d31d7a7b32a4"

DEPENDS += "qtbase qtwebsockets qtconnectivity nymea-mqtt nymea-remoteproxy"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
	# Remove mock plugin and tests, for now
	rm -rf ${D}/usr/lib/nymea/
	rm -rf ${D}/usr/tests/

        # FIXME: Is there a better way to install to /usr/lib64?
        if [ "${libdir}" != "/usr/lib" ]; then
                mv ${D}/usr/lib/ ${D}/${libdir}
        fi
}
