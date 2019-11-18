DESCRIPTION = "nymea-plugins"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI="git://github.com/guh/nymea-plugins.git;protocol=https;branch=master"
SRCREV="0.16.0"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native"

require recipes-qt/qt5/qt5.inc
inherit qmake5

S = "${WORKDIR}/git"

PACKAGECONFIG ?= "anel \
	avahimonitor \
	awattar \
	boblight \
	commandlauncher \
	conrad \
	datetime \
	daylightsensor \
	denon \
	dweetio \
	elgato \
	elro \
	eq-3 \
	flowercare \
	genericelements \
	gpio \
	httpcommander \
	intertechno \
	keba \
	kodi \
	leynew \
	lgsmarttv \
	mailnotification \
	mqttclient \
	netatmo \
	networkdetector \
	openweathermap \
	osdomotics \
	philipshue \
	pushbullet \
	remotessh \
	senic \
	serialportcommander \
        shelly \
	simulation \
	tasmota \
	tcpcommander \
	texasinstruments \
	udpcommander \
	unitec \
	wakeonlan \
	wemo \
	"


PACKAGECONFIG[anel] = "PLUGINS+=anel, PLUGINS-=anel"
PACKAGECONFIG[avahimonitor] = "PLUGINS+=avahimonitor, PLUGINS-=avahimonitor"
PACKAGECONFIG[awattar] = "PLUGINS+=awattar, PLUGINS-=awattar"
PACKAGECONFIG[boblight] = "PLUGINS+=boblight, PLUGINS-=boblight, boblight"
PACKAGECONFIG[commandlauncher] = "PLUGINS+=commandlauncher, PLUGINS-=commandlauncher"
PACKAGECONFIG[conrad] = "PLUGINS+=conrad, PLUGINS-=conrad"
PACKAGECONFIG[datetime] = "PLUGINS+=datetime, PLUGINS-=datetime"
PACKAGECONFIG[daylightsensor] = "PLUGINS+=daylightsensor, PLUGINS-=daylightsensor"
PACKAGECONFIG[debian] = "PLUGINS+=debian, PLUGINS-=debian"
PACKAGECONFIG[denon] = "PLUGINS+=denon, PLUGINS-=denon"
PACKAGECONFIG[dweetio] = "PLUGINS+=dweetio, PLUGINS-=dweetio"
PACKAGECONFIG[elgato] = "PLUGINS+=elgato, PLUGINS-=elgato"
PACKAGECONFIG[elro] = "PLUGINS+=elro, PLUGINS-=elro"
PACKAGECONFIG[eq-3] = "PLUGINS+=eq-3, PLUGINS-=eq-3"
PACKAGECONFIG[flowercare] = "PLUGINS+=flowercare, PLUGINS-=flowercare"
PACKAGECONFIG[genericelements] = "PLUGINS+=genericelements, PLUGINS-=genericelements"
PACKAGECONFIG[gpio] = "PLUGINS+=gpio, PLUGINS-=gpio"
PACKAGECONFIG[httpcommander] = "PLUGINS+=httpcommander, PLUGINS-=httpcommander"
PACKAGECONFIG[intertechno] = "PLUGINS+=intertechno, PLUGINS-=intertechno"
PACKAGECONFIG[keba] = "PLUGINS+=keba, PLUGINS-=keba"
PACKAGECONFIG[kodi] = "PLUGINS+=kodi, PLUGINS-=kodi"
PACKAGECONFIG[leynew] = "PLUGINS+=leynew, PLUGINS-=leynew"
PACKAGECONFIG[lgsmarttv] = "PLUGINS+=lgsmarttv, PLUGINS-=lgsmarttv"
PACKAGECONFIG[mailnotification] = "PLUGINS+=mailnotification, PLUGINS-=mailnotification"
PACKAGECONFIG[mqttclient] = "PLUGINS+=mqttclient, PLUGINS-=mqttclient"
PACKAGECONFIG[netatmo] = "PLUGINS+=netatmo, PLUGINS-=netatmo"
PACKAGECONFIG[networkdetector] = "PLUGINS+=networkdetector, PLUGINS-=networkdetector"
PACKAGECONFIG[openweathermap] = "PLUGINS+=openweathermap, PLUGINS-=openweathermap"
PACKAGECONFIG[osdomotics] = "PLUGINS+=osdomotics, PLUGINS-=osdomotics"
PACKAGECONFIG[philipshue] = "PLUGINS+=philipshue, PLUGINS-=philipshue"
PACKAGECONFIG[pushbullet] = "PLUGINS+=pushbullet, PLUGINS-=pushbullet"
PACKAGECONFIG[remotessh] = "PLUGINS+=remotessh, PLUGINS-=remotessh"
PACKAGECONFIG[senic] = "PLUGINS+=senic, PLUGINS-=senic"
PACKAGECONFIG[serialportcommander] = "PLUGINS+=serialportcommander, PLUGINS-=serialportcommander, qtserialport"
PACKAGECONFIG[shelly] = "PLUGINS+=shelly, PLUGINS-=shelly"
PACKAGECONFIG[simulation] = "PLUGINS+=simulation, PLUGINS-=simulation"
PACKAGECONFIG[tasmota] = "PLUGINS+=tasmota, PLUGINS-=tasmota"
PACKAGECONFIG[tcpcommander] = "PLUGINS+=tcpcommander, PLUGINS-=tcpcommander"
PACKAGECONFIG[texasinstruments] = "PLUGINS+=texasinstruments, PLUGINS-=texasinstruments"
PACKAGECONFIG[translations] = "PLUGINS+=translations, PLUGINS-=translations"
PACKAGECONFIG[udpcommander] = "PLUGINS+=udpcommander, PLUGINS-=udpcommander"
PACKAGECONFIG[unitec] = "PLUGINS+=unitec, PLUGINS-=unitec"
PACKAGECONFIG[wakeonlan] = "PLUGINS+=wakeonlan, PLUGINS-=wakeonlan"
PACKAGECONFIG[wemo] = "PLUGINS+=wemo, PLUGINS-=wemo"


