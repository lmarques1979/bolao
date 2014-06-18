package bolao

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import seguranca.Usuario

@Transactional(readOnly = true)
@Secured("isAuthenticated()")
class BaseController{ 
   
	def configurationService
	def springSecurityService
	
	def getConfiguracaoParams(){
		
			
			def resultado = Configuracao.findAll()
			resultado.each() {
				params.alturaimagens 		= it.alturaimagens ? it.alturaimagens : "120"
				params.larguraimagens 		= it.larguraimagens ? it.larguraimagens : "120"
				params.tamanhoiconetimes 	= it.tamanhoiconetimes ? it.tamanhoiconetimes : "32"
			}
			if (resultado.size() == 0){
				params.alturaimagens 		= "120"
				params.larguraimagens 		= "120"
				params.tamanhoiconetimes 	= "32"
			}
			params
	}
    def getPaginacaoParams(){
		
			
			def resultado = Usuario.findAllById(getUsuarioLogado().id)
			resultado.each() {
				params.max = Math.min(it.itensporpagina, 100)
            }
			if (resultado.size() == 0){
				params.max = Math.min(10, 100)
			}
    params
  }
	
  def getUsuarioLogado(){
	  	springSecurityService.currentUser
  }
 
} 