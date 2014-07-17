package upload

class UploadFile {
	
	def fileUpload(def f , def diretorio){
		
		def nomearquivo = f.getOriginalFilename()
		def imagem = diretorio  + File.separator + nomearquivo
		boolean deletou = new File(diretorio).deleteDir()
		def caminhoarquivo = new File(diretorio)
		caminhoarquivo.mkdirs()
		f.transferTo(new File(imagem))
		
		return nomearquivo
	}
}
