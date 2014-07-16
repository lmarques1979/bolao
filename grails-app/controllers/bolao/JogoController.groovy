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
		
		def filtrodata = session["filtrodata"]
		if(filtrodata==null){
			filtrodata = "2"
		}
		params.filtrodata=filtrodata
		def filtrocampeonato=session["filtrocampeonato"]
		if(filtrocampeonato==null || filtrocampeonato=="-1"){
			return
		}
		params.filtrocampeonato=filtrocampeonato
		
		def configuracoes = configuracaoParams
		
		def resultadofiltro = Jogo.createCriteria().list (configuracoes) {
			if(filtrodata=='2'){
				eq("encerrado" , false)
			}
			if(filtrodata=='3'){
				eq("encerrado" , true )
			}
			if(filtrocampeonato!='-1'){
				eq("campeonato.id" , Long.valueOf(filtrocampeonato).longValue() )
			}
		}
		respond resultadofiltro, model:[jogoInstanceCount: resultadofiltro.totalCount]
    }

    def show(Jogo jogoInstance) {
		def configuracoes = configuracaoParams
        respond jogoInstance
    }
	
	def filtro() {
		
		def filtrodata = params.filtrodata
		session["filtrodata"] = filtrodata
		if(filtrodata==null){
			filtrodata = "2"
		}
		params.filtrodata=filtrodata
		def filtrocampeonato = params.filtrocampeonato
		session["filtrocampeonato"] = filtrocampeonato
		if(filtrocampeonato==null || filtrocampeonato=="-1"){
			return
		}
		params.filtrocampeonato=filtrocampeonato
		
		def configuracoes = configuracaoParams
		def resultadofiltro = Jogo.createCriteria().list (configuracoes) {
			if(filtrodata=='2'){
				eq("encerrado" , false)
			}
			if(filtrodata=='3'){
				eq("encerrado" , true )
			}
			if(filtrocampeonato!='-1'){
				eq("campeonato.id" , Long.valueOf(filtrocampeonato).longValue() )
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

		def datahora = params.datajogo + ' ' + params.horajogo
		if(datahora!=null && datahora.trim()!=""){
			jogoInstance.datajogo = new Date().parse("dd/MM/yyyy HH:mm", datahora)	
			jogoInstance.clearErrors()
		}
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
		
		def datahora = params.datajogo + ' ' + params.horajogo
		def formatoData   = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		def datajogo	= formatoData.parse(datahora)
		
		jogoInstance.datajogo = datajogo
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
