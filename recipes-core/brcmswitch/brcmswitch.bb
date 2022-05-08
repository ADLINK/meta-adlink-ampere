SUMMARY = "Adlink BCM560XX Switch driver and startup script"
DESCRIPTION = " Broadcom BCM560XX Switch driver and system daemon to implementing the Broadcom Switch configuration"
LICENSE = "CLOSED"

DEPENDS += " \
    autoconf-archive-native dbus glib-2.0 glib-2.0-native \
    "
SRCBRANCH = "main"
SRC_URI = "\ 
    git://github.com/ADLINK/adlink_bcm560xx.git;branch=${SRCBRANCH};protocol=https; \
    file://bcm.service \
"
SRC_URI[sha256sum] = "ada564c74d0d5a2f6529f77f5aed30008ca11b405dab398b00e14356ac10e9bb"
SRC_URI[md5sum] = "c187f3802081a01a20e17f0b3728755d"
 

SRCREV = "c038bb016f7b56ce793e58b7b30de93c62ec7245"

inherit pkgconfig systemd update-rc.d 


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
       install -m 0644 "${WORKDIR}/git/bcm_control/linux-kernel-bde.ko" "${D}/opt/bcm_control"
       install -m 0644 "${WORKDIR}/git/bcm_control/linux-user-bde.ko" "${D}/opt/bcm_control"
       install -m 0755 "${WORKDIR}/git/bcm_control/netserve" "${D}/opt/bcm_control"
       install -m 0644 "${WORKDIR}/git/bcm_control/rc.soc" "${D}/opt/bcm_control"
    fi
}

FILES:${PN} += "/opt/bcm_control/*"

FILES:${PN} += "\
    ${systemd_unitdir}/system-preset \
    ${datadir}/dbus-1/system-services/com.intel.adlink.Tabrmd.service \
    ${systemd_unitdir}/system/bcm.service \
  /lib \
  /lib/systemd \
  /lib/systemd/system \
  /lib/systemd/system/bcm.service \
  /opt \
  /lib/systemd/system/system \
  /opt/bcm_control \
  /opt/bcm_control/bcm.user \
  /opt/bcm_control/rc.soc \
  /opt/bcm_control/linux-user-bde.ko \
  /opt/bcm_control/config.bcm \
  /opt/bcm_control/custom_led.bin \
  /opt/bcm_control/netserve \
  /opt/bcm_control/linux-kernel-bde.ko \
  /opt/bcm_control/linkscan_led_fw.bin \
  /opt/bcm_control/bcm.sh \
"
do_package_qa(){
}

