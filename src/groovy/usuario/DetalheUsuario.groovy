package usuario

import bolao.Time
import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority 
import org.springframework.security.core.userdetails.User

class DetalheUsuario extends GrailsUser {

	final String primeironome, sobrenome , email, imagem
	final Time  timecoracao

	DetalheUsuario(	String username, 
					String password, 
					boolean enabled, 
					boolean accountNonExpired, 
					boolean credentialsNonExpired, 
					boolean accountNonLocked, 
					Collection<GrantedAuthority> authorities, 
					long id, 
					String primeironome,
					String sobrenome,
					String imagem,
					String email,
					Time   timecoracao) { 
					
						super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, id)

						this.primeironome 	= primeironome 
						this.sobrenome 		= sobrenome
						this.imagem			= imagem
						this.email 			= email
						this.timecoracao    = timecoracao
												 
					} 
}