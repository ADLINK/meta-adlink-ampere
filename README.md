## Repository Structure

The high-level structure of the `meta-adlink-ampere repository is as follows:

**conf**: Contains Machine configuration files for BSP  

**recipes-kernel**: Provide support the Kernel version 5.10 and 5.4 and their corresponding defconfig files.

**recipes-core**: Provide Image generating bb files.

**ComHpc.yml**: Kas file to build Image .

## Layers Dependencies

The repository contains Yocto layers that require dependencies as follows. 

| Layer               | Branch    | Commit ID                                |
| ------------------- | --------- | ---------------------------------------- |
| poky                | Hardknott | da0ce760c5372f8f2ef4c4dfa24b6995db73c66c |
| meta-openembedded   | Hardknott | c51e79dd854460c6f6949a187970d05362152e84 |
| meta-security       | Hardknott | c6b1eec0e5e94b02160ce0ac3aa9582cbbf7b0ed |
| meta-virtualisation | Hardknott | 3508b13acbf669a5169fafca232a5c4ee705dd16 |
| meta-arm            | Hardknott | e82d9fdd49745a6a064b636f2ea1e02c1750d298 |

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