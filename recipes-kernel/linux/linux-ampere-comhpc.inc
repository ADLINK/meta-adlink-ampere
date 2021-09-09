# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ampere-comhpc:"

SRC_URI_append = " \
    "

# Referring to commit ampere
SRCREV = "5a19482181929825c7ccde4c72d6f4806939b356"

# Use intree defconfig
KBUILD_DEFCONFIG = "defconfig"

# Since the intree defconfig in n1sdp kernel repository is not setting all the configs,
# KCONFIG_MODE is set to "alldefconfig" to properly expand the defconfig.
KCONFIG_MODE = "--alldefconfig"

COMPATIBLE_MACHINE = "comhpc"


