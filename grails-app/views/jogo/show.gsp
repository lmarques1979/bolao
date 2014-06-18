
<%@ page import="bolao.Jogo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'jogo.label', default: 'Jogo')}" />
		<title><g:message code="jogo.list.label"/></title>
	</head>
	<body>
		<a href="#show-jogo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="jogo.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="show-jogo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list jogo">
			
				<g:if test="${jogoInstance?.datajogo}">
				<li class="fieldcontain">
					<span id="datajogo-label" class="property-label"><g:message code="jogo.datajogo.label" default="Datajogo" /></span>
					
						<span class="property-value" aria-labelledby="datajogo-label"><g:formatDate date="${jogoInstance?.datajogo}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${jogoInstance?.time1}">
				<li class="fieldcontain">
					<span id="time1-label" class="property-label"><g:message code="jogo.time1.label" default="Time1" /></span>
					
						<span class="property-value" aria-labelledby="time1-label"><g:link controller="time" action="show" id="${jogoInstance?.time1?.id}">${jogoInstance?.time1?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${jogoInstance?.time2}">
				<li class="fieldcontain">
					<span id="time2-label" class="property-label"><g:message code="jogo.time2.label" default="Time2" /></span>
					
						<span class="property-value" aria-labelledby="time2-label"><g:link controller="time" action="show" id="${jogoInstance?.time2?.id}">${jogoInstance?.time2?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${jogoInstance?.campeonato}">
				<li class="fieldcontain">
					<span id="campeonato-label" class="property-label"><g:message code="jogo.campeonato.label" default="Campeonato" /></span>
					
						<span class="property-value" aria-labelledby="campeonato-label"><g:link controller="campeonato" action="show" id="${jogoInstance?.campeonato?.id}">${jogoInstance?.campeonato?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
							
			</ol>
			<g:form url="[resource:jogoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${jogoInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
