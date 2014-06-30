package bolao

import java.util.Date;

class Campeonato {

	String descricao
	String imagem
	boolean enabled=true
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[jogos: Jogo, times: Time]
	
	static constraints = {
		descricao(nullable: false, blank: false , size: 0..50)
		imagem(nullable: true , blank: true , size: 0..50)
		enabled(nullable: true , blank: true)
	}
	
	static mapping = {
		jogos cascade: 'all-delete-orphan'
		times cascade: 'all-delete-orphan'
		sort descricao: "asc"
		jogos sort: 'datajogo', order: 'asc'
		autoTimestamp true
	}
}
