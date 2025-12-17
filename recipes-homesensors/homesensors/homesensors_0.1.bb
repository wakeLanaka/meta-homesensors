SUMMARY = "A simple C program that prints 'Hello, World' on the target."
DESCRIPTION = "This is the first custom application built with Yocto."
LICENSE = "CLOSED"

PV = "1.0"


SRC_URI = "git://github.com/wakeLanaka/homesensors_code.git;protocol=https;branch=main \
           file://helloworld.service"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig cmake systemd
OECMAKE_TARGET = "all"
EXTRA_OECMAKE = ""
SYSTEMD_SERVICE:${PN} = "helloworld.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/helloworld.service ${D}${systemd_system_unitdir}/
}
