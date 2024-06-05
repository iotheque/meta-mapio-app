SUMMARY = "MQTT version  client library"
DESCRIPTION = "\
    This Python wheel contains the Eclipse Paho™ MQTT Python Client."
HOMEPAGE = "https://github.com/eclipse/paho.mqtt.python"
SECTION = "devel/python"
LICENSE = "CLOSED"

inherit pypi setuptools3

PYPI_PACKAGE = "paho_mqtt"

SRC_URI[sha256sum] = "12d6e7511d4137555a3f6ea167ae846af2c7357b10bc6fa4f7c3968fc1723834"

DEPENDS += "python3-pytest-runner-native"

SRC_URI:append = " \
    file://setup.py \
"

S = "${WORKDIR}/paho_mqtt-${PV}"

PACKAGES =+ "${PN}-examples"

FILES:${PN}-examples += "${datadir}/${BPN}/examples"

RDEPENDS:${PN} = "\
    python3-io \
    python3-logging \
    python3-math \
    python3-netclient \
    python3-threading \
"
RDEPENDS:${PN}-examples += "${PN} python3-core"

do_configure:prepend:class-target () {
    cp ${WORKDIR}/setup.py ${S}/setup.py
}

# nooelint: oelint.task.nocopy
do_install:append() {
        install -d -m0755 ${D}${datadir}/${BPN}/examples
        cp --preserve=mode,timestamps -R ${S}/examples/* ${D}${datadir}/${BPN}/examples
}

BBCLASSEXTEND = "native nativesdk"

