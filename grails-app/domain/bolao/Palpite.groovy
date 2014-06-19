package bolao

import java.util.Date;
import seguranca.Usuario

class Palpite {

	int scoretime1
	int scoretime2
	Usuario usuario
	Jogo jogo
	boolean finalizado=false
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
		
		scoretime1(nullable: false, blank: false , size: 1..3)
		scoretime2(nullable: false , blank: false , size: 1..3)
		usuario(nullable: false , blank: false)
		jogo(nullable: false , blank: false)
    }
	
	static mapping = {
		autoTimestamp true
	}
}
