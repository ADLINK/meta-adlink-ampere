# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

SRCREV ?= "3a2a9c0a69e94a39c28611d0eec0ec160b3de538"
SRCREV_meta ?= "8f16b5cfe0600f2a7ed1ce68633a88a1196b9776"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# KBRANCH is set to 5.10 branch on the repository
KBRANCH ?= "linux-5.10.y"
KMETA_BRANCH ?= "yocto-5.10"

LINUX_VERSION:comhpc = "5.10"

# Apply linux Configuration/patches
SRC_URI:append:comhpc = " file://comhpc-standard.scc "

KERNEL_VERSION_SANITY_SKIP="1"

COMPATIBLE_MACHINE = "comhpc"

require linux-ampere.inc
