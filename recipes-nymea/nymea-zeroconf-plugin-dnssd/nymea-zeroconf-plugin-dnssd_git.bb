DESCRIPTION = "nymea-zeroconf-plugin-dnssd"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404 \
                  file://platformzeroconfcontrollerdnssd.cpp;endline=29;md5=02466154ec3d6f169e687813994f869a"

SRC_URI="git://github.com/nymea/nymea-zeroconf-plugin-dnssd.git;protocol=https"
# Release: 0.2
SRCREV="d67db8d7c743929ddda48efee2cab2a55fe35344"
PV = "git${SRCPV}"

DEPENDS += "nymead mdns"

inherit qmake5

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/nymea/platform/libnymea_zeroconfplugindnssd.so"
