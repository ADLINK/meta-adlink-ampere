SUMMARY = "Adlink BCM560XX Switch driver and startup script"
DESCRIPTION = " Broadcom BCM560XX Switch driver and system daemon to implementing the Broadcom Switch configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += " \
    autoconf-archive-native dbus glib-2.0 glib-2.0-native \
    "
SRCBRANCH = "main"

SRC_URI[sha256sum] = "ada564c74d0d5a2f6529f77f5aed30008ca11b405dab398b00e14356ac10e9bb"
SRC_URI[md5sum] = "c187f3802081a01a20e17f0b3728755d"
SRCREV = "a7ac401ddfef313ed2a22520b28909113bc45140"

SRC_URI = "\ 
    git://github.com/ADLINK/adlink_bcm560xx.git;branch=${SRCBRANCH};protocol=https; \
    file://bcm.service \
"

inherit pkgconfig systemd update-rc.d 

INHIBIT_PACKAGE_STRIP = "1"

SYSTEMD_PACKAGES += "${PN}"
SYSTEMD_SERVICE:${PN} = "bcm.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

INITSCRIPT_NAME = "bcm"
INITSCRIPT_PARAMS = "start 99 2 3 4 5 . stop 19 0 1 6 ."

do_install() {
    if ${@bb.utils.contains("DISTRO_FEATURES", 'systemd', 'true', 'false', d)}; then
       install -d -m 0755 "${D}/opt/bcm_control"
       install -d "${D}${systemd_system_unitdir}/system"
       install -m 0755 "${WORKDIR}/bcm.service" "${D}${systemd_system_unitdir}/bcm.service"
       install -m 0755 "${WORKDIR}/git/bcm_control/bcm.sh" "${D}/opt/bcm_control"
       install -m 0755 "${WORKDIR}/git/bcm_control/bcm.user" "${D}/opt/bcm_control"
       install -m 0644 "${WORKDIR}/git/bcm_control/config.bcm" "${D}/opt/bcm_control"
       install -m 0644 "${WORKDIR}/git/bcm_control/custom_led.bin" "${D}/opt/bcm_control"
       install -m 0644 "${WORKDIR}/git/bcm_control/linkscan_led_fw.bin" "${D}/opt/bcm_control"
       install -m 0755 "${WORKDIR}/git/bcm_control/linux-kernel-bde.ko" "${D}/opt/bcm_control"
       install -m 0755 "${WORKDIR}/git/bcm_control/linux-user-bde.ko" "${D}/opt/bcm_control"
       install -m 0755 "${WORKDIR}/git/bcm_control/netserve" "${D}/opt/bcm_control"
       install -m 0644 "${WORKDIR}/git/bcm_control/rc.soc" "${D}/opt/bcm_control"
    fi
}

FILES:${PN} += "\
    ${systemd_unitdir}/system/bcm.service \
    /lib/systemd/system/* \
    /opt/bcm_control/* \
"
do_package_qa(){
}

