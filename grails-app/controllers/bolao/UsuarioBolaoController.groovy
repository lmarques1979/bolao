package bolao
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.hibernate.criterion.CriteriaSpecification

@Transactional(readOnly = true)
class UsuarioBolaoController extends BaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		def configuracoes = configuracaoParams
		
		def resultado = UsuarioBolao.createCriteria().list (configuracoes) {
			eq("usuario.id" , usuarioLogado.id)
			
		}
		
        respond resultado, model:[usuarioBolaoInstanceCount: resultado.totalCount]
    }
	
	def pontuacao(UsuarioBolao usuarioBolaoInstance){
		session["usuariobolao"] = usuarioBolaoInstance
		def configuracoes = configuracaoParams
		
		def resultado = UsuarioBolao.createCriteria().list(configuracoes) {
				eq('bolao.id', usuarioBolaoInstance.bolao.id)
				createAlias("palpites", "palpite", CriteriaSpecification.LEFT_JOIN)
				projections {
					groupProperty("usuario")
					sum "palpite.pontuacao", "pontos" 
					max "palpite.usuariobolao"
				}
				order("pontos", "desc")
		}
		
		respond usuarioBolaoInstance , model:[usuariosBolao:resultado, usuarioBolaoInstanceCount: usuarioBolaoInstance.count()]
	}
	
    def show(UsuarioBolao usuarioBolaoInstance) {
		
    }

    def create() {
        respond new UsuarioBolao(params)
    }

    @Transactional
    def save(UsuarioBolao usuarioBolaoInstance) {
        if (usuarioBolaoInstance == null) {
            notFound()
            return
        }

        if (usuarioBolaoInstance.hasErrors()) {
            respond usuarioBolaoInstance.errors, view:'create'
            return
        }

        usuarioBolaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuarioBolao.label', default: 'UsuarioBolao'), usuarioBolaoInstance.id])
                redirect usuarioBolaoInstance
            }
            '*' { respond usuarioBolaoInstance, [status: CREATED] }
        }
    }

    def edit(UsuarioBolao usuarioBolaoInstance) {
        respond usuarioBolaoInstance
    }

    @Transactional
    def update(UsuarioBolao usuarioBolaoInstance) {
        if (usuarioBolaoInstance == null) {
            notFound()
            return
        }

        if (usuarioBolaoInstance.hasErrors()) {
            respond usuarioBolaoInstance.errors, view:'edit'
            return
        }

        usuarioBolaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UsuarioBolao.label', default: 'UsuarioBolao'), usuarioBolaoInstance.id])
                redirect usuarioBolaoInstance
            }
            '*'{ respond usuarioBolaoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UsuarioBolao usuarioBolaoInstance) {

        if (usuarioBolaoInstance == null) {
            notFound()
            return
        }

        usuarioBolaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UsuarioBolao.label', default: 'UsuarioBolao'), usuarioBolaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuarioBolao.label', default: 'UsuarioBolao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
