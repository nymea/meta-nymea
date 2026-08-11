DESCRIPTION = "nymea-sdk"
SUMMARY = "nymea plugin info compiler for the host system"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea/issues"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea.git;protocol=https;branch=master"
# Release: 1.16.0
SRCREV = "a0ca3acad66f6240472eac5932b6d0d362c402e4"
PV = "1.16.0-git${SRCPV}"

inherit qt6-qmake

S = "${WORKDIR}/git"

BBCLASSEXTEND += "native"

DEPENDS += "qtbase-native"

EXTRA_QMAKEVARS_PRE += "CONFIG+=piconly NYMEA_VERSION=${PV}"

FILES:${PN} += "${bindir}/nymea-plugininfocompiler"

FILES:${PN}-dev = ""
ALLOW_EMPTY:${PN}-dev = "1"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/tools/nymea-plugininfocompiler/nymea-plugininfocompiler ${D}${bindir}/nymea-plugininfocompiler
}
