SUMMARY = "Shows and sets processor power related values"
DESCRIPTION = "cpupower is a collection of tools to examine and tune power \
saving related features of your processor."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
DEPENDS = "pciutils"

inherit kernelsrc kernel-arch

do_configure[depends] += "virtual/kernel:do_shared_workdir"
do_populate_lic[depends] += "virtual/kernel:do_patch"

PROVIDES = "virtual/cpupower"

B = "${WORKDIR}/${BPN}-${PV}"

EXTRA_OEMAKE = '\
    -C ${S}/tools/power/cpupower \
    O=${B} \
    CROSS=${TARGET_PREFIX} \
    ARCH=${ARCH} \
    CC="${CC}" \
    AR="${AR}" \
'
do_compile() {
	unset CFLAGS
	oe_runmake all
}

do_install() {
	unset CFLAGS
	oe_runmake DESTDIR=${D} install
	chown root:root ${D}/${libdir}/*
}

python do_package_prepend() {
    d.setVar('PKGV', d.getVar("KERNEL_VERSION", True).split("-")[0])
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
RDEPENDS_${PN} = "bash"
