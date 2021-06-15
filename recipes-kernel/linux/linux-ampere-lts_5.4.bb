SRCREV ?= "5a19482181929825c7ccde4c72d6f4806939b356"
SRCREV_meta ?= "e32057eca987b7abbe3eb47ba36f06af8711278a"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
# KBRANCH is set to n1sdp by default as there is no master or 5.4 branch on the repository
KBRANCH ?= "linux-5.4.y"
KMETA_BRANCH ?= "yocto-5.4"

# Apply following patches
SRC_URI_append = " \
    "

COMPATIBLE_MACHINE = "comhpc"

KBUILD_DEFCONFIG = "altra_5.4_defconfig"

require linux-ampere.inc
