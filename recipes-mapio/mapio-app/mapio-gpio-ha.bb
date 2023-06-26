SUMMARY = "MAPIO GPIO HA"
DESCRIPTION = "GPIO HA service for MAPIO"
HOMEPAGE = "https://github.com/pcurt/meta-mapio-app"
LICENSE = "CLOSED"

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
