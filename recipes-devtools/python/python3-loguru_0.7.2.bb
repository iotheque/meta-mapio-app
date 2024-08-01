SUMMARY = "Python simple logging "
DESCRIPTION = "\
    This Python wheel contains the loguru package."

HOMEPAGE = "https://github.com/Delgan/loguru"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI[sha256sum] = "e671a53522515f34fd406340ee968cb9ecafbc4b36c679da03c18fd8d0bd51ac"

inherit setuptools3 pypi
