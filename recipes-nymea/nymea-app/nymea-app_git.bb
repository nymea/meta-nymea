DESCRIPTION = "nymea-app package"

LICENSE = "GPLv3 | NYMEA_COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI="git://github.com/nymea/nymea-app.git;protocol=https;branch=master"

# Release: 1.0.305
SRCREV="efeb8bb93f257a2736fbb6cd2783432d8ecf3f11"
PV = "git${SRCPV}"

DEPENDS += "qtbase nymead nymea-remoteproxy qtcharts qtquickcontrols2 qtsvg"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
	# FIXME: drop icons, unneeded on this platform
	rm -rf ${D}/usr/share/icons/
}
