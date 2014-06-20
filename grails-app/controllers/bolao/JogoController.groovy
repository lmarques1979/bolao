package bolao
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.concurrent.TimeUnit

@Transactional(readOnly = true)
@Secured(["authentication.name=='admin'"])
class JogoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		
		def configuracoes = configuracaoParams
		Date datahoje = new Date(); // oldDate == current time
        Date datafiltro = new Date(datahoje.getTime() - TimeUnit.HOURS.toMillis(2)); // menos 2 horas 
		
		def resultado = Jogo.createCriteria().list (configuracoes) {
			eq("encerrado" , false)
			
		}
        respond resultado, model:[jogoInstanceCount: resultado.totalCount]
    }

    def show(Jogo jogoInstance) {
		def configuracoes = configuracaoParams
        respond jogoInstance
    }
	
	def filtro() {
		
		def filtro = params.filtrodatas
		def configuracoes = configuracaoParams
		
		def resultadofiltro = Jogo.createCriteria().list (configuracoes) {
			if(filtro=='2'){
				eq("encerrado" , false)
			}
			if(filtro=='3'){
				eq("encerrado" , true )
			}
		}
		respond resultadofiltro, model:[jogoInstanceCount: resultadofiltro.totalCount]
	}
	

    def create() {
        respond new Jogo(params)
    }

    @Transactional
    def save(Jogo jogoInstance) {
        if (jogoInstance == null) {
            notFound()
            return
        }
		
		def datahora        = params.datajogo + ' ' + params.horajogo
		jogoInstance.datajogo = new Date().parse("dd/MM/yyyy HH:mm", datahora)	
		jogoInstance.clearErrors()
        jogoInstance.save flush:true

		if (jogoInstance.hasErrors()) {
			respond jogoInstance.errors, view:'create'
			return
		}
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'jogo.label', default: 'Jogo'), jogoInstance.id])
                redirect jogoInstance
            }
            '*' { respond jogoInstance, [status: CREATED] }
        }
    }

    def edit(Jogo jogoInstance) {
		
		def df       	= new SimpleDateFormat("dd/MM/yyyy")
		def hf       	= new SimpleDateFormat("HH:mm")
		params.datajogo = df.format(jogoInstance.datajogo);
		params.horajogo = hf.format(jogoInstance.datajogo);
		respond jogoInstance
    }

    @Transactional
    def update(Jogo jogoInstance) {
        if (jogoInstance == null) {
            notFound()
            return
        }

		def datahora        	= params.datajogo + ' ' + params.horajogo
		jogoInstance.datajogo 	= new Date().parse("dd/MM/yyyy HH:mm", datahora)
		jogoInstance.clearErrors()
		
        jogoInstance.save flush:true
		
		if (jogoInstance.hasErrors()) {
			respond jogoInstance.errors, view:'edit'
			return
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Jogo.label', default: 'Jogo'), jogoInstance.id])
                redirect jogoInstance
            }
            '*'{ respond jogoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Jogo jogoInstance) {

        if (jogoInstance == null) {
            notFound()
            return
        }

        jogoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Jogo.label', default: 'Jogo'), jogoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'jogo.label', default: 'Jogo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
