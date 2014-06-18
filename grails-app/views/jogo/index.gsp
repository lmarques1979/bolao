<%@ page import="bolao.Jogo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'jogo.label', default: 'Jogo')}" />
		<title><g:message code="jogo.list.label"/></title>
	</head>
	<body>
		<a href="#list-jogo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-jogo" class="content scaffold-list" role="main">
			<h1><g:message code="jogo.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="datajogo" title="${message(code: 'jogo.datajogo.label', default: 'Datajogo')}" />
					
						<th><g:message code="jogo.time1.label" default="Time1" /></th>
					
						<th><g:message code="jogo.time2.label" default="Time2" /></th>
					
						<th><g:message code="jogo.campeonato.label" default="Campeonato" /></th>
					
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${jogoInstanceList}" status="i" var="jogoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${jogoInstance.id}">${fieldValue(bean: jogoInstance, field: "datajogo")}</g:link></td>
					
						<td>${fieldValue(bean: jogoInstance, field: "time1")}</td>
					
						<td>${fieldValue(bean: jogoInstance, field: "time2")}</td>
					
						<td>${fieldValue(bean: jogoInstance, field: "campeonato")}</td>
					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jogoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
