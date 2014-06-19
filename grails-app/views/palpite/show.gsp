
<%@ page import="bolao.Palpite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'palpite.label', default: 'Palpite')}" />
		<title><g:message code="palpite.list.label" /></title>
	</head>
	<body>
		<a href="#show-palpite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="palpite.list.label" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="palpite.create.label" /></g:link></li>
			</ul>
		</div>
		<div id="show-palpite" class="content scaffold-show" role="main">
			<h1><g:message code="palpite.list.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list palpite">
			
				<g:if test="${palpiteInstance?.scoretime1}">
				<li class="fieldcontain">
					<span id="scoretime1-label" class="property-label"><g:message code="palpite.scoretime1.label" default="Scoretime1" /></span>
					
						<span class="property-value" aria-labelledby="scoretime1-label"><g:fieldValue bean="${palpiteInstance}" field="scoretime1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${palpiteInstance?.scoretime2}">
				<li class="fieldcontain">
					<span id="scoretime2-label" class="property-label"><g:message code="palpite.scoretime2.label" default="Scoretime2" /></span>
					
						<span class="property-value" aria-labelledby="scoretime2-label"><g:fieldValue bean="${palpiteInstance}" field="scoretime2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${palpiteInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="palpite.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="usuario" action="show" id="${palpiteInstance?.usuario?.id}">${palpiteInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${palpiteInstance?.jogo}">
				<li class="fieldcontain">
					<span id="jogo-label" class="property-label"><g:message code="palpite.jogo.label" default="Jogo" /></span>
					
						<span class="property-value" aria-labelledby="jogo-label"><g:link controller="jogo" action="show" id="${palpiteInstance?.jogo?.id}">${palpiteInstance?.jogo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				
			
			</ol>
			<g:form url="[resource:palpiteInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${palpiteInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
