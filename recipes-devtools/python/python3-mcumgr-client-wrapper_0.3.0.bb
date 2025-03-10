SUMMARY = "Python library to control gpio using libgpiod "
DESCRIPTION = "\
    This Python wheel contains the generated code to interact with \
    GPIOs using libgpiod."

HOMEPAGE = "https://github.com/comap-smart-home/mcumgr-client-wrapper"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PYPI_PACKAGE = "mcumgr_client_wrapper"

SRC_URI[sha256sum] = "ec9281682002cfaf8d551a0ff513993e79ef67e3e6ff3b355b342c266ed3a36f"

DEPENDS = "python3-maturin-native python3-typing-extensions"

#require ${BPN}-crates.inc

inherit python_maturin pypi cargo-update-recipe-crates
