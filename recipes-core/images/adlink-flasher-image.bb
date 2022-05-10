# SPDX-License-Identifier: MIT

SUMMARY = "Flasher image recipe configured for flashing images into USB or \
           SSD drives."
LICENSE = "MIT"

IMAGE_LINGUAS = " "
IMAGE_FSTYPES = "wic.gz wic.bmap"

inherit core-image

IMAGE_FEATURES += "bash-completion-pkgs debug-tweaks ssh-server-openssh"

IMAGE_INSTALL += " \
    bash \
    bash-completion-extra \
    bmap-tools \
    ca-certificates \
    kernel-modules \
    util-linux-agetty \
    wget \
    "

ROOTFS_POSTPROCESS_COMMAND += 'autologin_root;'

autologin_root() {
    sed -i "s|/bin/start_getty|/sbin/agetty --autologin root|g" \
        ${IMAGE_ROOTFS}/${sysconfdir}/inittab
}

GRUB_CFG_FILE = "${WORKDIR}/ampere-flasher-grub.cfg"
IMAGE_EFI_BOOT_FILES += "${ADLINK_AMPERE_LAYERDIR}/wic/ampere-grub.cfg;./EFI/BOOT"
ROOT_PART_UUID = "a65a155c-81dc-4919-bc81-4b0200134a0e"
WKS_ROOTFS_PART_EXTRA_ARGS = "--uuid=${ROOT_PART_UUID} --size=2G"

do_image_wic[prefuncs] += "generate_grub_cfg"

generate_grub_cfg() {

    cat <<-'EOF' > "${GRUB_CFG_FILE}"
	# SPDX-License-Identifier: MIT

	source $prefix/ampere-grub.cfg

	rootpart_uuid="${ROOT_PART_UUID}"
	EOF
}
