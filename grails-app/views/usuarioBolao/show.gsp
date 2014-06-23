
<%@ page import="bolao.UsuarioBolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioBolao.label', default: 'UsuarioBolao')}" />
		<title><g:message code="usuarioBolao.list.label"/></title>
	</head>
	<body>
		<a href="#show-usuarioBolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="show-usuarioBolao" class="content scaffold-show" role="main">
			<h1><g:message code="usuarioBolao.list.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuarioBolao">
			
				<g:if test="${usuarioBolaoInstance?.bolao}">
				<li class="fieldcontain">
					<span id="bolao-label" class="property-label"><g:message code="usuarioBolao.bolao.label" default="Bolao" /></span>
					
						<span class="property-value" aria-labelledby="bolao-label">${usuarioBolaoInstance?.bolao?.descricao}</span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:usuarioBolaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
