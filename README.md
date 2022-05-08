## Repository Structure

The high-level structure of the `meta-adlink-ampere repository is as follows:

**conf**: Contains Machine configuration files for BSP  

**recipes-kernel**: Provide support the Kernel version 5.10 and their corresponding cofiguration files.

**recipes-core**: Provide Image generating bb files.

**wic**: wks file to build Image .

## Layers Dependencies

The repository contains Yocto layers that require dependencies as follows. 

| Layer               | Branch    | Commit ID                                |
| ------------------- | --------- | ---------------------------------------- |
| poky                | kirkstone | d84c73d1ef05b7e12bcab2767f1a1f7a59ad17f2 |
| meta-openembedded   | kirkstone | 5357c7a40eaf8d1bcf7ff58edbba8e9527e40c7d |
| meta-virtualisation | kirkstone | 973c8d0964c6f40338857efe5b8009b2f647d485 |
| meta-arm            | kirkstone | 2627002c85dee658ebb6a293496a72a927ad1f77 |

### How to build Yocto Image

- see the Documentation for  more details

### How to flash WIC image 

- Boot from USB drive
- Boot from SSD 

## Repository License

The software is provided under an MIT license 

Contributions to the project should follow the same license.

## Feedback and support

To request support please contact ADlink sales.

## Maintainer(s)

- Ryan Huang   [ryanzj.huang@adlinktech.com](mailto:ryanzj.huang@adlinktech.com)
