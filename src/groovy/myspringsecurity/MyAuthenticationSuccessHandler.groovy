package myspringsecurity

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.web.authentication.AjaxAwareAuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import seguranca.Usuario

class MyAuthenticationSuccessHandler extends AjaxAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
		
		def usuarioLogado = authentication.getPrincipal().username
		
		if(usuarioLogado == 'admin'){
			redirectStrategy.sendRedirect(request, response, '/');
		}else{
			redirectStrategy.sendRedirect(request, response, '/');
		}
	}
}