DESCRIPTION = "nymea-mqtt package"

LICENSE = "(GPL-3.0-only & LGPL-3.0-only) | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
		    file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://server/main.cpp;endline=26;md5=e77ed0154a3dfe95aa49f3ac67fe9392 \
                    file://libnymea-mqtt/mqtt.h;endline=26;md5=8145dc10125aa2f5603e524b7245a070"

SRC_URI = "git://github.com/nymea/nymea-mqtt.git;protocol=https;branch=master"
# Release: 1.9.0
SRCREV = "2c7f874dd11a6308f884aef18b270bb1386a901f"
PV = "1.9.0-git${SRCPV}"

DEPENDS += "qtbase qtwebsockets openssl"
BBCLASSEXTEND += "native"

S = "${WORKDIR}/git"

inherit qmake5

do_install:append() {
	# FIXME: upstream installs tests to /usr/share/qt5 which seems wrong. Let's delete it for now
	rm -rf ${D}/usr/share/
}
