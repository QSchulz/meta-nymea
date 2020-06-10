PACKAGECONFIG += "sql-sqlite openssl"
# Only needed for nymea-app ATM because it requires gles2 pkgconfig in qtbase
PACKAGECONFIG += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"
