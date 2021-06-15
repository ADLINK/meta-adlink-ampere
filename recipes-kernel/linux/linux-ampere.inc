# Recipe for building ampere kernel

SUMMARY = "Linux Kernel Upstream, supported by ampere"
SECTION = "kernel"
LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
inherit kernel-yocto

SRC_URI[sha256sum] = "e1497fba2a6f1ee731f30b213dd3499759e2164be688a975d6848ff70637be6e"

# Require linux-yocto.inc in order to have separate build dirs when building
# LINUX_KERNEL_TYPE as 'standard' and 'preempt-rt'
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/AmpereComputing/ampere-lts-kernel.git;branch=${KBRANCH} \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${KMETA_BRANCH};destsuffix=kernel-meta \
           file://0001-menuconfig-mconf-cfg-Allow-specification-of-ncurses-location.patch"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

LINUX_VERSION ?= "${PV}"
S = "${WORKDIR}/git"

# Add machine-specific settings
MACHINE_KERNEL_REQUIRE ?= ""
#MACHINE_KERNEL_REQUIRE_comhpc = "linux-ampere-comhpc.inc"

#require ${MACHINE_KERNEL_REQUIRE}
