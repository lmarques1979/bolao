package bolao

import static org.springframework.http.HttpStatus.*
import funcoesdata.FuncoesData
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import java.text.SimpleDateFormat

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class PalpiteController extends BaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	def PalpiteService
	
    def index() {
		def configuracoes = configuracaoParams
		def palpitenovos = []
		def palpitesfinalizados = []
		def palpites = []
		def erros = []
		
		def filtropalpite=params.filtrodatapalpite
		if(filtropalpite==null){
			filtropalpite="2"
		}
		def usuarioBolaoInstance=UsuarioBolao.get(Long.valueOf(params.id).longValue())
		if(usuarioBolaoInstance.usuario!=usuarioLogado){
			erros[0] = message(code: 'palpite.naoautorizado.message')
			flash.erros = erros
			return
		}
		def usuarioBolaoList = UsuarioBolao.findAll("from UsuarioBolao as ub where ub.bolao.id=? and ub.usuario.id=?", [ usuarioBolaoInstance.bolao.id , usuarioBolaoInstance.usuario.id])
		def jogos = usuarioBolaoInstance.bolao.campeonato.jogos
		//def palpites = jogos.collect{usuarioBolaoInstance.buscarPalpiteJogo(it , configuracaoParams.minutosparapalpite)}
		
		jogos.each(){
			def palpite = usuarioBolaoInstance.buscarPalpiteJogo(it , configuracaoParams.minutosparapalpite)
			palpite.finalizado==true ? palpitesfinalizados << palpite : palpitenovos << palpite
		}
		if(filtropalpite=="1"){
			palpites.addAll(palpitesfinalizados)
			palpites.addAll(palpitenovos)
		}
		if(filtropalpite=="2"){
			palpites.addAll(palpitenovos)
		}
		if(filtropalpite=="3"){
			palpites.addAll(palpitesfinalizados)
		}
		
		respond palpites, model:[usuarioBolaoInstance:usuarioBolaoInstance, palpitesList: palpites, palpiteInstanceCount: palpites.size()]
	}
	
	def palpiteusuario() {
		
		def filtrojogos = params.filtrojogos
		if(filtrojogos==null){
			filtrojogos="4" 
		}
		def usuarioBolaoInstance=UsuarioBolao.get(Long.valueOf(params.id).longValue())
		def configuracoes = configuracaoParams
		GregorianCalendar cinicial 	= new GregorianCalendar();
		GregorianCalendar cfinal 	= new GregorianCalendar();
		cfinal.setTime(new Date())
		cinicial.setTime(new Date())
		
		if(filtrojogos=="2"){
			cinicial.add(cinicial.DAY_OF_YEAR, -30)
		}
		if(filtrojogos=="3"){
			cinicial.add(cinicial.DAY_OF_YEAR,-20)
		}
		if(filtrojogos=="4"){
			cinicial.add(cinicial.DAY_OF_YEAR,-7)
		}
		
		def jogos = usuarioBolaoInstance.bolao.campeonato.jogos
		def palpitesfinalizados = []
		
		jogos.each(){
			def datajogo = it.datajogo
			def palpite = usuarioBolaoInstance.buscarPalpiteJogo(it , configuracaoParams.minutosparapalpite)
			if (palpite.finalizado==true){
				
				if (filtrojogos!="1"){
				    if(datajogo>=cinicial.getTime() && datajogo<=cfinal.getTime()){
						palpitesfinalizados << palpite
				    } 
				}else{
					palpitesfinalizados << palpite
				}
			}
		}
		
		respond palpitesfinalizados, model:[usuarioBolaoInstance:usuarioBolaoInstance, palpitesList: palpitesfinalizados, palpiteInstanceCount: palpitesfinalizados.size()]
	}

	def show(Palpite palpiteInstance) {
        respond palpiteInstance
    }

    def create() {
        respond new Palpite(params)
    }
	
	@Transactional
    def save() {
		
		def usuarioBolaoInstance= UsuarioBolao.get(Long.valueOf(params.usuariobolao).longValue())
		def finalizados		= params.list('palpitefinalizado')
		def idPalpites 		= params.list('id')
		def jogos 			= params.list('jogo')
		def scoretime1 		= params.list('scoretime1')
		def scoretime2 		= params.list('scoretime2')
		def configuracoes 	= configuracaoParams
		def erros = []
		def i = 0
		idPalpites.eachWithIndex{ it, index ->
			
			def idPalpite 			= it
			def jogo 				= Jogo.get(Long.valueOf(jogos[index]).longValue())
			def score1 				= scoretime1[index]
			def score2 				= scoretime2[index]
			def	finalizado  		= finalizados[index].toBoolean()
			
			def funcoesData 	= new FuncoesData()
			def finalizadoAtual = funcoesData.diferencaMinutos(jogo.datajogo , configuracoes.minutosparapalpite)
			
			if(finalizado != finalizadoAtual){
				erros[i] = message(code: 'palpite.encerrado.message', args: [jogo.time1.descricao, jogo.time2.descricao])
				i++
			}else{
			
					//Incluo ou atualizo palpite
					def palpiteInstance = PalpiteService.salvarPalpite(idPalpite ,jogo , score1 , score2 , finalizado , usuarioBolaoInstance)
					
					if(palpiteInstance!=null){
						if (palpiteInstance.hasErrors()) {
							respond palpiteInstance.errors, view:'index'
							return
						}
					}
			}
			
		}
		if(i==0){
			flash.message = message(code: 'palpite.updated.message')
		}else{
			flash.erros = erros
		}
		
		redirect action:"index" , params:[id:usuarioBolaoInstance.id]
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
