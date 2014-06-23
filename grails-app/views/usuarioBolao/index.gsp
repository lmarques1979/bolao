
<%@ page import="bolao.UsuarioBolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioBolao.label', default: 'UsuarioBolao')}" />
		<title><g:message code="usuarioBolao.list.label"/></title>
	</head>
	<body>
		<a href="#list-usuarioBolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-usuarioBolao" class="content scaffold-list" role="main">
			<h1><g:message code="usuarioBolao.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="usuarioBolao.bolao.label" default="Bolao" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${usuarioBolaoInstanceList}" status="i" var="usuarioBolaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<g:if test="${sec.loggedInUserInfo(field: 'username') == usuarioBolaoInstance?.bolao?.admin?.username}">
							<td class="esquerda"><g:link action="show" id="${usuarioBolaoInstance.id}">${fieldValue(bean: usuarioBolaoInstance?.bolao, field: "descricao")}</g:link></td>
						</g:if>
						
						<g:else>
     						<td class="esquerda">${fieldValue(bean: usuarioBolaoInstance?.bolao, field: "descricao")}</td>
						</g:else>
										
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usuarioBolaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
