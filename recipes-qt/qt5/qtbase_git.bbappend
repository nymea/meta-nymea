PACKAGECONFIG:append:class-target = "sql-sqlite openssl"

PACKAGECONFIG:append:class-native[openssl] = "-openssl,-no-openssl,openssl"
PACKAGECONFIG:append:class-native = "openssl"
