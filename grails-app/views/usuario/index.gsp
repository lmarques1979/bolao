<%@ page import="seguranca.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="usuario.list.label" /></title>
	</head>
	<body>
		<a href="#list-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="usuario.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-usuario" class="content scaffold-list" role="main">
			<h1><g:message code="usuario.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'usuario.username.label', default: 'Username')}" />
						<g:sortableColumn property="email" title="${message(code: 'usuario.email.label', default: 'Email')}" />
						<g:sortableColumn property="primeironome" title="${message(code: 'usuario.primeironome.label', default: 'Primeironome')}" />
					    <g:sortableColumn property="sobrenome" title="${message(code: 'usuario.sobrenome.label', default: 'Sobrenome')}" />
						<g:sortableColumn property="imagem" title="${message(code: 'usuario.imagem.label', default: 'Imagem')}" />
						<g:sortableColumn property="timecoracao" title="${message(code: 'usuario.timecoracao.label', default: 'Time de Coração')}" />
						<g:sortableColumn property="enabled" title="${message(code: 'usuario.enabled.label', default: 'Ativo')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${usuarioInstanceList}" status="i" var="usuarioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usuarioInstance.id}">${fieldValue(bean: usuarioInstance, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: usuarioInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: usuarioInstance, field: "primeironome")}</td>
					
						<td>${fieldValue(bean: usuarioInstance, field: "sobrenome")}</td>
					
						<td><g:if test="${usuarioInstance.imagem}">
								<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="usuarios/${usuarioInstance.username}/${usuarioInstance.imagem}" title="${usuarioInstance.username}"/>
							</g:if>	
							<g:else>
								<asset:image height="${params.alturaimagensthumbs}" width="${params.larguraimagensthumbs}" src="usuarios/noimage.jpg" title="${usuarioInstance.username}"/>
							</g:else>	
						</td>
						
						<td><g:if test="${usuarioInstance.timecoracao}">
								<asset:image src="bandeiras/24/${usuarioInstance.timecoracao.imagem}" title="${usuarioInstance.timecoracao.descricao}"/>
							</g:if>		
						</td>
						
						<td>
							<g:formatBoolean boolean="${usuarioInstance?.enabled}" />
						</td>
											
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usuarioInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
