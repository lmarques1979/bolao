package bolao

import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class DiversosController {

    def pontuacao() { 
		
	}
	
	def contato(){ 
		
		
	}
	
	def enviaremail(){
		def nomecontato 	= params.nomecontato
		def emailcontato 	= params.emailcontato
		def	telefonecontato	= params.telefonecontato
		def assuntocontato	= params.assuntocontato
		def mensagemcontato = ""
		
		mensagemcontato = mensagemcontato + message(code: 'nomecontato.label') + ":<b>" + nomecontato + '</b><br>'
		mensagemcontato = mensagemcontato + message(code: 'telefonecontato.label') + ":<b>" + telefonecontato + '</b><br>'
		mensagemcontato = mensagemcontato + message(code: 'mensagemcontato.label') + ":<br>"
		mensagemcontato = mensagemcontato + "<b>" + params.mensagemcontato + "</b>"
		
		//Envio E-mail
		sendMail {
			to "bolaovipcampeao@gmail.com"
			from emailcontato
			subject assuntocontato
			html mensagemcontato
		}
		
		flash.message = message(code: 'emailenviadocomsucesso.label')
		redirect action:"contato"
	}
	
}
