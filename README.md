## Repository Structure

The high-level structure of the `meta-adlink-ampere repository is as follows:

**conf**: Contains Machine configuration files for BSP

**recipes-kernel**: Provide support the Kernel version 5.10 & 5.15 and their corresponding cofiguration files.

**recipes-core**: Provide Image generating bb files.

**wic**: wks file to build Image .

## Layers Dependencies

The repository contains Yocto layers that require dependencies as follows.

| Layer               | Branch    | Commit ID                                |
| ------------------- | --------- | ---------------------------------------- |
| poky                | kirkstone | d84c73d1ef05b7e12bcab2767f1a1f7a59ad17f2 |
| meta-openembedded   | kirkstone | 5357c7a40eaf8d1bcf7ff58edbba8e9527e40c7d |
| meta-virtualization | kirkstone | 973c8d0964c6f40338857efe5b8009b2f647d485 |

### How to build Yocto Image

The flasher image can be build with `kas build ComHpc_flasher.yml`

- see the Documentation for  more details

### How to flash WIC image

#### COMHPC-AVA:

The wic image can be flashed to the USB stick with the following commands:
```
$ sudo bmaptool copy \
    --bmap build/tmp/deploy/ava/adlink-flasher-image-ava.wic.bmap \
    build/tmp/deploy/ava/adlink-flasher-image-ava.wic.gz \
    /dev/sdX
```
where `/dev/sdX` a path to the target USB stick.

The wic image can also be flashed to the NVME drive using a USB stick with the
`adlink-flasher-image`:
```
1. Attach the USB stick, (re)boot the board and select the proper USB drive in
  the UEFI Boot menu.
2. Select: 'USB Boot (If Drive is present): COM-HPC AVA Yocto Image'
3. Copy the *.wic.bmap and *.wic.gz images to the board.
  A. The files can be copied over the network from the build machine with e.g.:
   scp build/tmp/deploy/ava/adlink-flasher-image-ava.wic.* \
       root@<BOARD_IP_ADDRESS>:/tmp
4. Flash the wic images on the NVME drive with:
  # bmaptool copy \
    --bmap /tmp/adlink-flasher-image-ava.wic.bmap \
    /tmp/adlink-flasher-image-ava.wic.gz \
    /dev/nvme0n1
```
- Boot from USB drive
- Boot from SSD

## Repository License

The software is provided under an MIT license

Contributions to the project should follow the same license.

## Feedback and support

To request support please contact ADlink sales.

## Maintainer(s)

- Ryan Huang   [ryanzj.huang@adlinktech.com](mailto:ryanzj.huang@adlinktech.com)
