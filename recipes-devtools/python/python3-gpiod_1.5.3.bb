SUMMARY = "Python library to control gpio using libgpiod "
DESCRIPTION = "\
    This Python wheel contains the generated code to interact with \
    GPIOs using libgpiod."

HOMEPAGE = "https://github.com/hhk7734/python3-gpiod"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PYPI_PACKAGE = "gpiod"

SRC_URI[sha256sum] = "35c76009800a715ede673a8ec2b60d426850cc158dfb7c34d937caf197b470db"

inherit setuptools3 pypi
