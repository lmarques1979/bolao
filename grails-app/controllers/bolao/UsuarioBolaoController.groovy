package bolao
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import org.hibernate.criterion.CriteriaSpecification
import pontuacao.Pontuacao

@Transactional(readOnly = true)
class UsuarioBolaoController extends BaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		def configuracoes = configuracaoParams
		
		def resultado = UsuarioBolao.createCriteria().list (configuracoes) {
			eq("usuario.id" , usuarioLogado.id)
			eq("autorizado" , true)
		}
		
        respond resultado, model:[usuarioBolaoInstanceCount: resultado.totalCount]
    }
	
	@Transactional
	def atualizapontos(){
		
		def erros = []
		def i = 0
		
		def usuariobolao = UsuarioBolao.findAll()
		
		//Faço os cálculos dos pontos por cada palpite de cada usuário
		usuariobolao.each(){ usuariobolaoInstance->
			
				
						usuariobolaoInstance.palpites.each(){ palpite-> 
								def palpitetime1 = palpiteInstance.scoretime1
								def palpitetime2 = palpiteInstance.scoretime2
								def jogos = palpiteInstance.jogo
								jogos.each(){ jogo->
									
									if(jogo.encerrado==true){
											
											def pontuacao = new Pontuacao()
											def scoretime1 	= jogo.scoretime1
											def scoretime2 	= jogo.scoretime2
											def peso 		= jogo.peso
											def pontos = pontuacao.contaPontos(scoretime1 , scoretime2 , palpitetime1 , palpitetime2, peso)
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
					sum "palpite.pontuacao", "pontos" 
					max "palpite.usuariobolao"
				}
				order("pontos", "desc")
		}
		
		respond usuarioBolaoInstance , model:[usuariosBolao:resultado, usuarioBolaoInstanceCount: resultado.size()]
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
