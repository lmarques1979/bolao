<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioBolao.label', default: 'UsuarioBolao')}" />
		<title><g:message code="usuarioBolao.list.label"/></title>
	</head>
	<body>

		<a href="#show-usuarioBolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<g:if test="${usuarioBolaoInstance?.bolao?.enabled==true}">
			<div class="palpites">
				<g:if test="${usuarioBolaoInstance?.id}">
					<g:link class="palpites" controller="Palpite" action="index" id="${usuarioBolaoInstance?.id}"><g:message code="palpite.label"/></g:link>
				</g:if>
			</div>
		</g:if>
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
				<asset:image src="skin/bolao_criacao.png" title="Data de Criação"/><span>${message(code: "datacriacao.label")}: <g:formatDate format="dd/MM/yyyy HH:mm" date="${usuarioBolaoInstance?.bolao?.dateCreated}"/></span><div class="clearer"></div>
				<asset:image src="skin/administrador.png" title="Administrador"/><span>${message(code: "administrador.label")}: ${usuarioBolaoInstance?.bolao?.admin?.username}</span><div class="clearer"></div>
				<asset:image src="skin/membros.png" title="Quantidade de Membros"/><span>${message(code: "membros.label")}: ${usuarioBolaoInstanceCount}</span><div class="clearer"></div>
			</div>
		
		</div>
		
		<div class="resenhas">
			<span>${message(code: "resenhas.label")}</span>
			<div class="enviarresenhas">
				<g:form controller="Resenha" action="save" method="POST">
					
					<g:textField class="resenha" id="resenha" name="resenha" size="60" maxlenght="100" value="${message(code: "digiteresenha.label")}"/>
					
					<input type='submit' value='${message(code: "button.create.label")}'/>
					
				</g:form>
			
			</div>
			<div class="lerresenhas"></div>
		</div>
		<div class=principaldetalhes>
			<span>${message(code: "detalhesdobolao.label.label")} ${usuarioBolaoInstance?.bolao?.descricao}</span>
			<div class="detalhesbolao">
				<table class="semborda">
					<thead>
						<tr>
						
							<th colspan="6" class="esquerda"><g:message code="palpite.pontuacaousuarios.label" default="Bolao" /></th>
						
						</tr>
						<tr>
						
							<th>#</th>
							<th>${message(code: "avatar.label")}</th>
							<th>${message(code: "participante.label")}</th>
							<th>${message(code: "timeparticipante.label")}</th>
							<th>${message(code: "pontos.label")}</th>
							<th>${message(code: "palpites.label")}</th>
						
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
										<g:if test="${usuariobolao[2]}">
											<g:if test="${usuariobolao[2].id==usuarioBolaoInstance?.id}">
												<g:link controller="Palpite" action="index" id="${usuariobolao[2].id}">
													<asset:image src="palpites.png" title="Ver Palpites"/>
												</g:link>
											</g:if>
											<g:else>
												<g:link controller="Palpite" action="palpiteusuario" id="${usuariobolao[2].id}">
													<asset:image src="palpites.png" title="${message(code: "verpalpites.label")}"/>
												</g:link>
											</g:else>
										</g:if>
										<g:else>
											${message(code: "naofezpalpite.label")}
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
<asset:javascript src="limparesenha.js"/>
