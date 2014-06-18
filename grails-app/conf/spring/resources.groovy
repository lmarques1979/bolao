// Place your Spring DSL code here
beans = {
	userDetailsService(usuario.UsuarioDetalheService)
	authenticationSuccessHandler(myspringsecurity.MyAuthenticationSuccessHandler)
}
