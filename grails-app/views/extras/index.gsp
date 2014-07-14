
<%@ page import="bolao.Extras" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'extras.label', default: 'Extras')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-extras" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-extras" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'extras.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="descricao" title="${message(code: 'extras.descricao.label', default: 'Descricao')}" />
					
						<th><g:message code="extras.jogo.label" default="Jogo" /></th>
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'extras.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="scoretime1" title="${message(code: 'extras.scoretime1.label', default: 'Scoretime1')}" />
					
						<g:sortableColumn property="scroretime2" title="${message(code: 'extras.scroretime2.label', default: 'Scroretime2')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${extrasInstanceList}" status="i" var="extrasInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${extrasInstance.id}">${fieldValue(bean: extrasInstance, field: "dateCreated")}</g:link></td>
					
						<td>${fieldValue(bean: extrasInstance, field: "descricao")}</td>
					
						<td>${fieldValue(bean: extrasInstance, field: "jogo")}</td>
					
						<td><g:formatDate date="${extrasInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: extrasInstance, field: "scoretime1")}</td>
					
						<td>${fieldValue(bean: extrasInstance, field: "scroretime2")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${extrasInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
