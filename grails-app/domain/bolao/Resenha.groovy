package bolao

import java.util.Date;
import seguranca.Usuario

class Resenha {

	String resenha
	boolean autorizacao=true
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [usuariobolao: UsuarioBolao]
	
	static constraints = {
		resenha(nullable: true, blank: true)
		autorizacao(nullable: true , blank: true) 
	}
	
	static mapping = {
		resenha type: 'text'
		sort dateCreated: "desc" // or "asc"
		autoTimestamp true
	}
}
