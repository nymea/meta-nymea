FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://20-wired.network"

do_install_append() {
	install -Dm 0644 ${WORKDIR}/20-wired.network ${D}${sysconfdir}/systemd/network/20-wired.network
}
