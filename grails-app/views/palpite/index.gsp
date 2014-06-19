
<%@ page import="bolao.Palpite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'palpite.label', default: 'Palpite')}" />
		<title><g:message code="palpite.list.label"/></title>
	</head>
	<body>
		<a href="#list-palpite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="palpite.create.label" /></g:link></li>
			</ul>
		</div>
		<div id="list-palpite" class="content scaffold-list" role="main">
			<h1><g:message code="palpite.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="scoretime1" title="${message(code: 'palpite.scoretime1.label', default: 'Scoretime1')}" />
					
						<g:sortableColumn property="scoretime2" title="${message(code: 'palpite.scoretime2.label', default: 'Scoretime2')}" />
					
						<th><g:message code="palpite.usuario.label" default="Usuario" /></th>
					
						<th><g:message code="palpite.jogo.label" default="Jogo" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'palpite.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'palpite.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${palpiteInstanceList}" status="i" var="palpiteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${palpiteInstance.id}">${fieldValue(bean: palpiteInstance, field: "scoretime1")}</g:link></td>
					
						<td>${fieldValue(bean: palpiteInstance, field: "scoretime2")}</td>
					
						<td>${fieldValue(bean: palpiteInstance, field: "usuario")}</td>
					
						<td>${fieldValue(bean: palpiteInstance, field: "jogo")}</td>
					
						<td><g:formatDate date="${palpiteInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${palpiteInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${palpiteInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