EXTRA_QMAKEVARS_PRE += "CONFIG+=selection ${PACKAGECONFIG_CONFARGS}"


FILES_nymea-plugin-anel = "${libdir}/nymea/plugins/libnymea_devicepluginanel.so"
FILES_nymea-plugin-avahimonitor = "${libdir}/nymea/plugins/libnymea_devicepluginavahimonitor.so"
FILES_nymea-plugin-awattar = "${libdir}/nymea/plugins/libnymea_devicepluginawattar.so"
FILES_nymea-plugin-boblight = "${libdir}/nymea/plugins/libnymea_devicepluginboblight.so"
FILES_nymea-plugin-commandlauncher = "${libdir}/nymea/plugins/libnymea_deviceplugincommandlauncher.so"
FILES_nymea-plugin-conrad = "${libdir}/nymea/plugins/libnymea_devicepluginconrad.so"
FILES_nymea-plugin-datetime = "${libdir}/nymea/plugins/libnymea_deviceplugindatetime.so"
FILES_nymea-plugin-daylightsensor = "${libdir}/nymea/plugins/libnymea_deviceplugindaylightsensor.so"
FILES_nymea-plugin-denon = "${libdir}/nymea/plugins/libnymea_deviceplugindenon.so"
FILES_nymea-plugin-dweetio = "${libdir}/nymea/plugins/libnymea_deviceplugindweetio.so"
FILES_nymea-plugin-elgato = "${libdir}/nymea/plugins/libnymea_devicepluginelgato.so"
FILES_nymea-plugin-elro = "${libdir}/nymea/plugins/libnymea_devicepluginelro.so"
FILES_nymea-plugin-eq-3 = "${libdir}/nymea/plugins/libnymea_deviceplugineq-3.so"
FILES_nymea-plugin-flowercare = "${libdir}/nymea/plugins/libnymea_devicepluginflowercare.so"
FILES_nymea-plugin-genericelements = "${libdir}/nymea/plugins/libnymea_deviceplugingenericelements.so"
FILES_nymea-plugin-gpio = "${libdir}/nymea/plugins/libnymea_deviceplugingpio.so"
FILES_nymea-plugin-httpcommander = "${libdir}/nymea/plugins/libnymea_devicepluginhttpcommander.so"
FILES_nymea-plugin-intertechno = "${libdir}/nymea/plugins/libnymea_devicepluginintertechno.so"
FILES_nymea-plugin-keba = "${libdir}/nymea/plugins/libnymea_devicepluginkeba.so"
FILES_nymea-plugin-kodi = "${libdir}/nymea/plugins/libnymea_devicepluginkodi.so"
FILES_nymea-plugin-leynew = "${libdir}/nymea/plugins/libnymea_devicepluginleynew.so"
FILES_nymea-plugin-lgsmarttv = "${libdir}/nymea/plugins/libnymea_devicepluginlgsmarttv.so"
FILES_nymea-plugin-mailnotification = "${libdir}/nymea/plugins/libnymea_devicepluginmailnotification.so"
FILES_nymea-plugin-mqttclient = "${libdir}/nymea/plugins/libnymea_devicepluginmqttclient.so"
FILES_nymea-plugin-netatmo = "${libdir}/nymea/plugins/libnymea_devicepluginnetatmo.so"
FILES_nymea-plugin-networkdetector = "${libdir}/nymea/plugins/libnymea_devicepluginnetworkdetector.so"
FILES_nymea-plugin-openweathermap = "${libdir}/nymea/plugins/libnymea_devicepluginopenweathermap.so"
FILES_nymea-plugin-osdomotics = "${libdir}/nymea/plugins/libnymea_devicepluginosdomotics.so"
FILES_nymea-plugin-philipshue = "${libdir}/nymea/plugins/libnymea_devicepluginphilipshue.so"
FILES_nymea-plugin-pushbullet = "${libdir}/nymea/plugins/libnymea_devicepluginpushbullet.so"
FILES_nymea-plugin-remotessh = "${libdir}/nymea/plugins/libnymea_devicepluginremotessh.so"
FILES_nymea-plugin-senic = "${libdir}/nymea/plugins/libnymea_devicepluginsenic.so"
FILES_nymea-plugin-serialportcommander = "${libdir}/nymea/plugins/libnymea_devicepluginserialportcommander.so"
FILES_nymea-plugin-shelly = "${libdir}/nymea/plugins/libnymea_devicepluginshelly.so"
FILES_nymea-plugin-simulation = "${libdir}/nymea/plugins/libnymea_devicepluginsimulation.so"
FILES_nymea-plugin-tasmota = "${libdir}/nymea/plugins/libnymea_deviceplugintasmota.so"
FILES_nymea-plugin-tcpcommander = "${libdir}/nymea/plugins/libnymea_deviceplugintcpcommander.so"
FILES_nymea-plugin-texasinstruments = "${libdir}/nymea/plugins/libnymea_deviceplugintexasinstruments.so"
FILES_nymea-plugin-translations = "${libdir}/nymea/plugins/libnymea_deviceplugintranslations.so"
FILES_nymea-plugin-udpcommander = "${libdir}/nymea/plugins/libnymea_devicepluginudpcommander.so"
FILES_nymea-plugin-unitec = "${libdir}/nymea/plugins/libnymea_devicepluginunitec.so"
FILES_nymea-plugin-wakeonlan = "${libdir}/nymea/plugins/libnymea_devicepluginwakeonlan.so"
FILES_nymea-plugin-wemo = "${libdir}/nymea/plugins/libnymea_devicepluginwemo.so"


