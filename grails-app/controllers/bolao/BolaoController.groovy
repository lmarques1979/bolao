package bolao

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class BolaoController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]
	static final String pathbolao = "grails-app/assets/images/bolao/";
	
    def index(Integer max) {
		def configuracoes = configuracaoParams
        respond Bolao.list(configuracoes), model:[bolaoInstanceCount: Bolao.count()]
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

		def imagem
		def f = request.getFile('arquivo')
		def bolao = params.descricao
		def diretorio = pathbolao + bolao
		def nomearquivo = f.getOriginalFilename()
		
		if (nomearquivo!=null && nomearquivo!=""){
		   imagem = diretorio  + '/' + nomearquivo
		}
		
		bolaoInstance.imagem = nomearquivo
		bolaoInstance.admin = usuarioLogado
		
		boolean deletou = new File(diretorio).deleteDir()
		def caminhoarquivo = new File(diretorio)
		caminhoarquivo.mkdirs()
		
		if(nomearquivo!=null && nomearquivo!=""){
			f.transferTo(new File(imagem))
		}
		
        bolaoInstance.save flush:true
		
		if (bolaoInstance.hasErrors()) {
			respond bolaoInstance.errors, view:'create'
			return
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

		def imagem
		def f = request.getFile('arquivo')
		def bolao = params.descricao
		def diretorio = pathbolao + bolao
		def nomearquivo = f.getOriginalFilename()
		
		if (nomearquivo!=null && nomearquivo!=""){
		   imagem = diretorio  + '/' + nomearquivo
		}
		
		bolaoInstance.imagem = nomearquivo
		
		boolean deletou = new File(diretorio).deleteDir()
		def caminhoarquivo = new File(diretorio)
		caminhoarquivo.mkdirs()
		
		if(nomearquivo!=null && nomearquivo!=""){
			f.transferTo(new File(imagem))
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

		def diretorio = pathbolao + bolaoInstance.descricao
		boolean deletou = new File(diretorio).deleteDir()
		
		if (deletou){
				bolaoInstance.delete flush:true
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
