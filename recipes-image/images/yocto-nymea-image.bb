DESCRIPTION = "nymea's first yocto image"

IMAGE_FEATURES += "ssh-server-dropbear"

CORE_IMAGE_EXTRA_INSTALL = " \
	nymead \
	"

inherit core-image
 
