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
			}
			order("pontos", "desc")
		}
		resultado.eachWithIndex(){ it , index ->
			
			def ub = UsuarioBolao.get(Long.valueOf(it[0]).longValue())
			ub.posicaoatual = (index + 1)
			
			ub.save flush:true
			
			if (ub.hasErrors()) {
				erros[i] = ub.errors
				i++
			}
		}
		return erros
	}
}
