DESCRIPTION = "Erlang GTK+v2 support"
SECTION = "devel/erlang"
PRIORITY = "optional"
RDEPENDS = "libglade erlang"
DEPENDS = "erlang-native erlang"

SRC_URI = "http://gtknode.googlecode.com/files/gtknode-${PV}.tar.gz \
	   file://erlang-gtknode-configure-cross.patch;patch=1 \
	   file://move_g_log_set_always_fatal.patch;patch=1 \
	   file://longer-bored-timeout.patch;patch=1 \
	   "
S = "${WORKDIR}/gtknode-${PV}"

inherit autotools

do_configure_prepend() {
	ERLANG_STAGING_LIB_DIR=${STAGING_LIBDIR}/erlang/lib
	export ERLANG_STAGING_LIB_DIR
	export HOME=${OE_HOME}
}

do_compile_prepend() {
	export HOME=${OE_HOME}
}

PACKAGES =+ "${PN}-examples"

FILES_${PN}-dbg += "${libdir}/erlang/lib/gtknode-${PV}/.debug ${libdir}/erlang/lib/gtknode-${PV}/*/.debug ${libdir}/erlang/lib/gtknode-${PV}/*/*/.debug"
FILES_${PN} += "${libdir}/erlang/lib/gtknode-${PV}/ebin ${libdir}/erlang/lib/gtknode-${PV}/priv ${libdir}/erlang/lib/gtknode-${PV}/src"
FILES_${PN}-examples += "${libdir}/erlang/lib/gtknode-${PV}/examples"
FILES_${PN}-doc += "${libdir}/erlang/lib/gtknode-${PV}/doc"
