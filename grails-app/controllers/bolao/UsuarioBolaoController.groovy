package bolao
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import funcoesdata.FuncoesData
import org.hibernate.criterion.CriteriaSpecification
import pontuacao.Pontuacao
import posicao.Posicao
import grails.plugin.springsecurity.annotation.Secured
import java.text.DateFormat

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class UsuarioBolaoController extends BaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		
		def configuracoes = configuracaoParams
		def ultimasAlteracoes = []
		def resultado = UsuarioBolao.createCriteria().list (configuracoes) {
			eq("usuario.id" , usuarioLogado.id)
			eq("autorizado" , true)
		}
		
		respond resultado, model:[usuarioBolaoInstanceCount: resultado.totalCount]
    }
	
	@Transactional
	def salvaresenha(){
		
		def resenhaInstance = new Resenha()
		def usuariobolaoid = Long.valueOf(params.idusuariobolao).longValue()
		
		resenhaInstance.usuariobolao = UsuarioBolao.get(usuariobolaoid)
		resenhaInstance.resenha = params.resenha
		resenhaInstance.save flush:true    
		
		if (resenhaInstance.hasErrors()) {
			redirect action:"pontuacao" , params:[id:usuariobolaoid]
		}
		
		redirect action:"pontuacao" , params:[id:usuariobolaoid]
	}
	
	@Transactional
	def atualizapontos(){
		
		def erros = []
		def i = 0
		
		def usuariobolao = UsuarioBolao.findAll()
		
		//Faço os cálculos dos pontos por cada palpite de cada usuário
		usuariobolao.each(){ usuariobolaoInstance ->
			
						
						usuariobolaoInstance.palpites.each(){ palpiteInstance-> 
								def dtultimaatualizacao = palpiteInstance.ultimaatualizacao
								def palpitetime1 = palpiteInstance.scoretime1
								def palpitetime2 = palpiteInstance.scoretime2
								def jogos = palpiteInstance.jogo
								jogos.each(){ jogo->
									
									//Só pego os jogos que ainda não foram computados, para melhorar a performance
									if(jogo.encerrado==true){
											
										//Só atualiza palpites onde a data do jogo for maior que a data da ultima atualizacao do palpite
										if (jogo.datajogo > dtultimaatualizacao || dtultimaatualizacao==null){
											
											def funcoesData = new FuncoesData()
											def data = funcoesData.hora(jogo)
											palpiteInstance.ultimaatualizacao = data
											
											def pontuacao = new Pontuacao()
											def pontos = pontuacao.contaPontos(jogo , palpitetime1 , palpitetime2)
											palpiteInstance.pontuacao = pontos
											palpiteInstance.save flush:true
											
											if (palpiteInstance.hasErrors()) {
												erros[i] = palpiteInstance.errors
												i++
											}
										}
									}
							}
				}
		}
		
		//Atualizo Posicoes
		def posicao = new Posicao()
		def errosposicao = posicao.atualizaPosicoes()
		
		if(i==0){
			flash.message = message(code: 'pontuacao.updated.message')
		}else{
			flash.erros = erros
		}
	}
	
	def listaautorizacao(Bolao bolaoInstance){
		
		def configuracoes = configuracaoParams
		def resultado = UsuarioBolao.createCriteria().list (configuracoes) {
			eq("bolao.id" , bolaoInstance.id)
		}
		respond resultado, model:[usuarioBolaoInstanceCount: resultado.totalCount]
	}
	
	
	@Transactional
	def autorizar(UsuarioBolao usuarioBolaoInstance){

		usuarioBolaoInstance.autorizado=true
		usuarioBolaoInstance.save flush:true
		
		if (usuarioBolaoInstance.hasErrors()) {
			respond usuarioBolaoInstance.errors, view:'listaautorizacao'
			return
		}else{
			flash.message = message(code: 'usuariobolao.autorizado.message')
			redirect(action:"listaautorizacao",id: usuarioBolaoInstance.bolao.id)
		}
		
	}
	
	@Transactional
	def desautorizar(UsuarioBolao usuarioBolaoInstance){

		usuarioBolaoInstance.autorizado=false
		usuarioBolaoInstance.save flush:true
		
		if (usuarioBolaoInstance.hasErrors()) {
			respond usuarioBolaoInstance.errors, view:'listaautorizacao'
			return
		}else{
			flash.message = message(code: 'usuariobolao.desautorizado.message')
			redirect(action:"listaautorizacao",id: usuarioBolaoInstance.bolao.id)
		}
		
	}
	
	def pontuacao(UsuarioBolao usuarioBolaoInstance){
		
		session["usuariobolao"] = usuarioBolaoInstance
		def configuracoes = configuracaoParams
		
		def resultado = UsuarioBolao.createCriteria().list(configuracoes) {
				createAlias("bolao", "b")
				eq('b.id', usuarioBolaoInstance.bolao.id)
				eq('b.enabled', true)
				createAlias("palpites", "palpite", CriteriaSpecification.LEFT_JOIN)
				projections {
					groupProperty("usuario")
					sum "palpite.pontuacao"
					max "palpite.usuariobolao"
					max "posicaoatual"
				}
				order("posicaoatual", "asc")
		}
		
		def resenhas = Resenha.createCriteria().list() {
			createAlias("usuariobolao", "ub")
			createAlias("ub.bolao", "bolao")
			eq('bolao.id', usuarioBolaoInstance.bolao.id)
			order("dateCreated", "desc")
		}
		respond usuarioBolaoInstance , model:[resenhasList: resenhas , usuariosBolao:resultado, usuarioBolaoInstanceCount: resultado.size()]
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

        usuarioBolaoInstance.save flush:true

		if (usuarioBolaoInstance.hasErrors()) {
			respond usuarioBolaoInstance.errors, view:'create'
			return
		}
		
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
