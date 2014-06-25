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

		def	usuariobolao= UsuarioBolao.get(Long.valueOf(parametros.usuariobolao).longValue())
		def total 		= Long.valueOf(params.totaljogos).longValue() 
		def i
		
		for(i=0 ; i < total; i++){
			
			/*if(params.scoretime1[i]!=null && params.scoretime2[i]!=null && params.scoretime1[i]!="" && params.scoretime2[i]){
				
				def jogo 	   		= Jogo.get(Long.valueOf(params.jogo[i]).longValue())
				def palpiteInstance = new Palpite()
				
				palpiteInstance.scoretime1 	= scoretime1
				palpiteInstance.scoretime2 	= scoretime2
				palpiteInstance.jogo 		= jogo
				palpiteInstance.usuariobolao= usuariobolao
				
				palpiteInstance.save flush:true
				
				if (palpiteInstance.hasErrors()) {
					respond palpiteInstance.errors, view:'create'
					return
				}
			}*/
		}	
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'palpite.label', default: 'Palpite'), palpiteInstance.id])
                redirect palpiteInstance
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

        if (palpiteInstance.hasErrors()) {
            respond palpiteInstance.errors, view:'edit'
            return
        }

        palpiteInstance.save flush:true

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
