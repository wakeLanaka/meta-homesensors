cmake_minimum_required(VERSION 3.10.0)
project(helloworld VERSION 0.1.0 LANGUAGES C)

find_package(PkgConfig REQUIRED)
pkg_check_modules(GPIOD REQUIRED libgpiod)

add_executable(helloworld helloworld.c)

target_link_libraries(helloworld PRIVATE ${GPIOD_LDFLAGS})

install(TARGETS helloworld DESTINATION bin)
