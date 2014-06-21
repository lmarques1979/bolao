
<%@ page import="bolao.Bolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bolao.label', default: 'Bolao')}" />
		<title><g:message code="bolao.show.label"/></title>
	</head>
	<body>
		<a href="#show-bolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="bolao.list.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="bolao.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="show-bolao" class="content scaffold-show" role="main">
			<h1><g:message code="bolao.list.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bolao">
			
				<g:if test="${bolaoInstance?.campeonato}">
				<li class="fieldcontain">
					<span id="campeonato-label" class="property-label"><g:message code="bolao.campeonato.label" default="Campeonato" /></span>
					
						<span class="property-value" aria-labelledby="campeonato-label"><g:link controller="campeonato" action="show" id="${bolaoInstance?.campeonato?.id}">${bolaoInstance?.campeonato?.descricao}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bolaoInstance?.admin}">
				<li class="fieldcontain">
					<span id="admin-label" class="property-label"><g:message code="bolao.admin.label" default="Admin" /></span>
					
						<span class="property-value" aria-labelledby="admin-label"><g:link controller="usuario" action="show" id="${bolaoInstance?.admin?.id}">${bolaoInstance?.admin?.username}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bolaoInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="bolao.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${bolaoInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bolaoInstance?.imagem}">
				<li class="fieldcontain">
					<span id="imagem-label" class="property-label"><g:message code="bolao.imagem.label" default="Imagem" /></span>
					
						<span class="property-value" aria-labelledby="imagem-label"><g:fieldValue bean="${bolaoInstance}" field="imagem"/></span>
					
				</li>
				</g:if>
			
			
			
			</ol>
			<g:form url="[resource:bolaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${bolaoInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
