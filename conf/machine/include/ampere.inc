# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

require conf/machine/include/arm/arch-armv8a.inc


# Use kernel provided by ampere
PREFERRED_PROVIDER_virtual/kernel ?= "linux-ampere-lts"
PREFERRED_VERSION_linux-ampere-lts ?= "5.10%"

EFI_PROVIDER ?= "grub-efi"


IMAGE_FSTYPES += "tar.bz2 ext4 wic wic.bz2 wic.bmap"
WKS_FILE ?= "ampere-efidisk.wks"
WIC_CREATE_EXTRA_ARGS:append = " --no-fstab-update"

KERNEL_IMAGETYPE = "Image"


