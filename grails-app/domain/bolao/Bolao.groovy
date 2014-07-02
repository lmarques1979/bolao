package bolao

import java.util.Date;
import seguranca.Usuario

class Bolao {

	String descricao
	String imagem
	String informacao
	Usuario	admin
	boolean autorizacao=true
	Date dateCreated
	Date lastUpdated
	Campeonato campeonato 
	
	static hasMany = [usuarioboloes: UsuarioBolao]
	
	static constraints = {
		
		campeonato(nullable: false, blank: false)
		admin(nullable: false, blank: false)
		descricao(nullable: false, blank: false , size: 0..50)
		imagem(nullable: true , blank: true , size: 0..50)
		informacao(nullable: true , blank: true)
		autorizacao(nullable: false , blank: false)
	}
	
	static mapping = {
		informacao type: 'text'
		usuarioboloes cascade: 'all-delete-orphan'
		sort descricao: "asc" // or "asc"
		autoTimestamp true
	}
}
