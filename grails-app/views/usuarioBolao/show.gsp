
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
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="usuarioBolao.list.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="usuarioBolao.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="show-usuarioBolao" class="content scaffold-show" role="main">
			<h1><g:message code="usuarioBolao.list.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuarioBolao">
			
				<g:if test="${usuarioBolaoInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="usuarioBolao.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="usuario" action="show" id="${usuarioBolaoInstance?.usuario?.id}">${usuarioBolaoInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioBolaoInstance?.bolao}">
				<li class="fieldcontain">
					<span id="bolao-label" class="property-label"><g:message code="usuarioBolao.bolao.label" default="Bolao" /></span>
					
						<span class="property-value" aria-labelledby="bolao-label"><g:link controller="bolao" action="show" id="${usuarioBolaoInstance?.bolao?.id}">${usuarioBolaoInstance?.bolao?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:usuarioBolaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${usuarioBolaoInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
