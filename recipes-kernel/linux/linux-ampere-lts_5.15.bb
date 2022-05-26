# SPDX-License-Identifier: MIT

SRCREV ?= "389fd561f4a87395bc21a48f8acdf8668ed26f0b"
SRCREV_meta ?= "63e25b5717751b4b33685bd5991d10c52934a4c6"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# KBRANCH is set to 5.15 branch on the repository
KBRANCH ?= "linux-5.15.y"
KMETA_BRANCH ?= "yocto-5.15"

LINUX_VERSION ?= "5.15.23"
PV = "${LINUX_VERSION}+git${SRCPV}"

require linux-ampere.inc

SRC_URI:append:ava = " file://0002-swiotlb-xen-fix-DMA_ATTR_NO_KERNEL_MAPPING-on-arm.patch"
