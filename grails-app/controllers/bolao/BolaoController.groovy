package bolao

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.mapping.LinkGenerator

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class BolaoController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]
	static final String pathbolao = "grails-app" + File.separator + "assets" + File.separator + "images" + File.separator + "bolao" + File.separator;
	LinkGenerator grailsLinkGenerator
	
    def index(Integer max) {
		
		def configuracoes = configuracaoParams
		def resultado = Bolao.createCriteria().list (configuracoes) {
			eq("admin" , usuarioLogado)
			
		}
        respond resultado, model:[bolaoInstanceCount: resultado.totalCount]
    }
	
	@Secured('permitAll')
	def verifica() {
		
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
		
		def f = request.getFile('arquivo')
		if (!f.empty) {
			def imagem = fileUpload(f)
			bolaoInstance.imagem = imagem
		}		
		
		bolaoInstance.admin = usuarioLogado
		bolaoInstance.save flush:true
		
		if (bolaoInstance.hasErrors()) {
			respond bolaoInstance.errors, view:'create'
			return
		}else{
		
			def usuarioBolaoInstance = new UsuarioBolao()
			usuarioBolaoInstance.usuario = usuarioLogado
			usuarioBolaoInstance.bolao = bolaoInstance
			//Administrador não precisa de autorização
			usuarioBolaoInstance.autorizado=true
			usuarioBolaoInstance.save flush:true
			
			if (usuarioBolaoInstance.hasErrors()) {
				respond usuarioBolaoInstance.errors, view:'create'
				return
			}
			
		}
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

		def f = request.getFile('arquivo')
		if (!f.empty) {
			def imagem = fileUpload(f)
			bolaoInstance.imagem = imagem
		}
		
        bolaoInstance.save flush:true
		
		if (bolaoInstance.hasErrors()) {
			respond bolaoInstance.errors, view:'edit'
			return
		}
		
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
		if (bolaoInstance.hasErrors()) {
			respond bolaoInstance.errors, view:'index'
			return
		}else{
			boolean deletou = fileDelete(bolaoInstance.imagem)
		}
		
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
