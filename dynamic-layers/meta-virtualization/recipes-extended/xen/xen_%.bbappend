# SPDX-License-Identifier: MIT

FILESEXTRAPATHS:prepend:comhpc := "${THISDIR}/files:"

SRC_URI:append:comhpc = " \
    file://0001-arm-acpi-don-t-expose-the-ACPI-IORT-SMMUv3-entry-to-.patch \
    file://0002-arm-its-enable-LPIs-before-mapping-the-collection-ta.patch \
    file://acpi.cfg \
    file://msi.cfg \
    file://xen.cfg.in"

DEPENDS:append:comhpc = " gettext-native"

DOM0_MEMORY_SIZE ??= "4096"

do_deploy:append:comhpc (){

    export DOM0_MEMORY_SIZE="${DOM0_MEMORY_SIZE}M"

    envsubst < ${WORKDIR}/xen.cfg.in > ${DEPLOYDIR}/xen.cfg
}
