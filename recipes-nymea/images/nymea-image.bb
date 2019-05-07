DESCRIPTION = "nymea's first yocto image"

IMAGE_FEATURES += "ssh-server-dropbear"

inherit core-image updatehub-image

CORE_IMAGE_EXTRA_INSTALL += " \
    nymead \
"
