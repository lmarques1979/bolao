package bolao

import java.util.Date;
import seguranca.Usuario

class Palpite {

	Integer scoretime1
	Integer scoretime2
	Jogo jogo
	int	pontuacao
	boolean finalizado=false
	Date ultimaatualizacao
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [usuariobolao:UsuarioBolao]
	
	static void removeAll(listaPalpite , filtro) {
		if(filtro==2){
			listaPalpite.where {
				finalizado == true
			}.deleteAll()
		}
		if(filtro==3){
			listaPalpite.where {
				finalizado == false
			}.deleteAll()
		}
	}
	
    static constraints = {
		scoretime1(nullable: true, blank: true , size: 1..2 , matches:"[0-9]{1}[0-9]{1}")
		scoretime2(nullable: true , blank: true , size: 1..2, matches:"[0-9]{1}[0-9]{1}")
		jogo(nullable: false , blank: false)
		finalizado(nullable: true , blank: true)
		pontuacao(nullable: true , blank: true)
		ultimaatualizacao(nullable: true , blank: true)
    }
	
	static mapping = {
		sort jogo:"asc"
		autoTimestamp true
	}
}
