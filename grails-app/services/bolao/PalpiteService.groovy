package bolao

import grails.transaction.Transactional

@Transactional
class PalpiteService {
	
    Palpite salvarPalpite(idpalpite , jogo, scoretime1, scoretime2 , finalizado , usuariobolao) {
		
		def palpiteInstance
		
		if(scoretime1!="" && scoretime2!=""){
			
			if(idpalpite=="-1"){
				//Não existe Insiro
				palpiteInstance = new Palpite()
				palpiteInstance.scoretime1 		= Long.valueOf(scoretime1).longValue()
				palpiteInstance.scoretime2 		= Long.valueOf(scoretime2).longValue()
				palpiteInstance.jogo			= jogo
				palpiteInstance.usuariobolao 	= usuariobolao
				palpiteInstance.finalizado		= finalizado
				
				palpiteInstance.save flush:true
				
			}else{
				//Existe, apenas atualizo os scores
				palpiteInstance = Palpite.get(idpalpite)
				palpiteInstance.scoretime1 		= Long.valueOf(scoretime1).longValue()
				palpiteInstance.scoretime2 		= Long.valueOf(scoretime2).longValue()
				palpiteInstance.finalizado		= finalizado
				
				palpiteInstance.save flush:true
			}
			
		}
		
		return 	palpiteInstance
		
    }
			
}
