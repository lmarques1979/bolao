package bolao
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(["authentication.name=='admin'"])
class CampeonatoController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]
	static final String pathcampeonato = "grails-app" + File.separator + "assets" + File.separator + "images" + File.separator + "campeonatos" + File.separator;
	
    def index(Integer max) {
		def configuracoes = configuracaoParams
        respond Campeonato.list(configuracoes), model:[campeonatoInstanceCount: Campeonato.count()]
    }

    def show(Campeonato campeonatoInstance) {
		def configuracoes = configuracaoParams
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
		def f = request.getFile('arquivo')
		if (!f.empty) {
			def imagem = fileUpload(f)
			campeonatoInstance.imagem = imagem
		}
		
		campeonatoInstance.save flush:true
		
		if (campeonatoInstance.hasErrors()) {
			respond campeonatoInstance.errors, view:'create'
			return
		}
		
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

		def f = request.getFile('arquivo')
		if (!f.empty) {
			def imagem = fileUpload(f)
			campeonatoInstance.imagem = imagem
		}
				
		campeonatoInstance.save flush:true
		
		if (campeonatoInstance.hasErrors()) {
			respond campeonatoInstance.errors, view:'edit'
			return
		}
		
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
		if (campeonatoInstance.hasErrors()) {
			respond campeonatoInstance.errors, view:'index'
			return
		}else{
			boolean deletou = fileDelete(campeonatoInstance.imagem)
		}
		
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
