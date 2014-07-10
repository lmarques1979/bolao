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
				<g:if test="${params.id}">
					<g:link class="palpites" controller="Palpite" action="index" id="${params.id}"><g:message code="palpite.label"/></g:link>
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
				<g:form action="salvaresenha" method="POST">
					<g:hiddenField name="idusuariobolao" value="${params.id}" />
					<g:textField class="resenha" id="resenha" name="resenha" size="60" maxlenght="100" value="${message(code: "digiteresenha.label")}"/>
					<g:actionSubmitImage action="salvaresenha" value="${message(code: "button.create.label")}" src="${assetPath(src:'skin/send.png')}" />
				</g:form>
			</div>
			<div class="lerresenhas">
				<table class="resenha">
						<g:each in="${resenhasList}" status="i" var="resenha">
							<tr>		
									<td>
										<asset:image height="35" width="35" src="usuarios/${resenha?.usuariobolao?.usuario?.username}/${resenha?.usuariobolao?.usuario?.imagem}" title="${resenha?.usuariobolao?.usuario?.buscaNome(resenha?.usuariobolao?.usuario)}"/>
									</td>
									
									<td class="font11centro"><g:formatDate format="dd/MM/yyyy HH:mm" date="${resenha?.dateCreated}" /></td>
									
									<td class="font11esquerda">${resenha?.resenha}</td>
									
									<td class="font11esquerda">
											<g:if test="${(resenha?.usuariobolao?.usuario?.id==sec.loggedInUserInfo(field: 'id').toLong() ) || (resenha?.usuariobolao?.bolao?.admin?.id==sec.loggedInUserInfo(field: 'id').toLong())}">
												<g:link onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" controller="resenha" action="delete" id="${resenha.id}">
													<asset:image src="skin/delete.png" title="${message(code: "delete.resenha.label")}"/>
												</g:link>
											</g:if>
									</td>
							</tr>
						</g:each>
				</table>
			
			</div>
			
		</div><div class="clearer"></div>
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
							<tr class="${(i%2) == 0 ? 'even' : 'odd'}">
									<td>${usuariobolao[3]}</td>
									
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
											<g:if test="${usuariobolao[2].id==Integer.parseInt(params.id)}">
												<g:link controller="Palpite" action="index" id="${params.id}">
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
