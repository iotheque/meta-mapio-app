SUMMARY = "MAPIO GPIO HA python module"
DESCRIPTION = "\
    This Python wheel contains the applicative code to manage some \
    MAPIO GPIOs from Home Assistant."

HOMEPAGE = "https://github.com/pcurt/mapio_gpio_ha"
SECTION = "devel/python"
LICENSE = "CLOSED"

PYPI_SRC_URI = "git://github.com/pcurt/mapio_gpio_ha;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "42b91433bbc8e87958ada90e4a3abb36e0fd710e"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-homeassistant-mqtt-binding \
    userland \
"

