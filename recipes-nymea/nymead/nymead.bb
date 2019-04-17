DESCRIPTION = "nymead"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

SRC_URI="git://github.com/guh/nymea.git;protocol=http;branch=more-generic-pro"
SRCREV="more-generic-pro"

DEPENDS += "qtbase qtwebsockets qtconnectivity nymea-mqtt nymea-remoteproxy"

require recipes-qt/qt5/qt5.inc

S = "${WORKDIR}/git"

inherit qmake5

FILES_${PN}-test = "${libdir}/nymea/plugins/libnymea_devicepluginmock.so \
	/usr/tests/*"
PACKAGES += "${PN}-test"
