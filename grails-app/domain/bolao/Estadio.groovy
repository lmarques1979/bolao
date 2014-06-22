package bolao

import java.util.Date;

class Estadio {

    String descricao
	String cidade
	String estado
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [pais:Pais]
	static transients = ['estadioCidadeEstado']
	
	static constraints = { 
		descricao(unique: true, nullable: false, blank: false , size: 0..50)
		cidade(nullable: false, blank: false , size: 0..50)
		estado(nullable: false, blank: false , size: 0..50)
	}
	
	static mapping = {
		sort descricao: "asc" // or "asc"
		autoTimestamp true
	}
	
	public String getestadioCidadeEstado() {
		
		def descricaolocal = descricao + '-' + cidade + '(' + estado + ')'
		
		return descricaolocal
	}
	
}
