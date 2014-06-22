
<%@ page import="bolao.Estadio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'estadio.label', default: 'Estadio')}" />
		<title><g:message code="estadio.list.label"/></title>
	</head>
	<body>
		<a href="#show-estadio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="estadio.list.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="estadio.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="show-estadio" class="content scaffold-show" role="main">
			<h1><g:message code="estadio.list.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list estadio">
			
				<g:if test="${estadioInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="estadio.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${estadioInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${estadioInstance?.cidade}">
				<li class="fieldcontain">
					<span id="cidade-label" class="property-label"><g:message code="estadio.cidade.label" default="Cidade" /></span>
					
						<span class="property-value" aria-labelledby="cidade-label"><g:fieldValue bean="${estadioInstance}" field="cidade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${estadioInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label"><g:message code="estadio.estado.label" default="Estado" /></span>
					
						<span class="property-value" aria-labelledby="estado-label"><g:fieldValue bean="${estadioInstance}" field="estado"/></span>
					
				</li>
				</g:if>
			
							
				<g:if test="${estadioInstance?.pais}">
				<li class="fieldcontain">
					<span id="pais-label" class="property-label"><g:message code="estadio.pais.label" default="Pais" /></span>
					
						<span class="property-value" aria-labelledby="pais-label"><g:link controller="pais" action="show" id="${estadioInstance?.pais?.id}">${estadioInstance?.pais?.descricao}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:estadioInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${estadioInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
