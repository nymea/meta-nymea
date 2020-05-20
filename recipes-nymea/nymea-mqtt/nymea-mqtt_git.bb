DESCRIPTION = "nymea-mqtt package"

LICENSE = "(GPL-3.0 & LGPL-3.0) | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
                  file://server/main.cpp;endline=26;md5=6ad94e4fdc53ed04d6af1e48393a1d49 \
                  file://libnymea-mqtt/mqtt.h;endline=26;md5=8145dc10125aa2f5603e524b7245a070"

SRC_URI="git://github.com/guh/nymea-mqtt.git;protocol=https;branch=master"
# Release: 0.1.5
SRCREV="c2133e5539fbe2df6c9252814549a42ae29c8e1a"
PV = "git${SRCPV}"

DEPENDS += "qtbase"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
	# FIXME: upstream installs tests to /usr/share/qt5 which seems wrong. Let's delete it for now
	rm -rf ${D}/usr/share/
}
