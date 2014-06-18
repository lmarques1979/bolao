package bolao

import java.util.Date;

class Campeonato {

	String descricao
	String imagem
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[jogos: Jogo]
	
	static constraints = {
		descricao(nullable: false, blank: false , size: 0..50)
		imagem(nullable: true , blank: true , size: 0..50)
	}
	
	static mapping = {
		sort descricao: "asc" // or "asc"
		autoTimestamp true
	}
}
