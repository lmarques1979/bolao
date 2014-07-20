
<%@ page import="bolao.UsuarioBolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioBolao.label', default: 'UsuarioBolao')}" />
		<title><g:message code="usuarioBolao.list.label"/></title>
	</head>
	<body>
		<a href="#list-usuarioBolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-usuarioBolao" class="content scaffold-list" role="main">
			
			<div class="usuario">
				<div class="avatarimagem">
					<g:if test="${usuarioBolaoInstanceList[0].usuario.imagem}">
							<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="${usuarioBolaoInstanceList[0].usuario.imagem}" title="${usuarioBolaoInstanceList[0].usuario.username}"/>
					</g:if>
					<g:else>
						<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="noimage.jpg" title="${usuarioBolaoInstanceList[0].usuario.username}"/>
					</g:else>
				
				</div>
				<div class="nomeusuario">
					<span>${usuarioBolaoInstanceList[0].usuario.buscaNome(usuarioBolaoInstanceList[0].usuario)}</span>
				</div>
				
				<div class="dadosusuario">
					<asset:image src="skin/email.png" title="E-mail"/><span>E-mail: ${usuarioBolaoInstanceList[0].usuario.email}</span><div class="clearer"></div>
				</div>
			</div><div class="clearer"></div>
			<div class="boloesativos">
					<g:if test="${flash.message}">
						<div class="message" role="status">${flash.message}</div>
					</g:if>
					<table>
						<thead>
							<tr>
								<th colspan="4" class="esquerda"><g:message code="usuarioBolao.list.label" default="Bolao" /></th>
							</tr>
							<tr>
								<th><g:message code="usuarioBolao.bolao.label"/></th>
								<th><g:message code="usuarioBolao.campeonato.label"/></th>
								<th><g:message code="usuarioBolao.posicaoatual.label"/></th>
								<th><g:message code="usuarioBolao.status.label"/></th>
								
							</tr>
							
						</thead>
						<tbody>
						<g:each in="${usuarioBolaoInstanceList}" status="i" var="usuarioBolaoInstance">
							<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							
								<td>
									<g:if test="${usuarioBolaoInstance?.bolao?.imagem}">
											<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="bolao/${usuarioBolaoInstance?.bolao?.descricao}/${usuarioBolaoInstance?.bolao?.imagem}" title="${usuarioBolaoInstance?.bolao?.descricao}"/><br>
									</g:if>
									<g:link controller="UsuarioBolao" action="pontuacao" id="${usuarioBolaoInstance.id}">${fieldValue(bean: usuarioBolaoInstance?.bolao, field: "descricao")}</g:link>	
									
								</td> 
								<td>
									${usuarioBolaoInstance.bolao.campeonato.descricao}
								</td> 
								
								<td>
									${usuarioBolaoInstance.posicaoatual}º
								</td> 
								
								<td>
									<g:formatBoolean boolean="${usuarioBolaoInstance.bolao.enabled}" />
								</td> 
								
							</tr>
						</g:each>
						</tbody>
					</table>
					
			</div>
		</div>
	</body>
</html>
