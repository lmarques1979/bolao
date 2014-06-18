package bolao

import java.util.Date;
import seguranca.Usuario

class Bolao {

	String descricao
	String imagem
	Usuario	admin
	Date dateCreated
	Date lastUpdated
	Campeonato campeonato
	
	static constraints = {
		campeonato(nullable: false, blank: false)
		admin(nullable: false, blank: false)
		descricao(nullable: false, blank: false , size: 0..50)
		imagem(nullable: true , blank: true , size: 0..50)
	}
	
	static mapping = {
		sort descricao: "asc" // or "asc"
		autoTimestamp true
	}
}
