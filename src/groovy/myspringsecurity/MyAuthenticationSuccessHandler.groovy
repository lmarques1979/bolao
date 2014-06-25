package myspringsecurity

import bolao.UsuarioBolao
import bolao.Bolao
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.web.authentication.AjaxAwareAuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import seguranca.Usuario
import static org.springframework.http.HttpStatus.*

class MyAuthenticationSuccessHandler extends AjaxAwareAuthenticationSuccessHandler{

		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){

		def bolao = request.getParameter("bolao")
		def usuario =  Usuario.get(authentication.getPrincipal().id)
		
		if(bolao!=null && bolao!=""){
			
			def resultado = UsuarioBolao.createCriteria().list() {
				eq("usuario.id" , usuario.id)
				eq("bolao.id" , Long.valueOf(bolao).longValue() )
				
			}
			
			//Não existe ainda, insiro
			if(resultado.size()==0){
					def usuarioBolaoInstance = new UsuarioBolao()
					usuarioBolaoInstance.usuario = usuario
					usuarioBolaoInstance.bolao = Bolao.get(Long.valueOf(bolao).longValue())
					
					usuarioBolaoInstance.save flush:true
					
					if (usuarioBolaoInstance.hasErrors()) {
						respond usuarioBolaoInstance.errors, view:'create'
						return
					}
			}
			
		}
		
		if(usuario.username == 'admin'){
			redirectStrategy.sendRedirect(request, response, '/');
		}else{
			redirectStrategy.sendRedirect(request, response, '/usuarioBolao/index');
		}
	}
}