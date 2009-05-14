DESCRIPTION = "Erlang serial-port support"
SECTION = "devel/erlang"
PRIORITY = "optional"
RDEPENDS = "erlang"
DEPENDS = "erlang-native"

SRC_URI = "git://github.com/tonyg/erlang-serial.git;protocol=git"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

do_compile() {
	HOME=${OE_HOME} \
	oe_runmake
}

do_install() {
	oe_runmake install DESTDIR=${D}/${libdir}
}

FILES_${PN} = "${libdir}/erlang/lib/serial-*/ebin/* ${libdir}/erlang/lib/serial-*/priv/bin/* ${libdir}/erlang/lib/serial-*/src"
