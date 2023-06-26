SUMMARY = "MAPIO Docker compose files"
DESCRIPTION = "Docker compose files used in MAPIO"
HOMEPAGE = "https://github.com/pcurt/meta-mapio-app"
LICENSE = "CLOSED"

SRC_URI = "\
    file://domoticz-docker-compose.yml \
    file://samba-docker-compose.yml \
    file://homeassistant-docker-compose.yml \
   "

FILES:${PN} += "/home/root/domoticz/docker-compose.yml "
FILES:${PN} += "/home/root/samba/docker-compose.yml"
FILES:${PN} += "/home/root/homeassistant/docker-compose.yml"

RDEPENDS:${PN} = "\
    mosquitto \
"

do_install:append() {
    install -d ${D}/home/root/domoticz
    install -m 0644 ${WORKDIR}/domoticz-docker-compose.yml ${D}/home/root/domoticz/docker-compose.yml
    install -d ${D}/home/root/samba
    install -m 0644 ${WORKDIR}/samba-docker-compose.yml ${D}/home/root/samba/docker-compose.yml
    install -d ${D}/home/root/homeassistant
    install -m 0644 ${WORKDIR}/homeassistant-docker-compose.yml ${D}/home/root/homeassistant/docker-compose.yml
}
