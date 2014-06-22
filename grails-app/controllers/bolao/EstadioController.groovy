package bolao

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(["authentication.name=='admin'"])
class EstadioController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def configuracoes = configuracaoParams
        respond Estadio.list(configuracoes), model:[estadioInstanceCount: Estadio.count()]
    }

    def show(Estadio estadioInstance) {
        respond estadioInstance
    }

    def create() {
        respond new Estadio(params)
    }

    @Transactional
    def save(Estadio estadioInstance) {
        if (estadioInstance == null) {
            notFound()
            return
        }

        if (estadioInstance.hasErrors()) {
            respond estadioInstance.errors, view:'create'
            return
        }

        estadioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'estadio.label', default: 'Estadio'), estadioInstance.id])
                redirect estadioInstance
            }
            '*' { respond estadioInstance, [status: CREATED] }
        }
    }

    def edit(Estadio estadioInstance) {
        respond estadioInstance
    }

    @Transactional
    def update(Estadio estadioInstance) {
        if (estadioInstance == null) {
            notFound()
            return
        }

        if (estadioInstance.hasErrors()) {
            respond estadioInstance.errors, view:'edit'
            return
        }

        estadioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Estadio.label', default: 'Estadio'), estadioInstance.id])
                redirect estadioInstance
            }
            '*'{ respond estadioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Estadio estadioInstance) {

        if (estadioInstance == null) {
            notFound()
            return
        }

        estadioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Estadio.label', default: 'Estadio'), estadioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadio.label', default: 'Estadio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
