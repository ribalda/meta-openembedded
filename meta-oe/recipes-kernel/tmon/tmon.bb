SUMMARY = "A monitoring and testing tool for Linux kernel thermal subsystem"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
DEPENDS = "ncurses"

inherit kernelsrc kernel-arch

do_configure[depends] += "virtual/kernel:do_shared_workdir"
do_populate_lic[depends] += "virtual/kernel:do_patch"

B = "${WORKDIR}/${BPN}-${PV}"

EXTRA_OEMAKE = '\
    -C ${S}/tools/thermal/tmon \
    CROSS_COMPILE=${TARGET_PREFIX} \
    ARCH=${ARCH} \
    CC="${CC}" \
    AR="${AR}" \
'
do_compile() {
	unset CFLAGS
	oe_runmake tmon
}

do_install() {
	unset CFLAGS
	oe_runmake INSTALL_ROOT=${D} install
}

python do_package_prepend() {
    d.setVar('PKGV', d.getVar("KERNEL_VERSION", True).split("-")[0])
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
