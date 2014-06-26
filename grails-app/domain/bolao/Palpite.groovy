package bolao

import java.util.Date;
import seguranca.Usuario

class Palpite {

	Integer scoretime1
	Integer scoretime2
	Jogo jogo
	int	pontuacao
	boolean finalizado=false
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [usuariobolao:UsuarioBolao]
	
    static constraints = {
		
		scoretime1(nullable: true, blank: true , size: 1..3)
		scoretime2(nullable: true , blank: true , size: 1..3)
		jogo(nullable: false , blank: false)
		finalizado(nullable: true , blank: true)
		pontuacao(nullable: true , blank: true)
    }
	
	static mapping = {
		autoTimestamp true
	}
}
