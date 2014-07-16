package funcoesdata
import bolao.Jogo
import bolao.UsuarioBolao;

import java.text.DateFormat
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Formatter.DateTime
import java.util.concurrent.TimeUnit

class FuncoesData {
	
	def hora(Jogo jogo){
	
		def calendariohoje = new GregorianCalendar()
		SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		SimpleDateFormat formatoData   = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		formatoString.setTimeZone(TimeZone.getTimeZone(jogo.timezone))
		def hojestr = formatoString.format(calendariohoje.getTime())
		def datahojedt  = formatoData.parse(hojestr)	
		
		return datahojedt
	}
	
	def boolean diferencaMinutos(Jogo jogo , def diferencaMinutos){
		
		def formatoString = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		def formatoData   = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		def calendariohoje = new GregorianCalendar()
		def calendariojogo = new GregorianCalendar()
		
		//Seto o Timezone do Jogo para os cálculos serem feitos baseado no timezone do jogo, inclusive a hora
		//do palpite deve estar no mesmo timezone do jogo, para não ter problemas de conversão
		formatoString.setTimeZone(TimeZone.getTimeZone(jogo.timezone))
		def hojestr = formatoString.format(calendariohoje.getTime())
		def datahoje= formatoData.parse(hojestr)
		calendariohoje.setTime(datahoje)
		calendariohoje.add((calendariohoje.MINUTE),-diferencaMinutos)
		
		calendariojogo.setTime(jogo.datajogo)
				
		def horaHoje    = calendariohoje.getTime()
		def horarioJogo = calendariojogo.getTime()
				
		if (horarioJogo > horaHoje) {
			return false
		}else{
			return true
		}
	}
}