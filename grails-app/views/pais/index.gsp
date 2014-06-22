<%@ page import="bolao.Pais" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pais.label', default: 'Pais')}" />
		<title><g:message code="pais.list.label"/></title>
	</head>
	<body>
		<a href="#list-pais" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="pais.create.label" /></g:link></li>
			</ul>
		</div>
		<div id="list-pais" class="content scaffold-list" role="main">
			<h1><g:message code="pais.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="codigo" title="${message(code: 'pais.codigo.label', default: 'Codigo')}" />
					
						<g:sortableColumn property="descricao" title="${message(code: 'pais.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="imagem" title="${message(code: 'pais.imagem.label', default: 'Imagem')}" />
					
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${paisInstanceList}" status="i" var="paisInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${paisInstance.id}">${fieldValue(bean: paisInstance, field: "codigo")}</g:link></td>
					
						<td>${fieldValue(bean: paisInstance, field: "descricao")}</td>
					
						
							
						<td>
							<g:if test="${paisInstance?.imagem}">
								<asset:image src="bandeiras/${params.tamanhoiconetimes}/${paisInstance?.imagem}" title="${paisInstance?.descricao}"/>
							</g:if>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${paisInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
