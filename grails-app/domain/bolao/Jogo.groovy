package bolao

import java.util.Date;

class Jogo {

	Time time1
	Time time2
	Date datajogo
	Date dateCreated
	Date lastUpdated

	static belongsTo = [campeonato:Campeonato]
	
	static constraints = {
		
		datajogo(nullable: false, blank: false)
		time1(nullable: false, blank: false)
		time2(nullable: false , blank: false)
	}
	
	static mapping = {
		autoTimestamp true
	}
}
