# SPDX-License-Identifier: MIT

require ${@bb.utils.contains('DISTRO_FEATURES', 'xen', \
    bb.utils.contains('BBFILE_COLLECTIONS', 'virtualization-layer', \
        '${ADLINK_AMPERE_VIRTUALIZATION_DYNAMIC_DIR}/conf/machine/include/image-tweaks-ava-machine-xen.inc', \
        '', d), \
    '', d)}
