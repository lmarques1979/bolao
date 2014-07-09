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
				max "id"
			}
			order("pontos", "desc")
		}
		resultado.eachWithIndex(){ it , index ->
			
			def ubid = it[2]
			
			if(usuariobolaoInstance.id==ubid){
				posicao = (index+1)
			}
		}
		return posicao
	}
}
