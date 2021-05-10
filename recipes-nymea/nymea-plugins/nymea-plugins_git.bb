DESCRIPTION = "nymea-plugins"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-plugins.git;protocol=https;branch=master"
# Release: 0.27.0
SRCREV="6eaa507bbcd825a88d3865316078a813cc5fb498"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native"

inherit qmake5

S = "${WORKDIR}/git"

PACKAGECONFIG ?= "anel \
        aqi \
        avahimonitor \
        awattar \
        bluos \
        ${@incompatible_license_contains('GPL-3.0', '', 'boblight', d)} \
        bose \
        coinmarketcap \
        commandlauncher \
        datetime \
        daylightsensor \
        denon \
        doorbird \
        dweetio \
        dynatrace \
        elgato \
        eq-3 \
        flowercare \
        fronius \
        genericelements \
        genericthings \
        gpio \
        homeconnect \
        httpcommander \
        i2cdevices \
        keba \
        kodi \
        lgsmarttv \
        lifx \
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
        pushnotifications \
        remotessh \
        senic \
        serialportcommander \
        shelly \
        simulation \
        solarlog \
        somfytahoma \
        sonos \
        systemmonitor \
        tado \
        tasmota \
        telegram \
        tempo \
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


PACKAGECONFIG[anel] = "WITH_PLUGINS+=anel, WITHOUT_PLUGINS+=anel"
PACKAGECONFIG[aqi] = "WITH_PLUGINS+=aqi, WITHOUT_PLUGINS+=aqi"
PACKAGECONFIG[avahimonitor] = "WITH_PLUGINS+=avahimonitor, WITHOUT_PLUGINS+=avahimonitor"
PACKAGECONFIG[awattar] = "WITH_PLUGINS+=awattar, WITHOUT_PLUGINS+=awattar"
PACKAGECONFIG[bluos] = "WITH_PLUGINS+=bluos, WITHOUT_PLUGINS+=bluos"
PACKAGECONFIG[boblight] = "WITH_PLUGINS+=boblight, WITHOUT_PLUGINS+=boblight, boblight"
PACKAGECONFIG[bose] = "WITH_PLUGINS+=bose, WITHOUT_PLUGINS+=bose"
PACKAGECONFIG[coinmarketcap] = "WITH_PLUGINS+=coinmarketcap, WITHOUT_PLUGINS+=coinmarketcap"
PACKAGECONFIG[commandlauncher] = "WITH_PLUGINS+=commandlauncher, WITHOUT_PLUGINS+=commandlauncher"
PACKAGECONFIG[conrad] = "WITH_PLUGINS+=conrad, WITHOUT_PLUGINS+=conrad"
PACKAGECONFIG[datetime] = "WITH_PLUGINS+=datetime, WITHOUT_PLUGINS+=datetime"
PACKAGECONFIG[daylightsensor] = "WITH_PLUGINS+=daylightsensor, WITHOUT_PLUGINS+=daylightsensor"
PACKAGECONFIG[denon] = "WITH_PLUGINS+=denon, WITHOUT_PLUGINS+=denon"
PACKAGECONFIG[doorbird] = "WITH_PLUGINS+=doorbird, WITHOUT_PLUGINS+=doorbird"
PACKAGECONFIG[dweetio] = "WITH_PLUGINS+=dweetio, WITHOUT_PLUGINS+=dweetio"
PACKAGECONFIG[dynatrace] = "WITH_PLUGINS+=dynatrace, WITHOUT_PLUGINS+=dynatrace"
PACKAGECONFIG[elgato] = "WITH_PLUGINS+=elgato, WITHOUT_PLUGINS+=elgato"
PACKAGECONFIG[elro] = "WITH_PLUGINS+=elro, WITHOUT_PLUGINS+=elro"
PACKAGECONFIG[eq-3] = "WITH_PLUGINS+=eq-3, WITHOUT_PLUGINS+=eq-3"
PACKAGECONFIG[flowercare] = "WITH_PLUGINS+=flowercare, WITHOUT_PLUGINS+=flowercare"
PACKAGECONFIG[fronius] = "WITH_PLUGINS+=fronius, WITHOUT_PLUGINS+=fronius"
PACKAGECONFIG[genericelements] = "WITH_PLUGINS+=genericelements, WITHOUT_PLUGINS+=genericelements"
PACKAGECONFIG[genericthings] = "WITH_PLUGINS+=genericthings, WITHOUT_PLUGINS+=genericthings"
PACKAGECONFIG[gpio] = "WITH_PLUGINS+=gpio, WITHOUT_PLUGINS+=gpio"
PACKAGECONFIG[homeconnect] = "WITH_PLUGINS+=homeconnect, WITHOUT_PLUGINS+=homeconnect"
PACKAGECONFIG[httpcommander] = "WITH_PLUGINS+=httpcommander, WITHOUT_PLUGINS+=httpcommander"
PACKAGECONFIG[i2cdevices] = "WITH_PLUGINS+=i2cdevices, WITHOUT_PLUGINS+=i2cdevices"
PACKAGECONFIG[intertechno] = "WITH_PLUGINS+=intertechno, WITHOUT_PLUGINS+=intertechno"
PACKAGECONFIG[keba] = "WITH_PLUGINS+=keba, WITHOUT_PLUGINS+=keba"
PACKAGECONFIG[kodi] = "WITH_PLUGINS+=kodi, WITHOUT_PLUGINS+=kodi"
PACKAGECONFIG[leynew] = "WITH_PLUGINS+=leynew, WITHOUT_PLUGINS+=leynew"
PACKAGECONFIG[lgsmarttv] = "WITH_PLUGINS+=lgsmarttv, WITHOUT_PLUGINS+=lgsmarttv"
PACKAGECONFIG[lifx] = "WITH_PLUGINS+=lifx, WITHOUT_PLUGINS+=lifx"
PACKAGECONFIG[mailnotification] = "WITH_PLUGINS+=mailnotification, WITHOUT_PLUGINS+=mailnotification"
PACKAGECONFIG[mqttclient] = "WITH_PLUGINS+=mqttclient, WITHOUT_PLUGINS+=mqttclient"
PACKAGECONFIG[nanoleaf] = "WITH_PLUGINS+=nanoleaf, WITHOUT_PLUGINS+=nanoleaf"
PACKAGECONFIG[netatmo] = "WITH_PLUGINS+=netatmo, WITHOUT_PLUGINS+=netatmo"
PACKAGECONFIG[networkdetector] = "WITH_PLUGINS+=networkdetector, WITHOUT_PLUGINS+=networkdetector"
PACKAGECONFIG[nuki] = "WITH_PLUGINS+=nuki, WITHOUT_PLUGINS+=nuki, libsodium"
PACKAGECONFIG[onewire] = "WITH_PLUGINS+=onewire, WITHOUT_PLUGINS+=onewire, owfs"
PACKAGECONFIG[openuv] = "WITH_PLUGINS+=openuv, WITHOUT_PLUGINS+=openuv"
PACKAGECONFIG[openweathermap] = "WITH_PLUGINS+=openweathermap, WITHOUT_PLUGINS+=openweathermap"
PACKAGECONFIG[osdomotics] = "WITH_PLUGINS+=osdomotics, WITHOUT_PLUGINS+=osdomotics"
PACKAGECONFIG[philipshue] = "WITH_PLUGINS+=philipshue, WITHOUT_PLUGINS+=philipshue"
PACKAGECONFIG[pushbullet] = "WITH_PLUGINS+=pushbullet, WITHOUT_PLUGINS+=pushbullet"
PACKAGECONFIG[pushnotifications] = "WITH_PLUGINS+=pushnotifications, WITHOUT_PLUGINS+=pushnotifications"
PACKAGECONFIG[remotessh] = "WITH_PLUGINS+=remotessh, WITHOUT_PLUGINS+=remotessh"
PACKAGECONFIG[senic] = "WITH_PLUGINS+=senic, WITHOUT_PLUGINS+=senic"
PACKAGECONFIG[serialportcommander] = "WITH_PLUGINS+=serialportcommander, WITHOUT_PLUGINS+=serialportcommander, qtserialport"
PACKAGECONFIG[shelly] = "WITH_PLUGINS+=shelly, WITHOUT_PLUGINS+=shelly"
PACKAGECONFIG[simulation] = "WITH_PLUGINS+=simulation, WITHOUT_PLUGINS+=simulation"
PACKAGECONFIG[solarlog] = "WITH_PLUGINS+=solarlog, WITHOUT_PLUGINS+=solarlog"
PACKAGECONFIG[somfytahoma] = "WITH_PLUGINS+=somfytahoma, WITHOUT_PLUGINS+=somfytahoma"
PACKAGECONFIG[sonos] = "WITH_PLUGINS+=sonos, WITHOUT_PLUGINS+=sonos"
PACKAGECONFIG[systemmonitor] = "WITH_PLUGINS+=systemmonitor, WITHOUT_PLUGINS+=systemmonitor"
PACKAGECONFIG[tado] = "WITH_PLUGINS+=tado, WITHOUT_PLUGINS+=tado"
PACKAGECONFIG[tasmota] = "WITH_PLUGINS+=tasmota, WITHOUT_PLUGINS+=tasmota"
PACKAGECONFIG[telegram] = "WITH_PLUGINS+=telegram, WITHOUT_PLUGINS+=telegram"
PACKAGECONFIG[tempo] = "WITH_PLUGINS+=tempo, WITHOUT_PLUGINS+=tempo"
PACKAGECONFIG[tcpcommander] = "WITH_PLUGINS+=tcpcommander, WITHOUT_PLUGINS+=tcpcommander"
PACKAGECONFIG[texasinstruments] = "WITH_PLUGINS+=texasinstruments, WITHOUT_PLUGINS+=texasinstruments"
PACKAGECONFIG[tplink] = "WITH_PLUGINS+=tplink, WITHOUT_PLUGINS+=tplink"
PACKAGECONFIG[tuya] = "WITH_PLUGINS+=tuya, WITHOUT_PLUGINS+=tuya"
PACKAGECONFIG[udpcommander] = "WITH_PLUGINS+=udpcommander, WITHOUT_PLUGINS+=udpcommander"
PACKAGECONFIG[unifi] = "WITH_PLUGINS+=unifi, WITHOUT_PLUGINS+=unifi"
PACKAGECONFIG[unitec] = "WITH_PLUGINS+=unitec, WITHOUT_PLUGINS+=unitec"
PACKAGECONFIG[usbrelay] = "WITH_PLUGINS+=usbrelay, WITHOUT_PLUGINS+=usbreleay, hidapi"
PACKAGECONFIG[wakeonlan] = "WITH_PLUGINS+=wakeonlan, WITHOUT_PLUGINS+=wakeonlan"
PACKAGECONFIG[wemo] = "WITH_PLUGINS+=wemo, WITHOUT_PLUGINS+=wemo"
PACKAGECONFIG[ws2812fx] = "WITH_PLUGINS+=ws2812fx, WITHOUT_PLUGINS+=ws2812fx"
PACKAGECONFIG[zigbeegenericlights] = "WITH_PLUGINS+=zigbeegenericlights, WITHOUT_PLUGINS+=zigbeegenericlights"
PACKAGECONFIG[zigbeegeneric] = "WITH_PLUGINS+=zigbeegeneric, WITHOUT_PLUGINS+=zigbeegeneric"
PACKAGECONFIG[zigbeelumi] = "WITH_PLUGINS+=zigbeelumi, WITHOUT_PLUGINS+=zigbeelumi"
PACKAGECONFIG[zigbeephilipshue] = "WITH_PLUGINS+=zigbeephilipshue, WITHOUT_PLUGINS+=zigbeephilipshue"
PACKAGECONFIG[zigbeetradfri] = "WITH_PLUGINS+=zigbeetradfri, WITHOUT_PLUGINS+=zigbeetradfri"


EXTRA_QMAKEVARS_PRE += "CONFIG+=selection ${PACKAGECONFIG_CONFARGS}"

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins after having bitbake'd nymea-plugins
PACKAGESPLITFUNCS_prepend = " split_nymea_plugins_packages "

python split_nymea_plugins_packages() {
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-%s', 'Nymea integration plugin for %s', extra_depends='')

    # Make nymea-plugins a meta package which RDEPENDS on all available nymea-plugin-
    d.setVar('RDEPENDS_' + d.getVar('PN'), ' '.join(plugins))
}

ALLOW_EMPTY_${PN} = "1"
FILES_${PN} = ""

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-.*"
