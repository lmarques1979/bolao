<%@ page import="bolao.Palpite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'atualizapontos.label', default: 'Palpite')}" />
		<title><g:message code="atualizapontos.label"/></title>
	</head>
	<body>

		<div id="list-palpite" class="content scaffold-list" role="main">
			<h1><g:message code="palpite.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:if test="${flash.erros}">
			<ul class="errors" role="alert">
				<g:each in="${flash.erros}" status="i" var="erro">
					<li>${erro}</li>
				</g:each>
			</ul>
			</g:if>
		</div>
	</body>
</html>
