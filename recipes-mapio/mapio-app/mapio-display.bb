SUMMARY = "MAPIO display"
DESCRIPTION = "Display service for MAPIO"
HOMEPAGE = "https://github.com/iotheque/meta-mapio-app"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://mapio-display.service \
   "

inherit systemd

FILES:${PN} += "${systemd_unitdir}/system/mapio-display.service"

RDEPENDS:${PN} = "\
    python3-mapio-display \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "mapio-display.service"

do_install:append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/mapio-display.service ${D}/${systemd_unitdir}/system/
}
