DESCRIPTION = "nymea's first yocto image"

IMAGE_FEATURES += "ssh-server-dropbear"

CORE_IMAGE_EXTRA_INSTALL = "opkg \
	nymead \
	"

inherit core-image

IMAGE_ROOTFS_SIZE = "16384"
 
