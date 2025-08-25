# SPDX-FileCopyrightText: <text>Copyright 2022-2023 Arm Limited and/or its
# affiliates <open-source-office@arm.com></text>
#
# SPDX-License-Identifier: MIT

FILESEXTRAPATHS:prepend:ava := "${THISDIR}:${THISDIR}/linux-yocto:"

COMPATIBLE_MACHINE:append = "|ava"

#
# cassini kmeta
#

SRC_URI:append:ava = " file://adlink-ampere-kmeta;type=kmeta;destsuffix=/adlink-ampere-kmeta "


