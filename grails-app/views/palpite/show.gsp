
<%@ page import="bolao.Palpite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'palpite.label', default: 'Palpite')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-palpite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-palpite" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
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
			
				<g:if test="${palpiteInstance?.jogo}">
				<li class="fieldcontain">
					<span id="jogo-label" class="property-label"><g:message code="palpite.jogo.label" default="Jogo" /></span>
					
						<span class="property-value" aria-labelledby="jogo-label"><g:link controller="jogo" action="show" id="${palpiteInstance?.jogo?.id}">${palpiteInstance?.jogo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${palpiteInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="palpite.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${palpiteInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${palpiteInstance?.finalizado}">
				<li class="fieldcontain">
					<span id="finalizado-label" class="property-label"><g:message code="palpite.finalizado.label" default="Finalizado" /></span>
					
						<span class="property-value" aria-labelledby="finalizado-label"><g:formatBoolean boolean="${palpiteInstance?.finalizado}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${palpiteInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="palpite.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${palpiteInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${palpiteInstance?.usuariobolao}">
				<li class="fieldcontain">
					<span id="usuariobolao-label" class="property-label"><g:message code="palpite.usuariobolao.label" default="Usuariobolao" /></span>
					
						<span class="property-value" aria-labelledby="usuariobolao-label"><g:link controller="usuarioBolao" action="show" id="${palpiteInstance?.usuariobolao?.id}">${palpiteInstance?.usuariobolao?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:palpiteInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${palpiteInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
