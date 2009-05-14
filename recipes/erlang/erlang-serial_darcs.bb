DESCRIPTION = "Erlang serial-port support"
SECTION = "devel/erlang"
PRIORITY = "optional"
RDEPENDS = "erlang"
DEPENDS = "erlang-native"

SRC_URI = "file:///dev/null"
S = "${WORKDIR}/erlang-serial"

do_unpack() {
	darcs get http://www.eighty-twenty.org/~tonyg/Darcs/erlang-serial
}

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake install DESTDIR=${D}/${libdir}
}

FILES_${PN} = "${libdir}/erlang/lib/serial-*/ebin/* ${libdir}/erlang/lib/serial-*/priv/bin/* ${libdir}/erlang/lib/serial-*/src"
