SUMMARY = "MAPIO SETUP WIZARD python module"
DESCRIPTION = "This Python wheel contains the flask webserver that configures \
MAPIO board and OS."

HOMEPAGE = "https://github.com/pcurt/mapio-setup-wizard"
SECTION = "devel/python"
LICENSE = "CLOSED"

PYPI_SRC_URI = "git://github.com/pcurt/mapio-setup-wizard;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "11fe7c241eec063910687fff369bb786c8d2fcdc"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-flask \
    python3-flask-login \
"
