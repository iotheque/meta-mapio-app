SUMMARY = "MAPIO GPIO HA"
DESCRIPTION = "GPIO HA service for MAPIO"
HOMEPAGE = "https://github.com/iotheque/meta-mapio-app"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://mapio-gpio-ha.service \
"

inherit systemd

FILES:${PN} += "${systemd_unitdir}/system/mapio-gpio-ha.service"

RDEPENDS:${PN} = "\
    mosquitto \
    python3-mapio-gpio-ha \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "mapio-gpio-ha.service"

do_install:append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/mapio-gpio-ha.service ${D}/${systemd_unitdir}/system/
}
