SUMMARY = "MAPIO webserver front"
DESCRIPTION = "\
    MAPIO webserver frontend"
HOMEPAGE = "https://github.com/iotheque/mapio-webserver-front"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "nodejs-native"

SRC_URI = "git://git@github.com/iotheque/mapio-webserver-front.git;protocol=https;branch=main"
SRCREV = "0e2453c776ee8b3fd344154f9435481153bc7f83"

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

FILES:${PN} += "${localstatedir}/www/webserver"

RDEPENDS:${PN} = "\
    nginx \
"

do_configure[network] = "1"
do_configure() {
    # Prepare npm environement
    cd ${S}
    npm install
}

do_compile() {
    # Compile the webpage
    cd ${S}
    rm -rf dist
    npm run build
}

do_install() {
    # Install the dist directory on the target
    install -d ${D}/${localstatedir}/www/webserver
    cp -r ${S}/dist ${D}/${localstatedir}/www/webserver/
}
