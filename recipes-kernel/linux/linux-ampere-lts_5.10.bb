SRCREV ?= "70bff72b430348aa7f807d7200f9936c533f3389"
SRCREV_meta ?= "8f16b5cfe0600f2a7ed1ce68633a88a1196b9776"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# KBRANCH is set to 5.10 branch on the repository
KBRANCH ?= "linux-5.10.y"
KMETA_BRANCH ?= "yocto-5.10"

# Apply following patches
SRC_URI_append = " file://defconfig "

KERNEL_VERSION_SANITY_SKIP="1"

COMPATIBLE_MACHINE = "comhpc"

# Use intree defconfig
#KBUILD_DEFCONFIG = "altra_5.10_defconfig"

require linux-ampere.inc
