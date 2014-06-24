
<%@ page import="bolao.Time" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'time.label', default: 'Time')}" />
		<title><g:message code="time.list.label"/></title>
	</head>
	<body>
		<a href="#list-time" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="time.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-time" class="content scaffold-list" role="main">
			<h1><g:message code="time.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="descricao" title="${message(code: 'time.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="imagem" title="${message(code: 'time.imagem.label', default: 'Imagem')}" />
					
					    <g:sortableColumn property="campeonato" title="${message(code: 'time.campeonato.label', default: 'Campeonato')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${timeInstanceList}" status="i" var="timeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${timeInstance.id}">${fieldValue(bean: timeInstance, field: "descricao")}</g:link></td>
					
						<td>
							<g:if test="${timeInstance.imagem}">
								<asset:image src="bandeiras/${params.tamanhoiconetimes}/${fieldValue(bean: timeInstance, field: "imagem")}" title="${fieldValue(bean: timeInstance, field: "descricao")}"/>
						
							</g:if>	
						</td>
						<td>${timeInstance?.campeonato?.descricao}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${timeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
