SUMMARY = "MAPIO GPIO HA python module"
DESCRIPTION = "\
    This Python wheel contains the applicative code to manage some \
    MAPIO GPIOs from Home Assistant."

HOMEPAGE = "https://github.com/iotheque/mapio_gpio_ha"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PYPI_SRC_URI = "git://github.com/iotheque/mapio_gpio_ha;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "9cf2bd38491f50c38cbf6021519b2edd586640b7"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-homeassistant-mqtt-binding \
    userland \
"

