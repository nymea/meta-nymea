DESCRIPTION = "nymea-plugins"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-plugins.git;protocol=https;branch=master"
# Release: 0.26.0
SRCREV="68ca8605f36e360db31e8cd4031069c994632e39"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native"

inherit qmake5

S = "${WORKDIR}/git"

PACKAGECONFIG ?= "anel \
        aqi \
	avahimonitor \
	awattar \
	${@incompatible_license_contains('GPL-3.0', '', 'boblight', d)} \
        bose \
        coinmarketcap \
	commandlauncher \
	datetime \
	daylightsensor \
	denon \
	dweetio \
        dynatrace \
	elgato \
	eq-3 \
	flowercare \
        genericelements \
	genericthings \
	gpio \
	httpcommander \
	keba \
	kodi \
	lgsmarttv \
	mailnotification \
	mqttclient \
        nanoleaf \
	netatmo \
	networkdetector \
        nuki \
        onewire \
        openuv \
	openweathermap \
	osdomotics \
	philipshue \
	pushbullet \
	remotessh \
	senic \
	serialportcommander \
        shelly \
	simulation \
        sonos \
        systemmonitor \
        tado \
	tasmota \
	tcpcommander \
	texasinstruments \
        tplink \
        tuya \
	udpcommander \
        unifi \
        usbrelay \
	wakeonlan \
	wemo \
        ws2812fx \
        zigbeegenericlights \
        zigbeegeneric \
        zigbeelumi \
        zigbeephilipshue \
        zigbeetradfri \
	"


