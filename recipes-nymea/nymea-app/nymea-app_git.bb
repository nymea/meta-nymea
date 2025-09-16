DESCRIPTION = "nymea:app"
SUMMARY = "Client application for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-app/issues"

LICENSE = "GPL-3.0-only | NYMEA_COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI="git://github.com/nymea/nymea-app.git;protocol=https;branch=webasm"

# Branch: qt6-qmake
SRCREV = "42def79a542f5e6f0ba5e5a7faf56c66f0403ec9"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "qtbase nymead nymea-remoteproxy qtcharts qtquickcontrols2 qtsvg"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qt6-qmake

do_install:append() {
	# FIXME: drop icons, unneeded on this platform
	rm -rf ${D}/usr/share/icons/
}

