DESCRIPTION = "nymea-mqtt package"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=500948a8f0c6fefa21e8694792e6b728"

DEPENDS = "qtbase qtwebsockets"

SRCREV="b14da5de6bf36badd068bb9d6d7a0d49ea205613"
SRC_URI="git://github.com/guh/nymea-remoteproxy.git;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit qmake5
