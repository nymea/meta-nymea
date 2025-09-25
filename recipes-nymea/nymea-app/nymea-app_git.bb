DESCRIPTION = "nymea:app"
SUMMARY = "Client application for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-app/issues"

LICENSE = "GPL-3.0-only | NYMEA_COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI="git://github.com/nymea/nymea-app.git;protocol=https;branch=master"

# Release: 1.10.13
SRCREV = "b26d959ca5e2ee1ee52bada89f2dfaa149c05f75"
PV = "1.10.13-git${SRCPV}"

DEPENDS += "qtbase nymead nymea-remoteproxy qtcharts qtquickcontrols2 qtsvg"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install:append() {
	# FIXME: drop icons, unneeded on this platform
	rm -rf ${D}/usr/share/icons/
}

