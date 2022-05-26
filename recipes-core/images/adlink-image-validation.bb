DESCRIPTION = "Adlink Image to validate Ampere machines,COM HPC - AVA/AP1 Platforms  \
This image contains everything used to test COM HPC Platform , This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

inherit core-image

WKS_FILE:ava = "adlink-efidisk.wks"

## Select Image Features
IMAGE_FEATURES += " \
    debug-tweaks \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-core-base-utils \
"

IMAGE_INSTALL:append = " i2c-tools libgpiod  bmap-tools iperf3 ipmitool inetutils dhcpcd openssh brcmswitch"

CORE_IMAGE_EXTRA_INSTALL += " dhcpcd"

