# Copyright (c) 2021, ADLINK Technology Inc
#
# SPDX-License-Identifier: MIT


DESCRIPTION = "ADLINK BSP Image with Test tool"

		  
IMAGE_INSTALL_append = " packagegroup-core-base-utils usbutils i2c-tools libgpiod libgpiod-tools bmap-tools kernel-modules "


