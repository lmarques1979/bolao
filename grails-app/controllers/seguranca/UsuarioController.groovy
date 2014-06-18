package seguranca

import static org.springframework.http.HttpStatus.*
import bolao.BaseController;
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class UsuarioController extends BaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	static final String pathusuario = "grails-app/assets/images/usuarios/";
	
	@Secured('permitAll')
	def esqueceusenha() {
		 
	}
	
	@Transactional
	@Secured('permitAll')
	def enviarsenha() {
		
		def valido=1
		def mensagem=""
		flash.message = []
		
		if(params.username==null || params.username==''){
			flash.message << "Usuário é obrigatório"
			valido = 0
		}
		
		if(params.email==null || params.email==''){
			flash.message << "E-mail é obrigatório"
			valido = 0
		}
		
		
		
		if (valido){
			
				def resultado = Usuario.findAllByUsernameAndEmail(params.username,params.email)
			
				resultado.each(){
					
					Random novasenha = new Random()
					
					def Usuario usuario = it
					String senha = Math.abs(novasenha.nextInt());
					usuario.password= senha					
					usuario.save flush:true
					
					if (usuario.hasErrors()) {
						flash.message << usuario.errors
						redirect(controller: "usuario", action: "esqueceusenha", params: params)
					}else{
					
						//Envio E-mail
						sendMail {
							to params.email
							subject "Nova Senha"
							html "Sua nova senha é: <b>" + senha + "</b>"
						}
						flash.message = message(code: "Nova senha enviada para o e-mail " + params.email)
	  			    }
			}
			if(resultado.size()==0){
				flash.message << "Usuário / E-mail não encontrado(s)"
				redirect(controller: "usuario", action: "esqueceusenha", params: params)
			}
		}else{
			redirect(controller: "usuario", action: "esqueceusenha", params: params)
		}
	}
	
	@Secured(["authentication.name == 'admin'"])
    def index(Integer max) {
		def configuracoes = configuracaoParams
        respond Usuario.list(paginacaoParams), model:[usuarioInstanceCount: Usuario.count()]
    }

	@Secured('permitAll') 
    def show(Usuario usuarioInstance) {
        respond usuarioInstance
    }

	@Secured('permitAll')
    def create() {
        respond new Usuario(params)
    }

    @Transactional
	@Secured('permitAll')
    def save(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }
		
		def f = request.getFile('arquivo')
		def usuario = params.username
		def diretorio = pathusuario + usuario 
		def imagem = pathusuario + usuario  + '/' + f.getOriginalFilename()
		usuarioInstance.imagem = f.getOriginalFilename()
		
		def caminhoarquivo = new File(diretorio)
		if( !caminhoarquivo.exists() ){
			caminhoarquivo.mkdirs()
		}
		f.transferTo(new File(imagem))

		usuarioInstance.save flush:true
		
		if (usuarioInstance.hasErrors()) {
			respond usuarioInstance.errors, view:'create'
			return
		}		
       
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*' { respond usuarioInstance, [status: CREATED] }
        }
    }

	@Secured('permitAll')
    def edit(Usuario usuarioInstance) {
        respond usuarioInstance
    }

    @Transactional
	@Secured('permitAll')
    def update(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        usuarioInstance.save flush:true
		
		if (usuarioInstance.hasErrors()) {
			respond usuarioInstance.errors, view:'edit'
			return
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*'{ respond usuarioInstance, [status: OK] }
        }
    }

    @Transactional
	@Secured('permitAll')
    def delete(Usuario usuarioInstance) {

        if (usuarioInstance == null) {
            notFound()
            return
        }

		def imagem = pathusuario + usuarioInstance.username  + '/' + usuarioInstance.imagem
		boolean existe =  new File(imagem).exists()
		
		if (existe){
			boolean deletou = new File(imagem).delete()
			if (deletou){
				usuarioInstance.delete flush:true
			}
		}else {
			usuarioInstance.delete flush:true
		}
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
				redirect(controller: "logout", action: "index")
            }
            '*'{ render status: NO_CONTENT }
        }
    }

	@Secured('permitAll')
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
