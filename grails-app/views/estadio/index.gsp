
<%@ page import="bolao.Estadio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'estadio.label', default: 'Estadio')}" />
		<title><g:message code="estadio.list.label"/></title>
	</head>
	<body>
		<a href="#list-estadio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="estadio.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-estadio" class="content scaffold-list" role="main">
			<h1><g:message code="estadio.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="descricao" title="${message(code: 'estadio.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="cidade" title="${message(code: 'estadio.cidade.label', default: 'Cidade')}" />
					
						<g:sortableColumn property="estado" title="${message(code: 'estadio.estado.label', default: 'Estado')}" />
					
						<th><g:message code="estadio.pais.label" default="Pais" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${estadioInstanceList}" status="i" var="estadioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${estadioInstance.id}">${fieldValue(bean: estadioInstance, field: "descricao")}</g:link></td>
					
						<td>${fieldValue(bean: estadioInstance, field: "cidade")}</td>
					
						<td>${fieldValue(bean: estadioInstance, field: "estado")}</td>
					
						<td>
							<g:if test="${estadioInstance?.pais?.imagem}">
								<asset:image src="bandeiras/${params.tamanhoiconetimes}/${estadioInstance?.pais?.imagem}" title="${estadioInstance?.pais?.descricao}"/>
							</g:if>
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${estadioInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
