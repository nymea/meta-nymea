DESCRIPTION = "nymea-mqtt package"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

DEPENDS = "qtbase"

SRCREV="4e32a9b273d2bd9ef6a8edc8888ef0676bfd2e26"
SRC_URI="git://github.com/guh/nymea-mqtt.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit qmake5

PACKAGES += "${PN}-test"
FILES_${PN}-test = " \
    ${datadir}/tests \
"
