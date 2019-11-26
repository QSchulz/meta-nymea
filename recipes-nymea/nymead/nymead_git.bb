DESCRIPTION = "nymea"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=75c6d0a8c08698a4cd93d203ae92362e"

SRC_URI="git://github.com/guh/nymea.git;protocol=https;branch=master \
	file://init \
	"
SRCREV="0.16.0"
PV = "git${SRCPV}"

S = "${WORKDIR}/git"

inherit update-rc.d qmake5

BBCLASSEXTEND += "native"

DEPENDS = "qtbase qtwebsockets qtconnectivity nymea-mqtt"
DEPENDS_append_class-target = " nymea-remoteproxy"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "nymead"
#INISCRIPTS_PARAMS = "defaults 10"

EXTRA_QMAKEVARS_PRE_class-native += "CONFIG+=minimal"

do_install_append_class-target() {
       install -d ${D}${INIT_D_DIR}
       install -m 0755 ${WORKDIR}/init ${D}${INIT_D_DIR}/nymead
       echo  "******************* Installing **************"
       find ${WORKDIR} -name nymead
}

FILES_${PN}-test = "${libdir}/nymea/plugins/libnymea_devicepluginmock.so \
	/usr/tests/*"
PACKAGES += "${PN}-test"
