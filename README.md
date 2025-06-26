## Repository Structure

The high-level structure of the `meta-adlink-ampere repository is as follows:

**conf**: Contains Machine configuration files for BSP

**recipes-kernel**: Provide support the Kernel version 6.12 and their corresponding cofiguration files.

**recipes-core**: Provide Image generating bb files.

**wic**: wks file to build Image .

## Layers Dependencies

The repository contains Yocto layers that require dependencies as follows.

| Layer               | Branch    | Commit ID                                |
| ------------------- | --------- | ---------------------------------------- |
| poky                | scarthgap | 9c63e0c9646c61663e8cfc6b4c75865cd0cd3b34 |
| meta-openembedded   | scarthgap | e92d0173a80ea7592c866618ef5293203c50544c |
| meta-virtualization | scarthgap | a19092ce81339a129edce745522eebf577efc744 |

# 4. Software Documentation

Refer to the [wiki](https://github.com/ADLINK/meta-adlink-ampere/wiki) page for instructions on building the Yocto as well as flashing the image.

## Repository License

The software is provided under an MIT license

Contributions to the project should follow the same license.

## Feedback and support

To request support please contact ADlink sales.
