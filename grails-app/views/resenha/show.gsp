
<%@ page import="bolao.Resenha" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'resenha.label', default: 'Resenha')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-resenha" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-resenha" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list resenha">
			
				<g:if test="${resenhaInstance?.resenha}">
				<li class="fieldcontain">
					<span id="resenha-label" class="property-label"><g:message code="resenha.resenha.label" default="Resenha" /></span>
					
						<span class="property-value" aria-labelledby="resenha-label"><g:fieldValue bean="${resenhaInstance}" field="resenha"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${resenhaInstance?.autorizacao}">
				<li class="fieldcontain">
					<span id="autorizacao-label" class="property-label"><g:message code="resenha.autorizacao.label" default="Autorizacao" /></span>
					
						<span class="property-value" aria-labelledby="autorizacao-label"><g:formatBoolean boolean="${resenhaInstance?.autorizacao}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${resenhaInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="resenha.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${resenhaInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${resenhaInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="resenha.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${resenhaInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${resenhaInstance?.usuariobolao}">
				<li class="fieldcontain">
					<span id="usuariobolao-label" class="property-label"><g:message code="resenha.usuariobolao.label" default="Usuariobolao" /></span>
					
						<span class="property-value" aria-labelledby="usuariobolao-label"><g:link controller="usuarioBolao" action="show" id="${resenhaInstance?.usuariobolao?.id}">${resenhaInstance?.usuariobolao?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:resenhaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${resenhaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
