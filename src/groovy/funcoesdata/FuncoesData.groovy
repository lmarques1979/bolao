package funcoesdata
import java.text.DateFormat
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Formatter.DateTime
import java.util.concurrent.TimeUnit

class FuncoesData {
	
	def horaBR(){
		
		TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo")
		TimeZone.setDefault(tz) 
		Calendar calendar = GregorianCalendar.getInstance(tz)
		calendar.setTime(new Date())
		
		return calendar.getTime()
	}
	
	def boolean diferencaMinutos(def datajogo , def diferencaMinutos){
		
		GregorianCalendar calendariohoje = new GregorianCalendar();
		GregorianCalendar calendariojogo = new GregorianCalendar();
		Date hoje = new Date()
		calendariohoje.setTime(hoje)
		calendariohoje.add((calendariohoje.MINUTE), -diferencaMinutos)
		def horaHoje = calendariohoje.getTime()
		calendariojogo.setTime(datajogo)
		def horarioJogo = calendariojogo.getTime()
				
		if (horarioJogo > horaHoje) {
			return false
		}else{
			return true
		}
	}
}