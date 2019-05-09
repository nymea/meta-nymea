DESCRIPTION = "boblight package"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM="file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

SRC_URI="git://github.com/mzanetti/boblight.git;protocol=http;branch=master"
SRCREV="master"
#cebd885453337087fe678aef8082c96ece0a0235"
#SRC_URI[md5sum] = "033f9b25bb1ef362c43e83f2ff39eb8b"

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF += "--without-portaudio"
