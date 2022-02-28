DESCRIPTION = "Adlink Image to validate Ampere machines,COM HPC - AVA/AP1 Platforms  \
This image contains everything used to test COM HPC Platform , This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

inherit core-image

WKS_FILE:comhpc = "adlink-efidisk.wks"

## Select Image Features
IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    nfs-server \
    tools-debug \
    ssh-server-dropbear \
    tools-testapps \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-core-base-utils \
"

IMAGE_INSTALL:append = " usbutils i2c-tools libgpiod libgpiod-tools bmap-tools iperf3 ipmitool pciutils brcmswitch"


