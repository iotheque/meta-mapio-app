FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://daemon.json"

sysconfdocker = "${sysconfdir}/docker"
do_install:append() {
    install -d ${D}${sysconfdocker}
    install -m 0755 ${WORKDIR}/daemon.json ${D}${sysconfdocker}
}
