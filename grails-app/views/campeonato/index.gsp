
<%@ page import="bolao.Campeonato" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campeonato.label', default: 'Campeonato')}" />
		<title><g:message code="campeonato.list.label" /></title>
	</head>
	<body>
		<a href="#list-campeonato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-campeonato" class="content scaffold-list" role="main">
			<h1><g:message code="campeonato.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="descricao" title="${message(code: 'campeonato.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="imagem" title="${message(code: 'campeonato.imagem.label', default: 'Imagem')}" />
					
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${campeonatoInstanceList}" status="i" var="campeonatoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${campeonatoInstance.id}">${fieldValue(bean: campeonatoInstance, field: "descricao")}</g:link></td>
					
						<td>${fieldValue(bean: campeonatoInstance, field: "imagem")}</td>
					
						
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${campeonatoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
