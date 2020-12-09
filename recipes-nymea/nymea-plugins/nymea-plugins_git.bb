DESCRIPTION = "nymea-plugins"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-plugins.git;protocol=https;branch=experimental-silo"
# Release: experimental-silo
SRCREV="${AUTOREV}"
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


FILES_nymea-plugin-anel = "${libdir}/nymea/plugins/libnymea_integrationpluginanel.so"
FILES_nymea-plugin-aqi = "${libdir}/nymea/plugins/libnymea_integrationpluginaqi.so"
FILES_nymea-plugin-avahimonitor = "${libdir}/nymea/plugins/libnymea_integrationpluginavahimonitor.so"
FILES_nymea-plugin-awattar = "${libdir}/nymea/plugins/libnymea_integrationpluginawattar.so"
FILES_nymea-plugin-boblight = "${libdir}/nymea/plugins/libnymea_integrationpluginboblight.so"
FILES_nymea-plugin-bose = "${libdir}/nymea/plugins/libnymea_integrationpluginbose.so"
FILES_nymea-plugin-coinmarketcap = "${libdir}/nymea/plugins/libnymea_integrationplugincoinmarketcap.so"
FILES_nymea-plugin-commandlauncher = "${libdir}/nymea/plugins/libnymea_integrationplugincommandlauncher.so"
FILES_nymea-plugin-conrad = "${libdir}/nymea/plugins/libnymea_integrationpluginconrad.so"
FILES_nymea-plugin-datetime = "${libdir}/nymea/plugins/libnymea_integrationplugindatetime.so"
FILES_nymea-plugin-daylightsensor = "${libdir}/nymea/plugins/libnymea_integrationplugindaylightsensor.so"
FILES_nymea-plugin-denon = "${libdir}/nymea/plugins/libnymea_integrationplugindenon.so"
FILES_nymea-plugin-dweetio = "${libdir}/nymea/plugins/libnymea_integrationplugindweetio.so"
FILES_nymea-plugin-dynatrace = "${libdir}/nymea/plugins/libnymea_integrationplugindynatrace.so"
FILES_nymea-plugin-elgato = "${libdir}/nymea/plugins/libnymea_integrationpluginelgato.so"
FILES_nymea-plugin-elro = "${libdir}/nymea/plugins/libnymea_integrationpluginelro.so"
FILES_nymea-plugin-eq-3 = "${libdir}/nymea/plugins/libnymea_integrationplugineq-3.so"
FILES_nymea-plugin-flowercare = "${libdir}/nymea/plugins/libnymea_integrationpluginflowercare.so"
FILES_nymea-plugin-genericelements = "${libdir}/nymea/plugins/libnymea_integrationplugingenericelements.so"
FILES_nymea-plugin-genericthings = "${libdir}/nymea/plugins/libnymea_integrationplugingenericthings.so"
FILES_nymea-plugin-gpio = "${libdir}/nymea/plugins/libnymea_integrationplugingpio.so"
FILES_nymea-plugin-httpcommander = "${libdir}/nymea/plugins/libnymea_integrationpluginhttpcommander.so"
FILES_nymea-plugin-intertechno = "${libdir}/nymea/plugins/libnymea_integrationpluginintertechno.so"
FILES_nymea-plugin-keba = "${libdir}/nymea/plugins/libnymea_integrationpluginkeba.so"
FILES_nymea-plugin-kodi = "${libdir}/nymea/plugins/libnymea_integrationpluginkodi.so"
FILES_nymea-plugin-leynew = "${libdir}/nymea/plugins/libnymea_integrationpluginleynew.so"
FILES_nymea-plugin-lgsmarttv = "${libdir}/nymea/plugins/libnymea_integrationpluginlgsmarttv.so"
FILES_nymea-plugin-mailnotification = "${libdir}/nymea/plugins/libnymea_integrationpluginmailnotification.so"
FILES_nymea-plugin-mqttclient = "${libdir}/nymea/plugins/libnymea_integrationpluginmqttclient.so"
FILES_nymea-plugin-nanoleaf = "${libdir}/nymea/plugins/libnymea_integrationpluginnanoleaf.so"
FILES_nymea-plugin-netatmo = "${libdir}/nymea/plugins/libnymea_integrationpluginnetatmo.so"
FILES_nymea-plugin-networkdetector = "${libdir}/nymea/plugins/libnymea_integrationpluginnetworkdetector.so"
FILES_nymea-plugin-nuki = "${libdir}/nymea/plugins/libnymea_integrationpluginnuki.so"
FILES_nymea-plugin-onewire = "${libdir}/nymea/plugins/libnymea_integrationpluginonewire.so"
FILES_nymea-plugin-openuv = "${libdir}/nymea/plugins/libnymea_integrationpluginopenuv.so"
FILES_nymea-plugin-openweathermap = "${libdir}/nymea/plugins/libnymea_integrationpluginopenweathermap.so"
FILES_nymea-plugin-osdomotics = "${libdir}/nymea/plugins/libnymea_integrationpluginosdomotics.so"
FILES_nymea-plugin-philipshue = "${libdir}/nymea/plugins/libnymea_integrationpluginphilipshue.so"
FILES_nymea-plugin-pushbullet = "${libdir}/nymea/plugins/libnymea_integrationpluginpushbullet.so"
FILES_nymea-plugin-remotessh = "${libdir}/nymea/plugins/libnymea_integrationpluginremotessh.so"
FILES_nymea-plugin-senic = "${libdir}/nymea/plugins/libnymea_integrationpluginsenic.so"
FILES_nymea-plugin-serialportcommander = "${libdir}/nymea/plugins/libnymea_integrationpluginserialportcommander.so"
FILES_nymea-plugin-shelly = "${libdir}/nymea/plugins/libnymea_integrationpluginshelly.so"
FILES_nymea-plugin-simulation = "${libdir}/nymea/plugins/libnymea_integrationpluginsimulation.so"
FILES_nymea-plugin-sonos = "${libdir}/nymea/plugins/libnymea_integrationpluginsonos.so"
FILES_nymea-plugin-systemmonitor = "${libdir}/nymea/plugins/libnymea_integrationpluginsystemmonitor.so"
FILES_nymea-plugin-tado = "${libdir}/nymea/plugins/libnymea_integrationplugintado.so"
FILES_nymea-plugin-tasmota = "${libdir}/nymea/plugins/libnymea_integrationplugintasmota.so"
FILES_nymea-plugin-tcpcommander = "${libdir}/nymea/plugins/libnymea_integrationplugintcpcommander.so"
FILES_nymea-plugin-texasinstruments = "${libdir}/nymea/plugins/libnymea_integrationplugintexasinstruments.so"
FILES_nymea-plugin-tplink = "${libdir}/nymea/plugins/libnymea_integrationplugintplink.so"
FILES_nymea-plugin-tuya = "${libdir}/nymea/plugins/libnymea_integrationplugintuya.so"
FILES_nymea-plugin-udpcommander = "${libdir}/nymea/plugins/libnymea_integrationpluginudpcommander.so"
FILES_nymea-plugin-unifi = "${libdir}/nymea/plugins/libnymea_integrationpluginunifi.so"
FILES_nymea-plugin-unitec = "${libdir}/nymea/plugins/libnymea_integrationpluginunitec.so"
FILES_nymea-plugin-usbrelay = "${libdir}/nymea/plugins/libnymea_integrationpluginusbrelay.so"
FILES_nymea-plugin-wakeonlan = "${libdir}/nymea/plugins/libnymea_integrationpluginwakeonlan.so"
FILES_nymea-plugin-wemo = "${libdir}/nymea/plugins/libnymea_integrationpluginwemo.so"
FILES_nymea-plugin-ws2812fx = "${libdir}/nymea/plugins/libnymea_integrationpluginws2812fx.so"
FILES_nymea-plugin-zigbeegenericlights = "${libdir}/nymea/plugins/libnymea_integrationpluginzigbeegenericlights.so"
FILES_nymea-plugin-zigbeegeneric = "${libdir}/nymea/plugins/libnymea_integrationpluginzigbeegeneric.so"
FILES_nymea-plugin-zigbeelumi = "${libdir}/nymea/plugins/libnymea_integrationpluginzigbeelumi.so"
FILES_nymea-plugin-zigbeephilipshue = "${libdir}/nymea/plugins/libnymea_integrationpluginzigbeephilipshue.so"
FILES_nymea-plugin-zigbeetradfri = "${libdir}/nymea/plugins/libnymea_integrationpluginzigbeetradfri.so"


