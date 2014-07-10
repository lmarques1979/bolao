package posicao

import bolao.UsuarioBolao
import org.hibernate.criterion.CriteriaSpecification

class Posicao {

	def atualizaPosicoes(){ 
		
		def posicao
		def erros = []
		def i = 0
		
		def resultado = UsuarioBolao.createCriteria().list() {
			createAlias("bolao", "b")
			eq('b.enabled', true)
			createAlias("palpites", "palpite", CriteriaSpecification.LEFT_JOIN)
			projections {
				groupProperty("id")
				sum "palpite.pontuacao", "pontos"
				max "b.id" , "bolao"
			}
			order("bolao", "desc")
			order("pontos", "desc")
		}
		def cont=1
		def bolaoant
		def bolaoatual
		if(resultado.size()>0){
			bolaoant = resultado[0][2]
		}
		resultado.each(){ 
			
			bolaoatual = it[2]
			
			if(bolaoant!=bolaoatual){
				cont=1
			}
			
			def ub = UsuarioBolao.get(Long.valueOf(it[0]).longValue())
			ub.posicaoatual = cont
			
			ub.save flush:true
			
			if (ub.hasErrors()) {
				erros[i] = ub.errors
				i++
			}
			
			bolaoant = bolaoatual
			cont++
		}
		return erros
	}
}
