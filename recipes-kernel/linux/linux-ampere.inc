# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

# Recipe for building ampere kernel


SUMMARY = "Linux Kernel Upstream, supported by ampere"
SECTION = "kernel"
LICENSE = "GPLv2"

inherit kernel
inherit kernel-yocto

FILESEXTRAPATHS:prepend := "${THISDIR}:"

# Require linux-yocto.inc in order to have separate build dirs when building
# LINUX_KERNEL_TYPE as 'standard' and 'preempt-rt'
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;name=machine;branch=${KBRANCH};protocol=https \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${KMETA_BRANCH};destsuffix=kernel-meta \
           file://adlink-ampere-kmeta;type=kmeta;destsuffix=/adlink-ampere-kmeta "

DEPENDS += "openssl-native util-linux-native"

S = "${WORKDIR}/git"

KCONFIG_MODE = "--alldefconfig"
LINUX_VERSION_EXTENSION ?= "-kernel-lts-${LINUX_KERNEL_TYPE}"

