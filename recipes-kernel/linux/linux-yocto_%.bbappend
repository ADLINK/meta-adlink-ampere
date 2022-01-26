# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

FILESEXTRAPATH:prepend:comhpc := "${THISDIR}/files:"

# Apply linux Configuration/patches
SRC_URI:append:comhpc = " file://comhpc-standard.scc "

KERNEL_VERSION_SANITY_SKIP="1"

COMPATIBLE_MACHINE = "comhpc"


