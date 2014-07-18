package upload

import com.amazonaws.services.s3.model.*


class UploadFile {
	
	def baseurl = "https://s3-sa-east-1.amazonaws.com/"
	def bucket  = "bolaovipcampeao/"
	def amazonWebService
	
	def fileUpload(def f){ 
		
		def nomearquivo = (new Date()).getTime() + "_" + f.getOriginalFilename()
		//File file = StreamUtil.stream2file(nomearquivo, f.getInputStream())
		//amazonWebService.s3.putObject(new PutObjectRequest(bucket, nomearquivo, file).withCannedAcl(CannedAccessControlList.PublicRead))
		
		return nomearquivo
	}
	
	def fileDelete(def nomearquivo){
		
		if (nomearquivo!=null){
			amazonWebService.s3.deleteObject(bucket,nomearquivo)
		}
	}
}
