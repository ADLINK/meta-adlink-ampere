# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

SRCREV ?= "3a2a9c0a69e94a39c28611d0eec0ec160b3de538"
SRCREV_meta ?= "64fb693a6c11f21bab3ff9bb8dcb65a70abe05e3"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# KBRANCH is set to 5.10 branch on the repository
KBRANCH ?= "linux-5.10.y"
KMETA_BRANCH ?= "yocto-5.10"

LINUX_VERSION ?= "5.10.27"
PV = "${LINUX_VERSION}+git${SRCPV}"

require linux-ampere.inc
