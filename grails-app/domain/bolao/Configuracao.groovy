package bolao

import java.util.Date;
class Configuracao {

	int alturaimagens
	int larguraimagens
	int alturaimagensthumbs
	int larguraimagensthumbs	
	int tamanhoiconetimes
	int itensporpagina
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		alturaimagens(nullable: false, blank: false)
		larguraimagens(nullable: false, blank: false)
		alturaimagensthumbs(nullable: true, blank: true)
		larguraimagensthumbs(nullable: true, blank: true)
		tamanhoiconetimes(nullable: false, blank: false)
		itensporpagina(nullable: true, blank: true)
	}
	
	static mapping = {
		autoTimestamp true
	}
}
