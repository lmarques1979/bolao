package bolao

import java.util.Date;

class Pais {

	Long   id
    String codigo
	String descricao
	String imagem
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[estadios: Estadio]
	
	static constraints = {
		
		codigo(unique: true , nullable: false , blank: false, size: 2..2)
		descricao(nullable: false, blank: false , size: 0..50)
		imagem(nullable: true , blank: true , size: 0..50)
	}
	
	static mapping = {
		sort descricao: "asc" // or "asc"
		autoTimestamp true
	}
}
