
<%@ page import="bolao.Extras" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'extras.label', default: 'Extras')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-extras" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-extras" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list extras">
			
				<g:if test="${extrasInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="extras.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${extrasInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${extrasInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="extras.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${extrasInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${extrasInstance?.jogo}">
				<li class="fieldcontain">
					<span id="jogo-label" class="property-label"><g:message code="extras.jogo.label" default="Jogo" /></span>
					
						<span class="property-value" aria-labelledby="jogo-label"><g:link controller="jogo" action="show" id="${extrasInstance?.jogo?.id}">${extrasInstance?.jogo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${extrasInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="extras.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${extrasInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${extrasInstance?.scoretime1}">
				<li class="fieldcontain">
					<span id="scoretime1-label" class="property-label"><g:message code="extras.scoretime1.label" default="Scoretime1" /></span>
					
						<span class="property-value" aria-labelledby="scoretime1-label"><g:fieldValue bean="${extrasInstance}" field="scoretime1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${extrasInstance?.scroretime2}">
				<li class="fieldcontain">
					<span id="scroretime2-label" class="property-label"><g:message code="extras.scroretime2.label" default="Scroretime2" /></span>
					
						<span class="property-value" aria-labelledby="scroretime2-label"><g:fieldValue bean="${extrasInstance}" field="scroretime2"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:extrasInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${extrasInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
