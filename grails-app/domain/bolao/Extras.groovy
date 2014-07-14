package bolao

import java.util.Date;

class Extras {

	String descricao
	int scoretime1=0
	int scoretime2=0
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [jogo:Jogo]
	
    static constraints = {
		scoretime1(nullable: true , blank: true)
		scoretime2(nullable: true , blank: true)
    }
	
	static mapping = {
		sort dateCreated: "asc" // or "asc"
		autoTimestamp true
		
	}
}