PACKAGECONFIG[anel] = "PLUGINS+=anel, PLUGINS-=anel"
PACKAGECONFIG[aqi] = "PLUGINS+=aqi, PLUGINS-=aqi"
PACKAGECONFIG[avahimonitor] = "PLUGINS+=avahimonitor, PLUGINS-=avahimonitor"
PACKAGECONFIG[awattar] = "PLUGINS+=awattar, PLUGINS-=awattar"
PACKAGECONFIG[boblight] = "PLUGINS+=boblight, PLUGINS-=boblight, boblight"
PACKAGECONFIG[bose] = "PLUGINS+=bose, PLUGINS-=bose"
PACKAGECONFIG[coinmarketcap] = "PLUGINS+=coinmarketcap, PLUGINS-=coinmarketcap"
PACKAGECONFIG[commandlauncher] = "PLUGINS+=commandlauncher, PLUGINS-=commandlauncher"
PACKAGECONFIG[conrad] = "PLUGINS+=conrad, PLUGINS-=conrad"
PACKAGECONFIG[datetime] = "PLUGINS+=datetime, PLUGINS-=datetime"
PACKAGECONFIG[daylightsensor] = "PLUGINS+=daylightsensor, PLUGINS-=daylightsensor"
PACKAGECONFIG[debian] = "PLUGINS+=debian, PLUGINS-=debian"
PACKAGECONFIG[denon] = "PLUGINS+=denon, PLUGINS-=denon"
PACKAGECONFIG[dweetio] = "PLUGINS+=dweetio, PLUGINS-=dweetio"
PACKAGECONFIG[dynatrace] = "PLUGINS+=dynatrace, PLUGINS-=dynatrace"
PACKAGECONFIG[elgato] = "PLUGINS+=elgato, PLUGINS-=elgato"
PACKAGECONFIG[elro] = "PLUGINS+=elro, PLUGINS-=elro"
PACKAGECONFIG[eq-3] = "PLUGINS+=eq-3, PLUGINS-=eq-3"
PACKAGECONFIG[flowercare] = "PLUGINS+=flowercare, PLUGINS-=flowercare"
PACKAGECONFIG[genericelements] = "PLUGINS+=genericelements, PLUGINS-=genericelements"
PACKAGECONFIG[genericthings] = "PLUGINS+=genericthings, PLUGINS-=genericthings"
PACKAGECONFIG[gpio] = "PLUGINS+=gpio, PLUGINS-=gpio"
PACKAGECONFIG[httpcommander] = "PLUGINS+=httpcommander, PLUGINS-=httpcommander"
PACKAGECONFIG[intertechno] = "PLUGINS+=intertechno, PLUGINS-=intertechno"
PACKAGECONFIG[keba] = "PLUGINS+=keba, PLUGINS-=keba"
PACKAGECONFIG[kodi] = "PLUGINS+=kodi, PLUGINS-=kodi"
PACKAGECONFIG[leynew] = "PLUGINS+=leynew, PLUGINS-=leynew"
PACKAGECONFIG[lgsmarttv] = "PLUGINS+=lgsmarttv, PLUGINS-=lgsmarttv"
PACKAGECONFIG[mailnotification] = "PLUGINS+=mailnotification, PLUGINS-=mailnotification"
PACKAGECONFIG[mqttclient] = "PLUGINS+=mqttclient, PLUGINS-=mqttclient"
PACKAGECONFIG[nanoleaf] = "PLUGINS+=nanoleaf, PLUGINS-=nanoleaf"
PACKAGECONFIG[netatmo] = "PLUGINS+=netatmo, PLUGINS-=netatmo"
PACKAGECONFIG[networkdetector] = "PLUGINS+=networkdetector, PLUGINS-=networkdetector"
PACKAGECONFIG[nuki] = "PLUGINS+=nuki, PLUGINS-=nuki, libsodium"
PACKAGECONFIG[onewire] = "PLUGINS+=onewire, PLUGINS-=onewire, owfs"
PACKAGECONFIG[openuv] = "PLUGINS+=openuv, PLUGINS-=openuv"
PACKAGECONFIG[openweathermap] = "PLUGINS+=openweathermap, PLUGINS-=openweathermap"
PACKAGECONFIG[osdomotics] = "PLUGINS+=osdomotics, PLUGINS-=osdomotics"
PACKAGECONFIG[philipshue] = "PLUGINS+=philipshue, PLUGINS-=philipshue"
PACKAGECONFIG[pushbullet] = "PLUGINS+=pushbullet, PLUGINS-=pushbullet"
PACKAGECONFIG[remotessh] = "PLUGINS+=remotessh, PLUGINS-=remotessh"
PACKAGECONFIG[senic] = "PLUGINS+=senic, PLUGINS-=senic"
PACKAGECONFIG[serialportcommander] = "PLUGINS+=serialportcommander, PLUGINS-=serialportcommander, qtserialport"
PACKAGECONFIG[shelly] = "PLUGINS+=shelly, PLUGINS-=shelly"
PACKAGECONFIG[simulation] = "PLUGINS+=simulation, PLUGINS-=simulation"
PACKAGECONFIG[sonos] = "PLUGINS+=sonos, PLUGINS-=sonos"
PACKAGECONFIG[systemmonitor] = "PLUGINS+=systemmonitor, PLUGINS-=systemmonitor"
PACKAGECONFIG[tado] = "PLUGINS+=tado, PLUGINS-=tado"
PACKAGECONFIG[tasmota] = "PLUGINS+=tasmota, PLUGINS-=tasmota"
PACKAGECONFIG[tcpcommander] = "PLUGINS+=tcpcommander, PLUGINS-=tcpcommander"
PACKAGECONFIG[texasinstruments] = "PLUGINS+=texasinstruments, PLUGINS-=texasinstruments"
PACKAGECONFIG[tplink] = "PLUGINS+=tplink, PLUGINS-=tplink"
PACKAGECONFIG[tuya] = "PLUGINS+=tuya, PLUGINS-=tuya"
PACKAGECONFIG[udpcommander] = "PLUGINS+=udpcommander, PLUGINS-=udpcommander"
PACKAGECONFIG[unifi] = "PLUGINS+=unifi, PLUGINS-=unifi"
PACKAGECONFIG[unitec] = "PLUGINS+=unitec, PLUGINS-=unitec"
PACKAGECONFIG[usbrelay] = "PLUGINS+=usbrelay, PLUGINS-=usbreleay, hidapi"
PACKAGECONFIG[wakeonlan] = "PLUGINS+=wakeonlan, PLUGINS-=wakeonlan"
PACKAGECONFIG[wemo] = "PLUGINS+=wemo, PLUGINS-=wemo"
PACKAGECONFIG[ws2812fx] = "PLUGINS+=ws2812fx, PLUGINS-=ws2812fx"
PACKAGECONFIG[zigbeegenericlights] = "PLUGINS+=zigbeegenericlights, PLUGINS-=zigbeegenericlights"
PACKAGECONFIG[zigbeegeneric] = "PLUGINS+=zigbeegeneric, PLUGINS-=zigbeegeneric"
PACKAGECONFIG[zigbeelumi] = "PLUGINS+=zigbeelumi, PLUGINS-=zigbeelumi"
PACKAGECONFIG[zigbeephilipshue] = "PLUGINS+=zigbeephilipshue, PLUGINS-=zigbeephilipshue"
PACKAGECONFIG[zigbeetradfri] = "PLUGINS+=zigbeetradfri, PLUGINS-=zigbeetradfri"


EXTRA_QMAKEVARS_PRE += "CONFIG+=selection ${PACKAGECONFIG_CONFARGS}"

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins after having bitbake'd nymea-plugins
PACKAGESPLITFUNCS_prepend = " split_nymea_plugins_packages "

python split_nymea_plugins_packages() {
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')
    do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-%s', 'Nymea integration plugin for %s', extra_depends='')
}

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-.*"
