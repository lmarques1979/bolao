package bolao

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class BolaoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        respond Bolao.list(paginacaoParams), model:[bolaoInstanceCount: Bolao.count()]
    }

    def show(Bolao bolaoInstance) {
        respond bolaoInstance
    }

    def create() {
        respond new Bolao(params)
    }

    @Transactional
    def save(Bolao bolaoInstance) {
        if (bolaoInstance == null) {
            notFound()
            return
        }

        if (bolaoInstance.hasErrors()) {
            respond bolaoInstance.errors, view:'create'
            return
        }

        bolaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bolao.label', default: 'Bolao'), bolaoInstance.id])
                redirect bolaoInstance
            }
            '*' { respond bolaoInstance, [status: CREATED] }
        }
    }

    def edit(Bolao bolaoInstance) {
        respond bolaoInstance
    }

    @Transactional
    def update(Bolao bolaoInstance) {
        if (bolaoInstance == null) {
            notFound()
            return
        }

        if (bolaoInstance.hasErrors()) {
            respond bolaoInstance.errors, view:'edit'
            return
        }

        bolaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Bolao.label', default: 'Bolao'), bolaoInstance.id])
                redirect bolaoInstance
            }
            '*'{ respond bolaoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Bolao bolaoInstance) {

        if (bolaoInstance == null) {
            notFound()
            return
        }

        bolaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Bolao.label', default: 'Bolao'), bolaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bolao.label', default: 'Bolao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
