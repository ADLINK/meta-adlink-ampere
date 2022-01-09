# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

FILESEXTRAPATHS_prepend_comhpc := "${THISDIR}/files:"

# Apply linux Configuration/patches
SRC_URI_append_comhpc = " file://comhpc-standard.scc "

KERNEL_VERSION_SANITY_SKIP="1"

COMPATIBLE_MACHINE = "comhpc"


