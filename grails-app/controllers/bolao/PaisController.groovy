package bolao


import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(["authentication.name == 'admin'"]) 
class PaisController extends BaseController{ 

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		def configuracoes = configuracaoParams
        respond Pais.list(configuracoes), model:[paisInstanceCount: Pais.count()]
    }

    def show(Pais paisInstance) {
        respond paisInstance
    }

    def create() {
        respond new Pais(params)
    }

    @Transactional
    def save(Pais paisInstance) {
        if (paisInstance == null) {
            notFound()
            return
        }

        paisInstance.save flush:true
		
		if (paisInstance.hasErrors()) {
			respond paisInstance.errors, view:'create'
			return
		}


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pais.label', default: 'Pais'), paisInstance.id])
                redirect paisInstance
            }
            '*' { respond paisInstance, [status: CREATED] }
        }
    }

    def edit(Pais paisInstance) {
        respond paisInstance
    }

    @Transactional
    def update(Pais paisInstance) {
        if (paisInstance == null) {
            notFound()
            return
        }

		paisInstance.save flush:true
		
		if (paisInstance.hasErrors()) {
			respond paisInstance.errors, view:'edit'
			return
		}


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pais.label', default: 'Pais'), paisInstance.id])
                redirect paisInstance
            }
            '*'{ respond paisInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Pais paisInstance) {

        if (paisInstance == null) {
            notFound()
            return
        }

        paisInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pais.label', default: 'Pais'), paisInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pais.label', default: 'Pais'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
