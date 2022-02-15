# SPDX-License-Identifier: MIT

GRUB_BUILDIN:append:comhpc = "${@bb.utils.contains('DISTRO_FEATURES', 'xen', ' chain', '', d)}"
