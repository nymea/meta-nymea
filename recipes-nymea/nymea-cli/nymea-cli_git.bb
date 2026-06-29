DESCRIPTION = "nymea command line interface"
SUMMARY = "Terminal-only client for nymead based on FTXUI"
HOMEPAGE = "https://nymea.io"
BUGTRACKER = "https://github.com/nymea/nymea-cli/issues"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/nymea/nymea-cli.git;protocol=https;branch=master"
# Release: 1.15.2
SRCREV = "9ab74e6c446927b3cb45363c5cc3ce35de98e946"
PV = "1.15.2-git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "qtbase ftxui"

inherit qt6-cmake

# Build against the system FTXUI provided by the ftxui recipe; never fetch on our own.
EXTRA_OECMAKE += " \
	-DCMAKE_DISABLE_FIND_PACKAGE_Python3=ON \
	-DNYMEA_USE_SYSTEM_FTXUI=ON \
	-DNYMEA_ALLOW_FETCHCONTENT_FTXUI=OFF \
	"

# bash-completion file is not covered by default FILES; man page lands in -doc.
FILES:${PN} += "${datadir}/bash-completion/completions/nymea-cli"
