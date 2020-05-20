DESCRIPTION = "nymea-mqtt package"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/guh/nymea-mqtt.git;protocol=https;branch=master"
# Release: 0.1.5
SRCREV="c2133e5539fbe2df6c9252814549a42ae29c8e1a"
PV = "git${SRCPV}"

DEPENDS += "qtbase"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
	# FIXME: upstream installs tests to /usr/share/qt5 which seems wrong. Let's delete it for now
	rm -rf ${D}/usr/share/
}
