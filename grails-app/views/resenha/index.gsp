
<%@ page import="bolao.Resenha" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'resenha.label', default: 'Resenha')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-resenha" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-resenha" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="resenha" title="${message(code: 'resenha.resenha.label', default: 'Resenha')}" />
					
						<g:sortableColumn property="autorizacao" title="${message(code: 'resenha.autorizacao.label', default: 'Autorizacao')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'resenha.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'resenha.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="resenha.usuariobolao.label" default="Usuariobolao" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${resenhaInstanceList}" status="i" var="resenhaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${resenhaInstance.id}">${fieldValue(bean: resenhaInstance, field: "resenha")}</g:link></td>
					
						<td><g:formatBoolean boolean="${resenhaInstance.autorizacao}" /></td>
					
						<td><g:formatDate date="${resenhaInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${resenhaInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: resenhaInstance, field: "usuariobolao")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${resenhaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
