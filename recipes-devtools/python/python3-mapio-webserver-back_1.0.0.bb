SUMMARY = "MAPIO webserver backend python module"
DESCRIPTION = "\
    This Python wheel contains the flask webserver backend that configures \
    MAPIO board and OS."

HOMEPAGE = "https://github.com/pcurt/mapio-webserver-back"
SECTION = "devel/python"
LICENSE = "CLOSED"

PYPI_SRC_URI = "git://github.com/pcurt/mapio-webserver-back.git;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "02009446530802264f31c7437106c3b6e2e028e6"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-flask \
    python3-flask-cors \
    python3-waitress \
"

