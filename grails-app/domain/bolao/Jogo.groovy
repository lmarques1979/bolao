package bolao

import java.util.Date;

class Jogo {

	Time time1
	Time time2
	Date datajogo
	int  fase
	int  peso=1
	String descricaofase
	int	scoretime1=0
	int scoretime2=0
	Estadio estadio
	boolean encerrado=false
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [campeonato:Campeonato]
	
	static constraints = {
		
		datajogo(nullable: false, blank: false)
		time1(nullable: false, blank: false)
		time2(nullable: false , blank: false)
		estadio(nullable: true , blank: true)
		encerrado(nullable: true , blank: true)
		fase(nullable: false , blank: false)
		peso(nullable: false , blank: false)
		descricaofase(nullable: false , blank: false)
		scoretime1(nullable: true , blank: true , size: 1..2, matches:"[0-9]{1}[0-9]{1}")
		scoretime2(nullable: true , blank: true , size: 1..2, matches:"[0-9]{1}[0-9]{1}")
	}
	
	static mapping = {
		sort fase:"asc" , campeonato: "asc", datajogo:"asc"
		autoTimestamp true
		
	}
}
