DESCRIPTION = "nymea-app package"

LICENSE = "LGPLv3 | NYMEA_COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE;md5=3f048af7c55c4182902e50cee0b78044"

SRC_URI="gitsm://github.com/nymea/nymea-app.git;protocol=https;branch=master"
SRCREV="${AUTOREV}"
PV = "git${SRCPV}"

DEPENDS += "qtbase nymead nymea-remoteproxy qtcharts"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
	# FIXME: drop icons, unneeded on this platform
	rm -rf ${D}/usr/share/icons/
}
