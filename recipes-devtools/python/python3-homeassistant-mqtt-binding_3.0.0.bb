SUMMARY = "Arbitrary homeassistant devices in python using mqtt as interface "
DESCRIPTION = "\
    This Python wheel contains bindings to implement arbitrary \
    homeassistant devices in python using mqtt as interface."

HOMEPAGE = "https://gitlab.com/anphi/homeassistant-mqtt-binding"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PYPI_PACKAGE = "homeassistant_mqtt_binding"

SRC_URI[sha256sum] = "2f97c3daf2a42d63eb6988cff1d5c38820bec88cda2a0d1179c75d5b362a8578"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-paho-mqtt \
"

do_compile:prepend () {
       # Remove test part from toml poject
       sed -i '/\[tool.poetry.group.dev\]/,/^$/d' ${S}/pyproject.toml
       sed -i '/\[tool.poetry.group.dev.dependencies\]/,/^$/d' ${S}/pyproject.toml
}
