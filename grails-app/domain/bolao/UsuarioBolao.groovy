package bolao

import java.util.Date;

import seguranca.Usuario

import org.apache.commons.lang.builder.HashCodeBuilder

import funcoesdata.*

class UsuarioBolao implements Serializable {

	private static final long serialVersionUID = 1

	Usuario usuario
	Bolao bolao
	int	  posicaoatual
	boolean autorizado=true
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[palpites: Palpite , resenhas: Resenha]
	
	Palpite buscarPalpiteJogo(Jogo jogo , minutos) {

		def funcoesData = new FuncoesData()
		def finalizado = funcoesData.diferencaMinutos(jogo , minutos)
		
		for(Palpite palpite:palpites) {
				if(palpite.jogo == jogo) {
					palpite.finalizado=finalizado
					return palpite
				}
		}
		
		return new Palpite (jogo:jogo , finalizado:finalizado)
	}
	
	boolean equals(other) {
		if (!(other instanceof UsuarioBolao)) {
			return false
		}

		other.usuario?.id == usuario?.id &&
			other.bolao?.id == bolao?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (usuario) builder.append(usuario.id)
		if (bolao) builder.append(bolao.id)
		builder.toHashCode()
	}

	static UsuarioBolao get(long userId, long bolaoId) {
		UsuarioBolao.where {
			usuario == Usuario.load(userId) &&
			bolao == Bolao.load(bolaoId)
		}.get()
	}

	static UsuarioBolao create(Usuario usuario, Bolao bolao, boolean flush = false) {
		new UsuarioBolao(usuario: usuario, bolao: bolao).save(flush: flush, insert: true)
	}

	static boolean remove(Usuario u, Bolao b, boolean flush = false) {

		int rowCount = UsuarioBolao.where {
			usuario == Usuario.load(u.id) &&
			bolao == Bolao.load(b.id)
		}.deleteAll()

		rowCount > 0
	}

	static void removeAll(Usuario u) {
		UsuarioBolao.where {
			usuario == Usuario.load(u.id)
		}.deleteAll()
	}

	static void removeAll(Bolao b) {
		UsuarioBolao.where {
			bolao == Bolao.load(b.id)
		}.deleteAll()
	}

	static constraints = {
		usuario(unique: ['bolao'])
		autorizado(nullable: false , blank: false)
		posicaoatual(nullable: true , blank: true)
	}
	
	static mapping = {
		palpites cascade: 'all-delete-orphan'
		resenhas cascade: 'all-delete-orphan'
		version false
		autoTimestamp true
	}
}
