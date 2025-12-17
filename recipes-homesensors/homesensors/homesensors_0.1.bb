SUMMARY = "A simple C program that prints 'Hello, World' on the target."
DESCRIPTION = "This is the first custom application built with Yocto."
LICENSE = "CLOSED"

PV = "1.0"

S = "${WORKDIR}"

SRC_URI = "file://helloworld.c \
           file://CMakeLists.txt \
           file://helloworld.service"

DEPENDS += "libgpiod-dev"

inherit pkgconfig cmake systemd
OECMAKE_TARGET = "all"
EXTRA_OECMAKE = ""
SYSTEMD_SERVICE:${PN} = "helloworld.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/helloworld.service ${D}${systemd_system_unitdir}/
}
