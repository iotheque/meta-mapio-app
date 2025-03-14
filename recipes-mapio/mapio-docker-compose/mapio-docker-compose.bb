SUMMARY = "MAPIO Docker compose files"
DESCRIPTION = "Docker compose files used in MAPIO"
HOMEPAGE = "https://github.com/iotheque/meta-mapio-app"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://docker-compose.yml \
    file://smb.conf\
    file://usr-local-mapio.service \
    file://profiles.yaml \
    file://matter.conf \
"

inherit systemd

FILES:${PN} += "/data/domoticz"
FILES:${PN} += "/data/homebridge"
FILES:${PN} += "/data/caddy"
FILES:${PN} += "/data/samba"
FILES:${PN} += "/data/avahi"
FILES:${PN} += "/data/homeassistant"
FILES:${PN} += "/data/homeassistant/media"
FILES:${PN} += "/data/zigbee2mqtt"
FILES:${PN} += "/data/resticprofile"
FILES:${PN} += "/data/wireguard"
FILES:${PN} += "/home/root/mapio/docker-compose.yml "
FILES:${PN} += "/data/samba/smb.conf"
FILES:${PN} += "/data/resticprofile/profiles.yaml"
FILES:${PN} += "/data/otbr_data"
FILES:${PN} += "/data/matter_data"

RDEPENDS:${PN} = "\
    mosquitto \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "usr-local-mapio.service"

do_install:append() {
    # Install bind mount service for mapio directory
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/usr-local-mapio.service ${D}/${systemd_unitdir}/system/
    # Install compose file
    install -d ${D}/${ROOT_HOME}/mapio
    install -m 0644 ${WORKDIR}/docker-compose.yml ${D}/${ROOT_HOME}/mapio/docker-compose.yml
    # domoticz
    install -d ${D}/data/domoticz
    install -d ${D}/data/homebridge
    # samba
    install -d ${D}/data/samba
    install -d ${D}/data/avahi
    install -m 0644 ${WORKDIR}/docker-compose.yml ${D}/data/samba/smb.conf
    # homeassistant
    install -d ${D}/data/homeassistant
    install -d ${D}/data/homeassistant/media
    install -d ${D}/data/zigbee2mqtt
    # caddy
    install -d ${D}/data/caddy
    # resticprofile
    install -d ${D}/data/resticprofile
    install -m 0644 ${WORKDIR}/profiles.yaml ${D}/data/resticprofile/profiles.yaml
    # wireguard
    install -d ${D}/data/wireguard
    # OTBR and matter
    install -d ${D}${sysconfdir}/sysctl.d
    install -m 0644 ${WORKDIR}/matter.conf ${D}${sysconfdir}/sysctl.d/matter.conf
    install -d ${D}/data/otbr_data
    install -d ${D}/data/matter_data
}
