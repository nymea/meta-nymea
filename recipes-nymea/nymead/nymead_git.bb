DESCRIPTION = "nymead"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

DEPENDS = " \
    avahi \
    nymea-mqtt \
    nymea-remoteproxy \
    qtbase \
    qtconnectivity \
    qtwebsockets \
"

SRCREV="cd76c8b4bf4f53d5ea9faf66d721107bdcebf439"
SRC_URI = " \
    git://github.com/guh/nymea.git;protocol=https;branch=fix-include-installs \
    file://${PN}.initd \
    file://${PN}.service \
"

S = "${WORKDIR}/git"

inherit qmake5 systemd update-rc.d

SYSTEMD_SERVICE_${PN} = "${PN}.service"
INITSCRIPT_NAME = "${PN}"

do_install_append() {
    install -d ${D}${sysconfdir}
    ln -sf /data/etc/nymea ${D}${sysconfdir}
    install -d ${D}${localstatedir}/lib
    ln -sf /data/var/lib/nymea ${D}${localstatedir}/lib

    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -Dm 0644 ${WORKDIR}/${PN}.service ${D}${systemd_system_unitdir}/${PN}.service
    fi
    if ${@bb.utils.contains('DISTRO_FEATURES','sysvinit','true','false',d)}; then
        install -Dm 0755 ${WORKDIR}/${PN}.initd ${D}${INIT_D_DIR}/${PN}
    fi
}

PACKAGES =+ "${PN}-test"
FILES_${PN}-test = " \
    ${libdir}/nymea/plugins/libnymea_devicepluginmock.so \
    ${prefix}/tests \
"

FILES_${PN}-dev += "${libdir}/nymea.pc"

RDEPENDS_${PN} += " \
   avahi-daemon \
"
