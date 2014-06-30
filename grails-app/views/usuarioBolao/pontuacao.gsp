
<%@ page import="bolao.UsuarioBolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioBolao.label', default: 'UsuarioBolao')}" />
		<title><g:message code="usuarioBolao.list.label"/></title>
	</head>
	<body>

		<a href="#show-usuarioBolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div class="palpites">
			<g:link class="palpites" controller="Palpite" action="index" id="${usuarioBolaoInstance?.id}"><g:message code="palpite.label"/></g:link>
			<g:if test="${usuarioBolaoInstance.usuario.imagem}">
				<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="usuarios/${usuarioBolaoInstance.usuario.username}/${usuarioBolaoInstance.usuario.imagem}" title="${usuarioBolaoInstance.usuario.username}"/>
			</g:if>
			<g:else>
				<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="usuarios/noimage.jpg" title="${usuarioBolaoInstance.usuario.username}"/>
			</g:else>
		</div>
		<div class="bolao">
				<span>${usuarioBolaoInstance?.bolao?.descricao}</span>
		</div>
		<div class="principal">
			
			<div class="avatar">
			
				<div class="avatarimagem">
					<g:if test="${usuarioBolaoInstance?.bolao?.imagem}">
						<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="bolao/${usuarioBolaoInstance?.bolao?.descricao}/${usuarioBolaoInstance?.bolao?.imagem}" title="${usuarioBolaoInstance?.bolao?.descricao}"/>
					</g:if>
				</div>
				
				<div class="informacao">
						<span>${usuarioBolaoInstance?.bolao?.informacao}</span>
				</div>
				
			</div>
						
			<div class="sobrebolao">
				<asset:image src="skin/bolao_criacao.png" title="Data de Criação"/><span>Data de Criação: <g:formatDate format="dd/MM/yyyy HH:mm" date="${usuarioBolaoInstance?.bolao?.dateCreated}"/></span><div class="clearer"></div>
				<asset:image src="skin/administrador.png" title="Administrador"/><span>Administrador: ${usuarioBolaoInstance?.bolao?.admin?.username}</span><div class="clearer"></div>
				<asset:image src="skin/membros.png" title="Quantidade de Membros"/><span>Membros: ${usuarioBolaoInstanceCount}</span><div class="clearer"></div>
			</div>
		
		</div>
		
		<div class=principaldetalhes>
			<span>Detalhes do bolão ${usuarioBolaoInstance?.bolao?.descricao}</span>
			<div class="detalhesbolao">
				<table>
					<thead>
						<tr>
						
							<th colspan="6" class="esquerda"><g:message code="palpite.pontuacaousuarios.label" default="Bolao" /></th>
						
						</tr>
						<tr>
						
							<th>#</th>
							<th>Avatar</th>
							<th>Participante</th>
							<th>Time Participante</th>
							<th>Pontos</th>
							<th>Palpites</th>
						
						</tr>
					</thead>
					<tbody>
						<g:each in="${usuariosBolao}" status="i" var="usuariobolao">
							<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
									<td>${i+1}</td>
									
									<td>
										<g:if test="${usuariobolao[0].imagem}">
											<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="usuarios/${usuariobolao[0].username}/${usuariobolao[0].imagem}" title="${usuariobolao[0].username}"/>
										</g:if>
										<g:else>
											<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="usuarios/noimage.jpg" title="${usuariobolao[0].username}"/>
										</g:else>
									</td>
									<td class="esquerda">
										<g:if test="${usuariobolao[0]?.primeironome}">
											    <g:set var="usuario" value="${usuariobolao[0]?.primeironome}" />
										</g:if>
										<g:if test="${usuariobolao[0]?.sobrenome}">
											    <g:set var="usuario" value="${usuario + ' ' + usuariobolao[0]?.sobrenome}" />
										</g:if>
										${usuario}</td>
									<td>
										<g:if test="${usuariobolao[0].timecoracao.imagem}">
											<asset:image src="bandeiras/24/${usuariobolao[0].timecoracao.imagem}" title="${usuariobolao[0].timecoracao.descricao}"/>
										</g:if>
									</td>
									<td>${usuariobolao[1] ? usuariobolao[1] : 0}</td>
									<td>
										<g:if test="${usuariobolao[2].id==usuarioBolaoInstance?.id}">
											<g:link controller="Palpite" action="index" id="${usuariobolao[2].id}">
												<asset:image src="palpites.png" title="Ver Palpites"/>
											</g:link>
										</g:if>
										<g:else>
											<g:link controller="Palpite" action="palpiteusuario" id="${usuariobolao[2].id}">
												<asset:image src="palpites.png" title="Ver Palpites"/>
											</g:link>
										</g:else>
									</td>
							</tr>
							
						</g:each>
					</tbody>
				</table>
			</div>
		
		</div>
		
		
	</body>
</html>
