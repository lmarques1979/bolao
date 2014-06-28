package pontuacao

class Pontuacao {

	//valores da pontuacao
	static pontosvencedor=25
	static pontosscorevencedor=18
	static diferencagols=15
	static scoretimeperdedor=12
	static acertotimevencedor=10
	static empatenaoexato=15
	static estimulado=4
	
	def int contaPontos(def score1jogo , def score2jogo , def score1palpite , def score2palpite , def peso){
		
		def pontuacao=0
		if(score1jogo!=null && score2jogo!=null && score1palpite!=null && score2palpite!=null){
			
				//Acertou vencedor
				if( (score1jogo>score2jogo && score1palpite>score2palpite) || (score1jogo<score2jogo && score1palpite<score2palpite) ){
				
						//Acerto placar exato
						if(score1jogo==score1palpite && score2jogo==score2palpite){
							pontuacao = (peso ? peso : 1)*pontosvencedor
						}else{
							//score do vencedor
							if( (score1jogo==score1palpite && score1jogo>score2jogo)  || (score2jogo==score2palpite && score1jogo<score2jogo)){
								pontuacao = (peso ? peso : 1)*pontosscorevencedor
							}else{
								//scoretimeperdedor
								if( (score1jogo>score2jogo && score2jogo==score2palpite) || (score1jogo<score2jogo && score1jogo==score1palpite)  ){
									pontuacao = (peso ? peso : 1)*scoretimeperdedor
								}else{
									 def diferencajogo
									 def diferencapalpite
									 if(score1jogo>score2jogo){
										diferencajogo 	= score1jogo - score2jogo
										diferencapalpite= score1palpite - score2palpite
									 }else{
									 	diferencajogo 	= score2jogo - score1jogo
										diferencapalpite= score2palpite - score1palpite
									}
									//diferenca Gols
									if(diferencajogo==diferencapalpite){
										pontuacao = (peso ? peso : 1)*diferencagols
									}else{
										//scoretimeperdedor
										if( (score1jogo>score2jogo && score1palpite>score2palpite && score2jogo==score2palpite) || (score1jogo<score2jogo && score1palpite<score2palpite && score1jogo==score1palpite)  ){
											  pontuacao = (peso ? peso : 1)*scoretimeperdedor
										}else{
										    //acertotimevencedor
										    if( (score1jogo > score2jogo && score1palpite > score2palpite) || (score1jogo < score2jogo && score1palpite < score2palpite) ){
											  pontuacao = (peso ? peso : 1)*acertotimevencedor
										    }
										}
									}
								}
							}
						}
			}else{
				//Empate
				if(score1palpite==score2palpite){
					//empateexato
					if(score1palpite==score1jogo && score2palpite==score2jogo){
						pontuacao = (peso ? peso : 1)*pontosvencedor
					}else{
						//empatenaoexato
						if(score1jogo!=score1palpite && score2jogo!=score2palpite && score1jogo==score2jogo && score1palpite==score2palpite){
							pontuacao = (peso ? peso : 1)*empatenaoexato
						}else{
						//estimulado
							if(score1jogo > score2jogo || score1jogo < score2jogo){
								pontuacao = (peso ? peso : 1)*estimulado
							}else{
								pontuacao=0
							}
						}
					}
				}
			}
				
		}
		
		return pontuacao
	}
}
