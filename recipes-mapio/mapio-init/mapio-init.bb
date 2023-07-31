SUMMARY = "MAPIO Initialization"
DESCRIPTION = "Initialization service for MAPIO"
HOMEPAGE = "https://github.com/pcurt/meta-mapio-app"
LICENSE = "CLOSED"

SRC_URI = "\
    file://mapio-init.sh \
    file://mapio-init.service \
    file://usr-local-nvme.mount \
    file://usr-local-nvme.automount \
    file://os-version\
   "

inherit systemd

FILES:${PN} += "${systemd_unitdir}/system/mapio-init.service"
FILES:${PN} += "${systemd_unitdir}/system/usr-local-nvme.mount"
FILES:${PN} += "${systemd_unitdir}/system/usr-local-nvme.automount"
FILES:${PN} += "${bindir}/mapio-init.sh"

RDEPENDS:${PN} = "\
    bash \
    e2fsprogs-resize2fs \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "mapio-init.service usr-local-nvme.automount"

do_install:append() {
    # MAPIO OS version
    install -d ${D}${sysconfdir}
    install -m 0666 ${WORKDIR}/os-version ${D}${sysconfdir}

    # MAPIO OS initialisation
    install -d ${D}${bindir}
    install -m 0744 ${WORKDIR}/mapio-init.sh ${D}${bindir}
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/mapio-init.service ${D}/${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/usr-local-nvme.mount ${D}/${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/usr-local-nvme.automount ${D}/${systemd_unitdir}/system/
}
