package bolao

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class ResenhaController {

    static allowedMethods = [save: "POST", update: "PUT"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Resenha.list(params), model:[resenhaInstanceCount: Resenha.count()]
    }

    def show(Resenha resenhaInstance) {
        respond resenhaInstance
    }

    def create() {
        respond new Resenha(params)
    }

    @Transactional
    def save() {
		
	}

    def edit(Resenha resenhaInstance) {
        respond resenhaInstance
    }

    @Transactional
    def update(Resenha resenhaInstance) {
        if (resenhaInstance == null) {
            notFound()
            return
        }

        if (resenhaInstance.hasErrors()) {
            respond resenhaInstance.errors, view:'edit'
            return
        }

        resenhaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Resenha.label', default: 'Resenha'), resenhaInstance.id])
                redirect resenhaInstance
            }
            '*'{ respond resenhaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Resenha resenhaInstance) {
		
		def usuariobolaoid = resenhaInstance.usuariobolao.id
		
        if (resenhaInstance == null) {
            notFound()
            return
        }

        resenhaInstance.delete flush:true
		
		redirect controller:"usuarioBolao", action:"pontuacao" , params:[id:usuariobolaoid]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'resenha.label', default: 'Resenha'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
