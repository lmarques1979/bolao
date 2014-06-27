package bolao

import static org.springframework.http.HttpStatus.*
import funcoesdata.FuncoesData
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class PalpiteController extends BaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	def PalpiteService
	
    def index(Integer max) {
		
		def usuarioBolao
		def configuracoes = configuracaoParams
		def usuarioBolaoList = UsuarioBolao.findAll("from UsuarioBolao as ub where ub.bolao.id=? and ub.usuario.id=?", [session["usuariobolao"].bolao.id , session["usuariobolao"].usuario.id])
		usuarioBolaoList.each(){ usuariobolao -> 
			usuarioBolao = usuariobolao
		}
		def jogos = usuarioBolao.bolao.campeonato.jogos
		def palpites = jogos.collect{usuarioBolao.buscarPalpiteJogo(it , configuracaoParams.minutosparapalpite)}
		
		respond palpites, model:[palpitesList: palpites, palpiteInstanceCount: palpites.size()]
	}

    def show(Palpite palpiteInstance) {
        respond palpiteInstance
    }

    def create() {
        respond new Palpite(params)
    }
	
	@Transactional
	def atualizapontos(){

		def resultado = Palpite.createCriteria().list () {
			eq("jogo.encerrado" , true)
			
		}
		
		//Faço os cálculos dos pontos por cada palpite de cada usuário
		resultado.each(){
			
		}
		
		respond resultadofiltro, model:[jogoInstanceCount: resultadofiltro.totalCount]
	}
	
    @Transactional
    def save() {
		
		def usuarioBolao
		def usuarioBolaoList = UsuarioBolao.findAll("from UsuarioBolao as ub where ub.bolao.id=? and ub.usuario.id=?", [session["usuariobolao"].bolao.id , session["usuariobolao"].usuario.id])
		usuarioBolaoList.each(){ usuariobolao ->
			usuarioBolao = usuariobolao
		}
		
		def finalizados		= params.list('palpitefinalizado')
		def idPalpites 		= params.list('id')
		def jogos 			= params.list('jogo')
		def scoretime1 		= params.list('scoretime1')
		def scoretime2 		= params.list('scoretime2')
		def configuracoes 	= configuracaoParams
		def erros = []
		def i = 0
		idPalpites.eachWithIndex{ it, index ->
			
			def idPalpite 	= it
			def jogo 		= Jogo.get(Long.valueOf(jogos[index]).longValue())
			def score1 		= scoretime1[index]
			def score2 		= scoretime2[index]
			def	finalizado  = finalizados[index].toBoolean()
			
			
			def funcoesData 	= new FuncoesData()
			def finalizadoAtual = funcoesData.diferencaMinutos(jogo.datajogo , configuracoes.minutosparapalpite)
			
			if(finalizado != finalizadoAtual){
				erros[i] = 'Palpite do jogo ' + jogo.time1.descricao + ' x ' + jogo.time2.descricao + ' já foi finalizado.'
				i++
			}
			
			//Incluo ou atualizo palpite
			def palpiteInstance = PalpiteService.salvarPalpite(idPalpite ,jogo , score1 , score2 , finalizado , usuarioBolao)
			
			if(palpiteInstance!=null){
				if (palpiteInstance.hasErrors()) {
					respond palpiteInstance.errors, view:'index'
					return
				}
			}
			
		}
		if(i==0){
			flash.message = message(code: 'palpite.updated.message')
		}else{
			flash.erros = erros
		}
		
		redirect action:"index" 
	}

    def edit(Palpite palpiteInstance) {
        respond palpiteInstance
    }

    @Transactional
    def update(Palpite palpiteInstance) {
        if (palpiteInstance == null) {
            notFound()
            return
        }

        palpiteInstance.save flush:true
		
		if (palpiteInstance.hasErrors()) {
			respond palpiteInstance.errors, view:'edit'
			return
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Palpite.label', default: 'Palpite'), palpiteInstance.id])
                redirect palpiteInstance
            }
            '*'{ respond palpiteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Palpite palpiteInstance) {

        if (palpiteInstance == null) {
            notFound()
            return
        }

        palpiteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Palpite.label', default: 'Palpite'), palpiteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'palpite.label', default: 'Palpite'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
