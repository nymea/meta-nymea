DESCRIPTION = "nymea-system-plugin-systemd"
SUMMARY = "System plugin for nymea in order to use systemd services"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-system-plugin-systemd/issues"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-system-plugin-systemd.git;protocol=https;branch=master"
# Release: 1.16.1
SRCREV = "4b531cbb6bc7c93dbb061a22874e7aea609050c2"
PV = "1.16.1-git${SRCPV}"

DEPENDS += "nymea nymea-sdk-native systemd"
RDEPENDS:${PN} += "nymead tzdata"

inherit qt6-qmake pkgconfig

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/nymea/platform/libnymea_systempluginsystemd.so"
