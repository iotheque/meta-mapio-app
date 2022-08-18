SUMMARY = "MAPIO diplay python module management"
DESCRIPTION = "This Python wheel contains the applicative code to drive the \ 
MAPIO epaper display. The epaper is a waveshare 2in13 V3 \ 
(https://www.waveshare.com/product/displays/e-paper/epaper-3/2.13inch-e-paper.htm)"

HOMEPAGE = "https://github.com/pcurt/mapio_display"
SECTION = "devel/python"
LICENSE = "CLOSED"

PYPI_SRC_URI = "git://github.com/pcurt/mapio_display;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "87fa1d9e5843df0f69864fd00b410961ac7c350e"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    liberation-fonts \
    python3-click \
    python3-gpiod \
    python3-pillow \
    python3-spidev \
"
