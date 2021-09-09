DESCRIPTION = "ADLINK BSP Image with Test tool"

		  
IMAGE_INSTALL_append = " packagegroup-core-base-utils usbutils i2c-tools libgpiod libgpiod-tools "

ROOTFS_POSTPROCESS_COMMAND += "install_initrd; "

install_initrd() {
    bbnote "Adding initrd to image ${IMAGE_ROOTFS}"
    install -d ${IMAGE_ROOTFS}/boot
    bbnote "from ${DEPLOY_DIR_IMAGE}/core-image-minimal-initramfs-comhpc.cpio.gz"
    install -m 0755 ${DEPLOY_DIR_IMAGE}/core-image-minimal-initramfs-comhpc.cpio.gz ${IMAGE_ROOTFS}/boot/initrd
}



