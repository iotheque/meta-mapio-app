SUMMARY = "MAPIO webserver front"
DESCRIPTION = "\
    MAPIO webserver frontend"
SECTION = "devel/python"
LICENSE = "CLOSED"


SRC_URI = "git://git@github.com/pcurt/mapio-webserver-front.git;protocol=https;branch=main"
SRCREV = "f14986e70bdb956793b13f66a53d0852064f232b"

DEPENDS = " nodejs-native"

FILES:${PN} = " ${localstatedir}/www/webserver"

RDEPENDS:${PN} = "\
    nginx \
"

# nooelint: oelint.var.order.S
S = "${WORKDIR}/git"

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
