# SPDX-License-Identifier: MIT

SRCREV ?= "b801eaa96a5a2f2a8fe0b5982ffe4a1fba3c1e93"
SRCREV_meta ?= "1f6ab68a1d86836bf1b82b791df03da3cfeacb3f"



LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# KBRANCH is set to 5.15 branch on the repository
KBRANCH ?= "linux-6.12.y"
KMETA_BRANCH ?= "yocto-6.12"

LINUX_VERSION ?= "6.12.27"
PV = "${LINUX_VERSION}+git${SRCPV}"

require linux-ampere.inc

#SRC_URI:append:ava = " file://0002-swiotlb-xen-fix-DMA_ATTR_NO_KERNEL_MAPPING-on-arm.patch"
