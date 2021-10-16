# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT



# Recipe for building ampere kernel

SUMMARY = "Linux Kernel Upstream, supported by ampere"
SECTION = "kernel"
LICENSE = "GPLv2"


inherit kernel
inherit kernel-yocto


# Require linux-yocto.inc in order to have separate build dirs when building
# LINUX_KERNEL_TYPE as 'standard' and 'preempt-rt'
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/AmpereComputing/ampere-lts-kernel.git;branch=${KBRANCH} \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${KMETA_BRANCH};destsuffix=kernel-meta \
           file://0001-menuconfig-mconf-cfg-Allow-specification-of-ncurses-location.patch"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

LINUX_VERSION ?= "${PV}.27"
S = "${WORKDIR}/git"

KCONFIG_MODE = "--alldefconfig"

# Add machine-specific settings
MACHINE_KERNEL_REQUIRE ?= ""

