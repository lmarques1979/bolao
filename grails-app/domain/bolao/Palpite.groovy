package bolao

import java.util.Date;
import seguranca.Usuario

class Palpite {

	int scoretime1
	int scoretime2
	Jogo jogo
	boolean finalizado=false
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [usuariobolao:UsuarioBolao]
	
    static constraints = {
		
		scoretime1(nullable: false, blank: false , size: 1..3)
		scoretime2(nullable: false , blank: false , size: 1..3)
		jogo(nullable: false , blank: false)
    }
	
	static mapping = {
		autoTimestamp true
	}
}
