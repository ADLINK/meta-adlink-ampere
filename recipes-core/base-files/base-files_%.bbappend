do_install_append () {
    cat >> ${D}${sysconfdir}/fstab <<EOF
#NVMe M.2 SSD mounting
/dev/nvme0n1p2	/	auto	defaults,sync,noauto	0	0

EOF
}
