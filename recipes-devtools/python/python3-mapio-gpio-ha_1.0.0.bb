SUMMARY = "MAPIO GPIO HA python module"
DESCRIPTION = "This Python wheel contains the applicative code to manage some \
MAPIO GPIOs from Home Assistant."

HOMEPAGE = "https://github.com/pcurt/mapio_gpio_ha"
SECTION = "devel/python"
LICENSE = "CLOSED"

PYPI_SRC_URI = "git://github.com/pcurt/mapio_gpio_ha;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "acd631221cdcfb725076915574bae1fff985bb75"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-homeassistant-mqtt-binding \
"
