FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://daemon.json"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "docker.service"

sysconfdocker = "${sysconfdir}/docker"
do_install:append() {
    install -d ${D}${sysconfdocker}
    install -m 0755 ${WORKDIR}/daemon.json ${D}${sysconfdocker}
}
