package bolao

import java.util.Date;

class Jogo {

	Time time1
	Time time2
	Date datajogo
	int	scoretime1=0
	int scoretime2=0
	String local
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [campeonato:Campeonato]
	
	static constraints = {
		
		datajogo(nullable: false, blank: false)
		time1(nullable: false, blank: false)
		time2(nullable: false , blank: false)
		local(nullable: true , blank: true)
		scoretime1(nullable: true , blank: true , size: 1..3, matches:"[0-9]{1}[0-9]{1}[0-9]{1}")
		scoretime2(nullable: true , blank: true , size: 1..3, matches:"[0-9]{1}[0-9]{1}[0-9]{1}")
	}
	
	static mapping = {
		sort datajogo: "asc" // or "asc"
		autoTimestamp true
		
	}
}
