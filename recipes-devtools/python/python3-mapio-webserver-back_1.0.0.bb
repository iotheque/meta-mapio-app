SUMMARY = "MAPIO webserver backend python module"
DESCRIPTION = "\
    This Python wheel contains the flask webserver backend that configures \
    MAPIO board and OS."

HOMEPAGE = "https://github.com/pcurt/mapio-webserver-back"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PYPI_SRC_URI = "git://github.com/pcurt/mapio-webserver-back.git;protocol=https;branch=main"
SRC_URI = ""
SRCREV = "497e652c4503b08764fe240e34fbec019cff7e22"

inherit setuptools3 pypi

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-flask \
    python3-flask-cors \
    python3-waitress \
"

