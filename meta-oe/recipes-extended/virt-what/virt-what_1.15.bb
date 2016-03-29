SUMMARY = "Detect if we are running in a virtual machine"
DESCRIPTION =" virt-what is a shell script which can be used to detect if the program \
is running in a virtual machine. \
The program prints out a list of "facts" about the virtual machine, \
derived from heuristics.  One fact is printed per line. \
If nothing is printed and the script exits with code 0 (no error), \
then it can mean either that the program is running on bare-metal or \
the program is running inside a type of virtual machine which we don't \
know about or can't detect. \
Current types of virtualization detected: \
 - hyperv       Microsoft Hyper-V \
 - kvm          Linux Kernel Virtual Machine (KVM) \
 - openvz       OpenVZ or Virtuozzo \
 - powervm_lx86 IBM PowerVM Lx86 Linux/x86 emulator \
 - qemu         QEMU (unaccelerated) \
 - uml          User-Mode Linux (UML) \
 - virtage      Hitachi Virtualization Manager (HVM) Virtage LPAR \
 - virtualbox   VirtualBox \
 - virtualpc    Microsoft VirtualPC \
 - vmware       VMware \
 - xen          Xen \
 - xen-dom0     Xen dom0 (privileged domain) \
 - xen-domU     Xen domU (paravirtualized guest domain) \
 - xen-hvm      Xen guest fully virtualized (HVM) \
"

SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "http://people.redhat.com/~rjones/virt-what/files/${PN}-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "35d19ca3305e8ae88c1985fbd8388f53"
SRC_URI[sha256sum] = "7ab9220d4682eadf9139c6afe62d33ebd273fff69e49054279caba5514937c41"
