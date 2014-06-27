package funcoesdata
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit
class FuncoesData {
	
	Locale locale = new Locale("pt","BR");
	
	def boolean diferencaMinutos(def datajogo , def diferencaMinutos){
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm",locale);
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