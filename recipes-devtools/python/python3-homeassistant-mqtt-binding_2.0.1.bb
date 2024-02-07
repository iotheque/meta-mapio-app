SUMMARY = "Arbitrary homeassistant devices in python using mqtt as interface "
DESCRIPTION = "\
    This Python wheel contains bindings to implement arbitrary \
    homeassistant devices in python using mqtt as interface."

HOMEPAGE = "https://gitlab.com/anphi/homeassistant-mqtt-binding"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PYPI_PACKAGE = "homeassistant-mqtt-binding"

SRC_URI[sha256sum] = "fdf6cff60fb92c439a9398c273e6a40333380601264e5bfd649b4be848342cd2"

inherit setuptools3 pypi

RDEPENDS:${PN} = "\
    python3-paho-mqtt \
"
