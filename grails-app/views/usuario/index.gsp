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
						<g:sortableColumn property="accountExpired" title="${message(code: 'usuario.accountExpired.label', default: 'Account Expired')}" />
						<g:sortableColumn property="imagem" title="${message(code: 'usuario.imagem.label', default: 'Imagem')}" />
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${usuarioInstanceList}" status="i" var="usuarioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usuarioInstance.id}">${fieldValue(bean: usuarioInstance, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: usuarioInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: usuarioInstance, field: "primeironome")}</td>
					
						<td>${fieldValue(bean: usuarioInstance, field: "sobrenome")}</td>
					
						<td><g:formatBoolean boolean="${usuarioInstance.accountExpired}" /></td>
						
						<td><g:if test="${usuarioInstance.imagem}">
								<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="usuarios/${usuarioInstance.username}/${usuarioInstance.imagem}" title="${usuarioInstance.username}"/>
							</g:if>		
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
