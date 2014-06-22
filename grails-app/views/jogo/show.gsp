
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
					
						<span class="property-value" aria-labelledby="datajogo-label"><g:formatDate format="dd/MM/yyyy HH:mm" date="${jogoInstance?.datajogo}" /></span>
					
				</li>
				</g:if>
				
				<g:if test="${jogoInstance?.estadio}">
				<li class="fieldcontain">
					<span id="estadio-label" class="property-label"><g:message code="jogo.estadio.label" default="Fase" /></span>
					
						<span class="property-value" aria-labelledby="estadio-label">${jogoInstance?.estadio?.descricao}</span>
					
				</li>
				</g:if>
				
				<g:if test="${jogoInstance?.fase}">
				<li class="fieldcontain">
					<span id="fase-label" class="property-label"><g:message code="jogo.fase.label" default="Fase" /></span>
					
						<span class="property-value" aria-labelledby="datajogo-label"><g:fieldValue bean="${jogoInstance}" field="fase"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${jogoInstance?.descricaofase}">
				<li class="fieldcontain">
					<span id="descricaofase-label" class="property-label"><g:message code="jogo.descricaofase.label" default="Descrição Fase" /></span>
					
						<span class="property-value" aria-labelledby="datajogo-label"><g:fieldValue bean="${jogoInstance}" field="descricaofase"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jogoInstance?.time1}">
				<li class="fieldcontain">
					<span id="time1-label" class="property-label"><g:message code="jogo.time1.label" default="Time1" /></span>
					
						<span class="property-value" aria-labelledby="time1-label"><g:link controller="time" action="show" id="${jogoInstance?.time1?.id}">${jogoInstance?.time1?.descricao}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${jogoInstance?.scoretime1}">
				<li class="fieldcontain">
					<span id="scoretime1-label" class="property-label"><g:message code="jogo.scoretime1.label" default="Scoretime1" /></span>
					
						<span class="property-value" aria-labelledby="scoretime1-label"><g:fieldValue bean="${jogoInstance}" field="scoretime1"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${jogoInstance?.scoretime2}">
				<li class="fieldcontain">
					<span id="scoretime2-label" class="property-label"><g:message code="jogo.scoretime2.label" default="Scoretime2" /></span>
					
						<span class="property-value" aria-labelledby="scoretime2-label"><g:fieldValue bean="${jogoInstance}" field="scoretime2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jogoInstance?.time2}">
				<li class="fieldcontain">
					<span id="time2-label" class="property-label"><g:message code="jogo.time2.label" default="Time2" /></span>
					
						<span class="property-value" aria-labelledby="time2-label"><g:link controller="time" action="show" id="${jogoInstance?.time2?.id}">${jogoInstance?.time2?.descricao}</g:link></span>
						
						
				</li>
				</g:if>
			
				<g:if test="${jogoInstance?.campeonato}">
				<li class="fieldcontain">
					<span id="campeonato-label" class="property-label"><g:message code="jogo.campeonato.label" default="Campeonato" /></span>
					
						<span class="property-value" aria-labelledby="campeonato-label"><g:link controller="campeonato" action="show" id="${jogoInstance?.campeonato?.id}">${jogoInstance?.campeonato?.descricao}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${jogoInstance?.encerrado}">
				<li class="fieldcontain">
					<span id="encerrado-label" class="property-label"><g:message code="jogo.encerrado.label" default="Campeonato" /></span>
					
						<span class="property-value" aria-labelledby="encerrado-label"><g:formatBoolean boolean="${jogoInstance?.encerrado}" /></span>
					
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
