DESCRIPTION = "nymea-app package"

LICENSE = "GPL-3.0-only | NYMEA_COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI="git://github.com/nymea/nymea-app.git;protocol=https;branch=master"

# Release: 1.8.19
SRCREV="b4ce1e7c39da5be5e68404a9ce357cb1f04dd2cb"
PV = "git${SRCPV}"

DEPENDS += "qtbase nymead nymea-remoteproxy qtcharts qtquickcontrols2 qtsvg"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install:append() {
	# FIXME: drop icons, unneeded on this platform
	rm -rf ${D}/usr/share/icons/
}
