DESCRIPTION = "nymea-mqtt package"

#LICENSE = "GPLv2"
LICENSE = "CLOSED"

SRC_URI="git://github.com/guh/nymea-mqtt.git;protocol=http;branch=master"
SRCREV="8e649b6cd7668466c31e5e21fe5c659f9e6d7cfd"

DEPENDS += "qtbase"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
	rm -rf ${D}/usr/share/
	# FIXME: Is there a better way to install to /usr/lib64?
	if [ "${libdir}" != "/usr/lib" ]; then
		mv ${D}/usr/lib/ ${D}/${libdir}
	fi
}
