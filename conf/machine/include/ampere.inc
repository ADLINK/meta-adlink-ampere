# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

require conf/machine/include/arm/armv8-2a/tune-neoversen1.inc

# Use kernel provided by ampere
PREFERRED_PROVIDER_virtual/kernel ?= "linux-ampere-lts"
PREFERRED_VERSION_linux-ampere-lts ?= "5.15%"
KERNEL_IMAGETYPE = "Image"

IMAGE_FSTYPES += "tar.bz2 wic.gz wic.bmap"

EFI_PROVIDER ?= "grub-efi"

GRUB_CFG_FILE ?= "ampere-grub.cfg"
WKS_FILE ?= "ampere-efidisk.wks.in"
