DESCRIPTION = "Yocto image for nymea"

IMAGE_FEATURES += "ssh-server-dropbear"

CORE_IMAGE_EXTRA_INSTALL = " \
	nymead  \
        nymea-plugins \
        nymea-plugins-modbus \
        nymea-experience-plugin-energy \
        nymea-system-plugin-systemd \
        nymea-zeroconf-plugin-avahi \
	avahi-daemon \
	libavahi-client \
	"

inherit core-image
 
