DESCRIPTION = "nymea:app"
SUMMARY = "Client application for the nymea daemon"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-app/issues"

LICENSE = "GPL-3.0-only | NYMEA_COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI="git://github.com/nymea/nymea-app.git;protocol=https;branch=landing-silo"

# Branch: landing-silo
SRCREV = "5a157288df23983b97159c8dddd0d2dd5f95ed38"
PV = "1.12.0-git${SRCPV}"

DEPENDS += "qtbase nymead nymea-remoteproxy qtcharts qtquickcontrols2 qtsvg"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install:append() {
	# FIXME: drop icons, unneeded on this platform
	rm -rf ${D}/usr/share/icons/
}

