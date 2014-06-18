package bolao
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(["authentication.name=='admin'"])
class CampeonatoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        respond Campeonato.list(paginacaoParams), model:[campeonatoInstanceCount: Campeonato.count()]
    }

    def show(Campeonato campeonatoInstance) {
        respond campeonatoInstance
    }

    def create() {
        respond new Campeonato(params)
    }

    @Transactional
    def save(Campeonato campeonatoInstance) {
        if (campeonatoInstance == null) {
            notFound()
            return
        }

        if (campeonatoInstance.hasErrors()) {
            respond campeonatoInstance.errors, view:'create'
            return
        }

        campeonatoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'campeonato.label', default: 'Campeonato'), campeonatoInstance.id])
                redirect campeonatoInstance
            }
            '*' { respond campeonatoInstance, [status: CREATED] }
        }
    }

    def edit(Campeonato campeonatoInstance) {
        respond campeonatoInstance
    }

    @Transactional
    def update(Campeonato campeonatoInstance) {
        if (campeonatoInstance == null) {
            notFound()
            return
        }

        if (campeonatoInstance.hasErrors()) {
            respond campeonatoInstance.errors, view:'edit'
            return
        }

        campeonatoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Campeonato.label', default: 'Campeonato'), campeonatoInstance.id])
                redirect campeonatoInstance
            }
            '*'{ respond campeonatoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Campeonato campeonatoInstance) {

        if (campeonatoInstance == null) {
            notFound()
            return
        }

        campeonatoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Campeonato.label', default: 'Campeonato'), campeonatoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'campeonato.label', default: 'Campeonato'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
