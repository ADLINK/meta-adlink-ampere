require conf/machine/include/arm/arch-armv8a.inc


# Use kernel provided by ampere (Contains support for SCMi or HDMI)
PREFERRED_PROVIDER_virtual/kernel ?= "linux-ampere-lts"
PREFERRED_VERSION_linux-ampere-lts ?= "5.10%"

EFI_PROVIDER ?= "grub-efi"


MACHINE_FEATURES += "efi"

IMAGE_FSTYPES += "tar.bz2 ext4 wic wic.gz"


WKS_FILE ?= "ampere-efidisk.wks"
