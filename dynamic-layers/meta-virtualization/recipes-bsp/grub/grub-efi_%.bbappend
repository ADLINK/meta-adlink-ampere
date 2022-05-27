# SPDX-License-Identifier: MIT

GRUB_BUILDIN:append:ava = "${@bb.utils.contains('DISTRO_FEATURES', 'xen', ' chain', '', d)}"
