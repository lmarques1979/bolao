package seguranca

import bolao.Time
import bolao.UsuarioBolao
import bolao.Palpite

class Usuario {

	transient springSecurityService

	String username
	String password
	String email
	String primeironome
	String sobrenome
	String  imagem
	Time    timecoracao=null
	boolean enabled=true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static hasMany = [usuarioboloes: UsuarioBolao, usuarioregras: UsuarioRegra]
	
	static transients = ['springSecurityService']

	static constraints = {
		username(unique:true , blank: false, nullable:false)
		password(blank: false , nullable:false)
		email(email:true,blank:false,nullable:false)
		primeironome(blank: false , nullable:false)
		sobrenome(blank: true , nullable:true)
		timecoracao(blank: true , nullable:true)
		imagem(blank: true , nullable:true)
	}
	
	static mapping = {
		usuarioregras cascade: 'all-delete-orphan'
		usuarioboloes cascade: 'all-delete-orphan'
		password column: '`password`'
	}

	def buscaNome(Usuario usuario){
		
		def nomecompleto=usuario.primeironome
		if(usuario.sobrenome!=null){
			nomecompleto = nomecompleto + ' ' + usuario.sobrenome
		}
		return nomecompleto
	}
	
	Set<Regra> getAuthorities() {
		UsuarioRegra.findAllByUsuario(this).collect { it.regra } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
