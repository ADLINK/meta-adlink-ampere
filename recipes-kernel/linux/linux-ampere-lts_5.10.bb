# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT


require linux-ampere.inc

SRCREV ?= "3a2a9c0a69e94a39c28611d0eec0ec160b3de538"
SRCREV_meta ?= "8f16b5cfe0600f2a7ed1ce68633a88a1196b9776"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

COMPATIBLE_MACHINE:${MACHINE} = "(comhpc-ava|comhpc-ap1)"
KERNEL_VERSION_SANITY_SKIP="1"

# KBRANCH is set to 5.10 branch on the repository
KBRANCH:comhpc-ava = "linux-5.10.y"
KMETA_BRANCH:comhpc-ava= "yocto-5.10"
# Apply linux Configuration/patches
SRC_URI:append:comhpc-ava = " file://comhpc-ava.scc "



#KBRANCH is set to 5.10 branch on the repository
KBRANCH:comhpc-ap1= "linux-5.10.y"
KMETA_BRANCH:comhpc-ap1= "yocto-5.10"
# Apply linux Configuration/patches
SRC_URI:append:comhpc-ap1 = " file://comhpc-ap1.scc \
			      file://0001-AX99100-serial-driver-ported-from-https-www.asix.com.patch "





