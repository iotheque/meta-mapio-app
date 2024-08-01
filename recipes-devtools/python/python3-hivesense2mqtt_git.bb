SUMMARY = "MAPIO GPIO HA python module"
DESCRIPTION = "\
    This Python wheel contains the applicative for hivesense2mqtt."

HOMEPAGE = "https://github.com/pcurt/hivesense2mqtt"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI:append = " \
    file://hivesense2mqtt@.service \
   "

PYPI_SRC_URI = "git://github.com/pcurt/hivesense2mqtt;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "23c843c61904c79457bcb6f88ea778a570dff316"

inherit setuptools3 pypi systemd

FILES:${PN} += "${systemd_unitdir}/system/hivesense2mqtt@.service"
FILES:${PN} += "/data/hivesense2mqtt"

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-homeassistant-mqtt-binding \
    python3-loguru \
    python3-multiprocessing \
"

SYSTEMD_AUTO_ENABLE = "disable"
SYSTEMD_SERVICE:${PN} = "hivesense2mqtt@.service"

do_install:append() {
    # hivesense2mqtt
    install -d ${D}/data/hivesense2mqtt

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/hivesense2mqtt@.service ${D}/${systemd_unitdir}/system/
}
