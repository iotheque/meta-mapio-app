SUMMARY = "MAPIO tools"
DESCRIPTION = "Add some specific tools for MAPIO"
HOMEPAGE = "https://github.com/iotheque/mapio-tools"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://git@github.com/iotheque/mapio-tools;protocol=https;branch=main"
SRCREV = "a08600c26e7dcce7031060bfb973da97f12a040d"

S = "${WORKDIR}/git"

FILES:${PN} += "/home/root/tools/cc2538-bsl.py"
FILES:${PN} += "/home/root/tools/configuration.json"
FILES:${PN} += "/home/root/tools/test_factory.py"

RDEPENDS:${PN} = "\
    python3-intelhex \
    python3-pyserial \
    python3-pytest \
    python3-pytest-html \
"

do_install() {
    install -d ${D}/home/root/tools
    install -m 0644 ${S}/cc2538-bsl.py ${D}/home/root/tools/cc2538-bsl.py
    install -m 0644 ${S}/configuration.json ${D}/home/root/tools/configuration.json
    install -m 0644 ${S}/test_factory.py ${D}/home/root/tools/test_factory.py
}
