SUMMARY = "Build mcumgr tool"
DESCRIPTION = "Rust program to run mcumgr commands, used for example for \
Zephyr, for uploading firmware updates from a PC to an embedded device"
HOMEPAGE = "https://github.com/iotheque/meta-mapio-app"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit cargo

SRC_URI = "git://github.com/vouch-opensource/mcumgr-client.git;protocol=https;branch=main"

SRCREV = "99e6271637e371ce0b4c2b3270dd9887b5611016"

require ${BPN}-crates.inc

S = "${WORKDIR}/git"
