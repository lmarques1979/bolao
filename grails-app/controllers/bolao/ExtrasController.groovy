package bolao

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(["authentication.name=='admin'"])
class ExtrasController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT"]

    def index(Integer max) {
        def configuracoes = configuracaoParams
        respond Extras.list(configuracoes), model:[extrasInstanceCount: Extras.count()]
    }

    def show(Extras extrasInstance) {
        respond extrasInstance
    }

    def create() {
		def configuracoes = configuracaoParams
        respond new Extras(params)
    }

    @Transactional
    def save(Extras extrasInstance) {
        if (extrasInstance == null) {
            notFound()
            return
        }

        extrasInstance.save flush:true
		
		if (extrasInstance.hasErrors()) {
			respond extrasInstance.errors, view:'create'
			return
		}

		redirect(controller: "jogo", action: "edit", params:[id:params.jogo])
   }

    def edit(Extras extrasInstance) {
		def configuracoes = configuracaoParams
		params.id= extrasInstance.jogo.id
        respond extrasInstance
    }

    @Transactional
    def update(Extras extrasInstance) {
        if (extrasInstance == null) {
            notFound()
            return
        }

        if (extrasInstance.hasErrors()) {
            respond extrasInstance.errors, view:'edit'
            return
        }

        extrasInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Extras.label', default: 'Extras'), extrasInstance.id])
                redirect extrasInstance
            }
            '*'{ respond extrasInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Extras extrasInstance) {

        if (extrasInstance == null) {
            notFound()
            return
        }
		
		def idjogo = extrasInstance.jogo.id
		
        extrasInstance.delete flush:true
		
		redirect(controller: "jogo", action: "edit", params:[id:idjogo])
		
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'extras.label', default: 'Extras'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
