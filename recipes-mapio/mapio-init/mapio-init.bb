SUMMARY = "MAPIO Initialization"
DESCRIPTION = "Initialization service for MAPIO"
HOMEPAGE = "https://github.com/iotheque/meta-mapio-app"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://mapio-init.sh \
    file://mapio-init.service \
    file://usr-local-nvme.mount \
    file://usr-local-nvme.automount \
"

inherit systemd

FILES:${PN} += "${systemd_unitdir}/system/mapio-init.service"
FILES:${PN} += "${systemd_unitdir}/system/usr-local-nvme.mount"
FILES:${PN} += "${systemd_unitdir}/system/usr-local-nvme.automount"
FILES:${PN} += "${bindir}/mapio-init.sh"
FILES:${PN} += "/usr/local"
FILES:${PN} += "/data/nvme"

RDEPENDS:${PN} = "\
    bash \
    bash-completion \
    e2fsprogs-resize2fs \
    parted \
    systemd-bash-completion \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "mapio-init.service usr-local-nvme.automount"

do_install:append() {
    # MAPIO OS initialisation
    install -d ${D}${bindir}
    install -m 0744 ${WORKDIR}/mapio-init.sh ${D}${bindir}
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/mapio-init.service ${D}/${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/usr-local-nvme.mount ${D}/${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/usr-local-nvme.automount ${D}/${systemd_unitdir}/system/

    # Create mountpoints in data partitiion
    install -d ${D}/usr/local
    install -d ${D}/data/nvme
}
