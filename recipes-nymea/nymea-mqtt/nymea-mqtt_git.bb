DESCRIPTION = "nymea-mqtt package"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

SRC_URI="git://github.com/guh/nymea-mqtt.git;protocol=https;branch=master"
SRCREV="0.1.2"
PV = "git${SRCPV}"

DEPENDS += "qtbase"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
	# FIXME: upstream installs tests to /usr/share/qt5 which seems wrong. Let's delete it for now
	rm -rf ${D}/usr/share/
}
