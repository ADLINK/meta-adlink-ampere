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
| poky                | mickledore | 6e17b3e644ca15b8b4afd071ccaa6f172a0e681a |
| meta-openembedded   | mickledore | d71a08b3d8fc69d3213c10885af9cc693056a8bd |
| meta-virtualization | mickledore | a19092ce81339a129edce745522eebf577efc744 |

## Build

## Prerequisites

`kas` is required for the build process.

```sh
pip3 install -U kas
```

`bmaptool` command is is required to flash the built image to the USB
stick.  Install`bmap-tools` package if you are using Ubuntu.


```sh
sudo apt install bmap-tools
```

Download this repository and relating submodules.

```sh
git clone --recursive https://github.com/ADLINK/meta-adlink-ampere.git
cd meta-adlink-ampere
```

(Optional) If the repo is downloaded but the submodules are not
initialized yet, run these commands to download submodules.

```sh
cd meta-adlink-ampere  # Go to the repo downloaded earlier
git submodule init
git submodule update
```

### How to build Yocto Image

The flasher image can be build with `kas build ava_flasher.yml` See
the Documentation for more details.

### How to flash WIC image

The wic image can be flashed to the USB stick with the following
commands, where `/dev/sdX` a path to the target USB stick:

```sh
sudo bmaptool copy \
    --bmap build/tmp/deploy/ava/adlink-flasher-image-ava.wic.bmap \
    build/tmp/deploy/ava/adlink-flasher-image-ava.wic.gz \
    /dev/sdX
```

The wic image can also be flashed to the NVME drive using a USB stick
with the `adlink-flasher-image`:


1. Attach the USB stick, (re)boot the board and select the proper USB
  drive in the UEFI Boot menu.
2. Select: 'USB Boot (If Drive is present): COM-HPC AVA Yocto Image'
3. Copy the `*.wic.bmap` and `*.wic.gz` images to the board.
    1. The files can be copied over the network from the build machine with e.g.:
        ```sh
        scp build/tmp/deploy/ava/adlink-flasher-image-ava.wic.* \
             root@<BOARD_IP_ADDRESS>:/tmp
        ```
4. Flash the wic images on the NVME drive with:
    ```
    bmaptool copy \
        --bmap /tmp/adlink-flasher-image-ava.wic.bmap \
        /tmp/adlink-flasher-image-ava.wic.gz \
        /dev/nvme0n1
    ```

<!-- - Boot from USB drive -->
<!-- - Boot from SSD -->

## Repository License

The software is provided under an MIT license

Contributions to the project should follow the same license.

## Feedback and support

To request support please contact ADlink sales.

## Maintainer(s)

- Ryan Huang   [ryanzj.huang@adlinktech.com](mailto:ryanzj.huang@adlinktech.com)
