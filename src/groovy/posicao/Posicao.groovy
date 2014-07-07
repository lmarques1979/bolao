package posicao

import bolao.UsuarioBolao
import org.hibernate.criterion.CriteriaSpecification

class Posicao {

	def atualizaPosicoes(usuariobolaoInstance){
		
		def posicao
		def resultado = UsuarioBolao.createCriteria().list() {
			createAlias("bolao", "b")
			eq('b.id', usuariobolaoInstance.bolao.id)
			eq('b.enabled', true)
			createAlias("palpites", "palpite", CriteriaSpecification.LEFT_JOIN)
			projections {
				groupProperty("usuario")
				sum "palpite.pontuacao", "pontos"
				max "palpite.usuariobolao"
			}
			order("pontos", "desc")
		}
		resultado.eachWithIndex(){ it , index ->
			
			def pontos = it[1]
			def ub = it[2]
			
			if(usuariobolaoInstance.id==ub.id){
				posicao = (index+1)
			}
		}
		return posicao
	}
}
