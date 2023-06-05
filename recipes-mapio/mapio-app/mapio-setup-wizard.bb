SUMMARY = "MAPIO SETUP WIZARD"
DESCRIPTION = "Setup wizard for MAPIO"
HOMEPAGE = "https://github.com/pcurt/mapio-setup-wizard"
LICENSE = "CLOSED"

SRC_URI = "\
    file://mapio-setup-wizard.service \
   "

inherit systemd

FILES:${PN} += "${systemd_unitdir}/system/mapio-setup-wizard.service"

RDEPENDS:${PN} = "\
    python3-mapio-setup-wizard \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "mapio-setup-wizard.service"

do_install:append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/mapio-setup-wizard.service ${D}/${systemd_unitdir}/system/
}