PACKAGES += "nymea-plugin-anel \
        nymea-plugin-aqi \
	nymea-plugin-avahimonitor \
        nymea-plugin-awattar \
        nymea-plugin-boblight \
        nymea-plugin-bose \
        nymea-plugin-coinmarketcap \
        nymea-plugin-commandlauncher \
        nymea-plugin-conrad \
        nymea-plugin-datetime \
        nymea-plugin-daylightsensor \
        nymea-plugin-denon \
        nymea-plugin-dweetio \
        nymea-plugin-dynatrace \
        nymea-plugin-elgato \
        nymea-plugin-elro \
        nymea-plugin-eq-3 \
        nymea-plugin-flowercare \
        nymea-plugin-genericelements \
        nymea-plugin-genericthings \
        nymea-plugin-gpio \
        nymea-plugin-httpcommander \
        nymea-plugin-intertechno \
        nymea-plugin-keba \
        nymea-plugin-kodi \
        nymea-plugin-leynew \
        nymea-plugin-lgsmarttv \
        nymea-plugin-mailnotification \
        nymea-plugin-mqttclient \
        nymea-plugin-nanoleaf \
        nymea-plugin-netatmo \
        nymea-plugin-networkdetector \
        nymea-plugin-nuki \
        nymea-plugin-onewire \
        nymea-plugin-openuv \
        nymea-plugin-openweathermap \
        nymea-plugin-osdomotics \
        nymea-plugin-philipshue \
        nymea-plugin-pushbullet \
        nymea-plugin-remotessh \
        nymea-plugin-senic \
        nymea-plugin-serialportcommander \
        nymea-plugin-shelly \
        nymea-plugin-simulation \
        nymea-plugin-sonos \
        nymea-plugin-systemmonitor \
        nymea-plugin-tado \
        nymea-plugin-tasmota \
        nymea-plugin-tcpcommander \
        nymea-plugin-texasinstruments \
        nymea-plugin-tplink \
        nymea-plugin-tuya \
        nymea-plugin-udpcommander \
        nymea-plugin-unifi \
        nymea-plugin-unitec \
        nymea-plugin-usbrelay \
        nymea-plugin-wakeonlan \
        nymea-plugin-wemo \
        nymea-plugin-ws2812fx \
        nymea-plugin-zigbeegenericlights \
        nymea-plugin-zigbeegeneric \
        nymea-plugin-zigbeelumi \
        nymea-plugin-zigbeephilipshue \
        nymea-plugin-zigbeetradfri \
"
