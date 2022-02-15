# SPDX-License-Identifier: MIT

GRUB_CFG_FILE ?= "${ADLINK_AMPERE_VIRTUALIZATION_DYNAMIC_DIR}/wic/ampere-xen-grub.cfg"

WKS_SEARCH_PATH:prepend = "${ADLINK_AMPERE_VIRTUALIZATION_DYNAMIC_DIR}/wic:"

IMAGE_EFI_BOOT_FILES += "xen-comhpc.efi;xen.efi xen.cfg \
                     ${ADLINK_AMPERE_LAYERDIR}/wic/ampere-grub.cfg;./EFI/BOOT"

do_image_wic[depends] += "xen:do_deploy"
