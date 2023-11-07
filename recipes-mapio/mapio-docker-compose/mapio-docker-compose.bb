SUMMARY = "MAPIO Docker compose files"
DESCRIPTION = "Docker compose files used in MAPIO"
HOMEPAGE = "https://github.com/pcurt/meta-mapio-app"
LICENSE = "CLOSED"

SRC_URI = "\
    file://domoticz-docker-compose.yml \
    file://samba-docker-compose.yml \
    file://homeassistant-docker-compose.yml \
    file://caddy-docker-compose.yml \
    file://jellyfin-docker-compose.yml \
    file://nextcloud-docker-compose.yml \
   "

FILES:${PN} += "/home/root/domoticz/docker-compose.yml "
FILES:${PN} += "/home/root/samba/docker-compose.yml"
FILES:${PN} += "/home/root/homeassistant/docker-compose.yml"
FILES:${PN} += "/home/root/jellyfin/docker-compose.yml"
FILES:${PN} += "/home/root/nextcloud/docker-compose.yml"
FILES:${PN} += "/home/root/caddy/docker-compose.yml"

FILES:${PN} += "/data/domoticz"
FILES:${PN} += "/data/homebridge"
FILES:${PN} += "/data/caddy"
FILES:${PN} += "/data/samba"
FILES:${PN} += "/data/avahi"
FILES:${PN} += "/data/homeassistant"
FILES:${PN} += "/data/zigbee2mqtt"

RDEPENDS:${PN} = "\
    mosquitto \
"

do_install:append() {
    # domoticz
    install -d ${D}/home/root/domoticz
    install -d ${D}/data/domoticz
    install -d ${D}/data/homebridge
    install -m 0644 ${WORKDIR}/domoticz-docker-compose.yml ${D}/home/root/domoticz/docker-compose.yml
    # samba
    install -d ${D}/home/root/samba
    install -d ${D}/data/samba
    install -d ${D}/data/avahi
    install -m 0644 ${WORKDIR}/samba-docker-compose.yml ${D}/home/root/samba/docker-compose.yml
    # homeassistant
    install -d ${D}/home/root/homeassistant
    install -d ${D}/data/homeassistant
    install -d ${D}/data/zigbee2mqtt
    install -m 0644 ${WORKDIR}/homeassistant-docker-compose.yml ${D}/home/root/homeassistant/docker-compose.yml
    # jellyfin
    install -d ${D}/home/root/jellyfin
    install -m 0644 ${WORKDIR}/jellyfin-docker-compose.yml ${D}/home/root/jellyfin/docker-compose.yml
    # nextcloud
    install -d ${D}/home/root/nextcloud
    install -m 0644 ${WORKDIR}/nextcloud-docker-compose.yml ${D}/home/root/nextcloud/docker-compose.yml
    # caddy
    install -d ${D}/home/root/caddy
    install -d ${D}/data/caddy
    install -m 0644 ${WORKDIR}/caddy-docker-compose.yml ${D}/home/root/caddy/docker-compose.yml
}
