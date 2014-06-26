package bolao

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class PalpiteController extends BaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def configuracoes = configuracaoParams
		def resultado = UsuarioBolao.createCriteria().list (configuracoes) {
			eq("bolao.id" , session["usuariobolao"].bolao.id)
			eq("usuario.id" , session["usuariobolao"].usuario.id)
			
		}
		[resultado:resultado , usuarioBolaoInstanceCount: resultado.totalCount]
    }

    def show(Palpite palpiteInstance) {
        respond palpiteInstance
    }

    def create() {
        respond new Palpite(params)
    }

    @Transactional
    def save() {
		
		def usuariobolao = UsuarioBolao.get(Long.valueOf(params.usuariobolao).longValue()) 
		def jogo , scoretime1 , scoretime2 , i
		
		params.each() { key, value -> 
			println key + "=>" + value
			if(key=="jogo"){
				jogo = value
			}
			if(key=="scoretime1"){
				scoretime1 = value
			}
			if(key=="scoretime2"){
				scoretime2 = value
			}
		}
		
		for(i=0 ; i < jogo.size() ; i++){
		
				def resultado = Palpite.createCriteria().list () {
						eq("usuariobolao.id" , usuariobolao.id)
						eq("jogo.id" , Long.valueOf(jogo[i]).longValue())
			
				}
				
				if(resultado.size()){
					
					def valor1 = scoretime1[i]
					def valor2 = scoretime2[i]
					
					if( valor1 && valor2 ){
						
							def palpiteInstance 		= new Palpite()
							palpiteInstance.jogo 		= Jogo.get(Long.valueOf(jogo[i]).longValue())
							palpiteInstance.scoretime1 	= Long.valueOf(scoretime1[i]).longValue()
							palpiteInstance.scoretime2 	= Long.valueOf(scoretime2[i]).longValue()
							palpiteInstance.usuariobolao= usuariobolao
							
							palpiteInstance.save flush:true
							
							if (palpiteInstance.hasErrors()) {
								respond palpiteInstance.errors, view:'edit'
								return
							}
					}
				}
				
		}
				
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'palpite.label', default: 'Palpite'), palpiteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*' { respond palpiteInstance, [status: CREATED] }
        }
    }

    def edit(Palpite palpiteInstance) {
        respond palpiteInstance
    }

    @Transactional
    def update(Palpite palpiteInstance) {
        if (palpiteInstance == null) {
            notFound()
            return
        }

        palpiteInstance.save flush:true
		
		if (palpiteInstance.hasErrors()) {
			respond palpiteInstance.errors, view:'edit'
			return
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Palpite.label', default: 'Palpite'), palpiteInstance.id])
                redirect palpiteInstance
            }
            '*'{ respond palpiteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Palpite palpiteInstance) {

        if (palpiteInstance == null) {
            notFound()
            return
        }

        palpiteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Palpite.label', default: 'Palpite'), palpiteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'palpite.label', default: 'Palpite'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
