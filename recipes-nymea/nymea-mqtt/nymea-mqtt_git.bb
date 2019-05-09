DESCRIPTION = "nymea-mqtt package"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

DEPENDS = "qtbase"

SRC_URI="git://github.com/guh/nymea-mqtt.git;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit qmake5

PACKAGES += "${PN}-test"
FILES_${PN}-test = " \
    ${datadir}/tests \
"
