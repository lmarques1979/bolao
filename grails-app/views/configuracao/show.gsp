
<%@ page import="bolao.Configuracao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'configuracao.label', default: 'Configuracao')}" />
		<title><g:message code="configuracao.list.label" /></title>
	</head>
	<body>
		<a href="#show-configuracao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="show-configuracao" class="content scaffold-show" role="main">
			<h1><g:message code="configuracao.list.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list configuracao">
			
				<g:if test="${configuracaoInstance?.alturaimagens}">
				<li class="fieldcontain">
					<span id="alturaimagens-label" class="property-label"><g:message code="configuracao.alturaimagens.label" default="Altura Imagens" /></span>
					
						<span class="property-value" aria-labelledby="alturaimagens-label"><g:fieldValue bean="${configuracaoInstance}" field="alturaimagens"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${configuracaoInstance?.larguraimagens}">
				<li class="fieldcontain">
					<span id="larguraimagens-label" class="property-label"><g:message code="configuracao.larguraimagens.label" default="Largura Imagens" /></span>
					
						<span class="property-value" aria-labelledby="larguraimagens-label"><g:fieldValue bean="${configuracaoInstance}" field="larguraimagens"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${configuracaoInstance?.tamanhoiconetimes}">
				<li class="fieldcontain">
					<span id="tamanhoiconetimes-label" class="property-label"><g:message code="configuracao.tamanhoiconetimes.label" default="Tamanho Icone Times" /></span>
					
						<span class="property-value" aria-labelledby="tamanhoiconetimes-label"><g:fieldValue bean="${configuracaoInstance}" field="tamanhoiconetimes"/></span>
					
				</li>
				</g:if>
			
							
			</ol>
			<g:form url="[resource:configuracaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${configuracaoInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
