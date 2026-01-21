DESCRIPTION = "nymea-update-plugin-rauc"
SUMMARY = "Update plugin for nymea in order to interact with the rauc update system."
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-update-plugin-rauc/issues"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-update-plugin-rauc.git;protocol=https;branch=master"
# Release: 1.14.2
SRCREV = "9b005a9611344627c0f1125df0c883421f83ef50"
PV = "1.14.2-git${SRCPV}"

DEPENDS += "nymea"
RDEPENDS:${PN} += "nymead"

inherit qmake5 pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_updatepluginrauc.so"
