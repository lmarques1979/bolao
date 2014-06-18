package bolao

import java.util.Date;
class Configuracao {

	int alturaimagens
	int larguraimagens
	int tamanhoiconetimes
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		alturaimagens(nullable: false, blank: false)
		larguraimagens(nullable: false, blank: false)
		tamanhoiconetimes(nullable: false, blank: false)
	}
	
	static mapping = {
		autoTimestamp true
	}
}
