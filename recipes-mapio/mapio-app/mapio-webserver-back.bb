SUMMARY = "MAPIO webserver back"
DESCRIPTION = "Backend for MAPIO webeserver"
HOMEPAGE = "https://github.com/pcurt/mapio-mapio-webserver-back"
LICENSE = "CLOSED"

SRC_URI = "\
    file://mapio-webserver-back.service \
   "

inherit systemd

FILES:${PN} += "${systemd_unitdir}/system/mapio-webserver-back.service"

RDEPENDS:${PN} = "\
    python3-mapio-webserver-back \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "mapio-webserver-back.service"

do_install:append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/mapio-webserver-back.service ${D}/${systemd_unitdir}/system/
}
