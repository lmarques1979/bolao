package bolao

import java.util.Date;

class Time {

	String descricao
	String imagem
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [campeonato:Campeonato]
	
	static constraints = {
		descricao(nullable: false, blank: false , size: 0..50)
		imagem(nullable: true , blank: true , size: 0..50)
	}
	
	static mapping = {
		sort campeonato: "desc", descricao: "asc" // or "asc"
		autoTimestamp true
	}
}
