DESCRIPTION = "boblight package"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM="file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

SRC_URI="git://github.com/mzanetti/boblight.git;protocol=https"
SRCREV="c1393f3d784f493f48f7223ba8410eae1b6e891b"
PV="git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS += "libusb"

inherit autotools

EXTRA_OECONF += "--without-portaudio --without-x11"
