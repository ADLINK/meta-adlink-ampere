# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT

do_install_append () {
    cat >> ${D}${sysconfdir}/fstab <<EOF
# Support sda and NVMe M.2 SSD mounting
/dev/nvme0n1p2	/	auto	defaults,sync	0	0
/dev/sda2	/	auto	defaults,sync	0	0

EOF
}