PACKAGES += "nymea-plugin-anel \
	nymea-plugin-avahimonitor \
        nymea-plugin-awattar \
        nymea-plugin-boblight \
        nymea-plugin-commandlauncher \
        nymea-plugin-conrad \
        nymea-plugin-datetime \
        nymea-plugin-daylightsensor \
        nymea-plugin-denon \
        nymea-plugin-dweetio \
        nymea-plugin-elgato \
        nymea-plugin-elro \
        nymea-plugin-eq-3 \
        nymea-plugin-flowercare \
        nymea-plugin-genericelements \
        nymea-plugin-gpio \
        nymea-plugin-httpcommander \
        nymea-plugin-intertechno \
        nymea-plugin-keba \
        nymea-plugin-kodi \
        nymea-plugin-leynew \
        nymea-plugin-lgsmarttv \
        nymea-plugin-mailnotification \
        nymea-plugin-mqttclient \
        nymea-plugin-netatmo \
        nymea-plugin-networkdetector \
        nymea-plugin-openweathermap \
        nymea-plugin-osdomotics \
        nymea-plugin-philipshue \
        nymea-plugin-pushbullet \
        nymea-plugin-remotessh \
        nymea-plugin-senic \
        nymea-plugin-serialportcommander \
        nymea-plugin-shelly \
        nymea-plugin-simulation \
        nymea-plugin-tasmota \
        nymea-plugin-tcpcommander \
        nymea-plugin-texasinstruments \
        nymea-plugin-udpcommander \
        nymea-plugin-unitec \
        nymea-plugin-wakeonlan \
        nymea-plugin-wemo \
"
