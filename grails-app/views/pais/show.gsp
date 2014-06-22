<%@ page import="bolao.Pais" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pais.label', default: 'Pais')}" />
		<title><g:message code="pais.list.label"/></title>
	</head>
	<body>
		<a href="#show-pais" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="pais.list.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="pais.create.label"  /></g:link></li>
			</ul>
		</div>
		<div id="show-pais" class="content scaffold-show" role="main">
			<h1><g:message code="pais.list.label" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pais">
			
				<g:if test="${paisInstance?.codigo}">
				<li class="fieldcontain">
					<span id="codigo-label" class="property-label"><g:message code="pais.codigo.label" default="Codigo" /></span>
					
						<span class="property-value" aria-labelledby="codigo-label"><g:fieldValue bean="${paisInstance}" field="codigo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${paisInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="pais.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${paisInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${paisInstance?.imagem}">
				<li class="fieldcontain">
					<span id="imagem-label" class="property-label"><g:message code="pais.imagem.label" default="Imagem" /></span>
					
						<span class="property-value" aria-labelledby="imagem-label"><g:fieldValue bean="${paisInstance}" field="imagem"/></span>
					
				</li>
				</g:if>
			
				
			
			</ol>
			<g:form url="[resource:paisInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${paisInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
