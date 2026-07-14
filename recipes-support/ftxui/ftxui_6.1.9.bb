SUMMARY = "FTXUI - Functional Terminal (X) User interface, a C++ TUI library"
HOMEPAGE = "https://github.com/ArthurSonzogni/FTXUI"
BUGTRACKER = "https://github.com/ArthurSonzogni/FTXUI/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=602507f167b627b30ce2cd7a24d50ea3"

SRC_URI = "git://github.com/ArthurSonzogni/FTXUI.git;protocol=https;nobranch=1"
SRCREV = "5cfed50702f52d51c1b189b5f97f8beaf5eaa2a6"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = " \
	-DFTXUI_BUILD_EXAMPLES=OFF \
	-DFTXUI_BUILD_DOCS=OFF \
	-DFTXUI_BUILD_TESTS=OFF \
	-DFTXUI_ENABLE_INSTALL=ON \
	-DBUILD_SHARED_LIBS=ON \
	"

BBCLASSEXTEND = "native nativesdk"
