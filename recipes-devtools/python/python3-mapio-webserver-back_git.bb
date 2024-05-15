SUMMARY = "MAPIO webserver backend python module"
DESCRIPTION = "\
    This Python wheel contains the flask webserver backend that configures \
    MAPIO board and OS."

HOMEPAGE = "https://github.com/iotheque/mapio-webserver-back"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PYPI_SRC_URI = "git://github.com/iotheque/mapio-webserver-back.git;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "7fa36132a4b49c45d93d988a8701c919e2f30bfe"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-flask \
    python3-flask-cors \
    python3-waitress \
    python3-werkzeug \
"

