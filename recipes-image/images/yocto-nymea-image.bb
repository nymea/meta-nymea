DESCRIPTION = "Yocto image for nymea"

IMAGE_FEATURES += "ssh-server-dropbear"

CORE_IMAGE_EXTRA_INSTALL = " \
    packagegroup-core-boot \
    busybox \
    packagegroup-nymea \
"

inherit core-image
