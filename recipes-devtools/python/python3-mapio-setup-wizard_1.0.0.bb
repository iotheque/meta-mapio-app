SUMMARY = "MAPIO SETUP WIZARD python module"
DESCRIPTION = "This Python wheel contains the flask webserver that configures \
MAPIO board and OS."

HOMEPAGE = "https://github.com/pcurt/mapio-setup-wizard"
SECTION = "devel/python"
LICENSE = "CLOSED"

PYPI_SRC_URI = "git://github.com/pcurt/mapio-setup-wizard;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "ef87178e6de01fc30ab224677ba54a58fcf0627e"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-flask \
    python3-flask-login \
"
