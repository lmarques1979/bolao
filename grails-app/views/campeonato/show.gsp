
<%@ page import="bolao.Campeonato" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campeonato.label', default: 'Campeonato')}" />
		<title><g:message code="campeonato.list.label"/></title>
	</head>
	<body>
		<a href="#show-campeonato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="campeonato.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="show-campeonato" class="content scaffold-show" role="main">
			<h1><g:message code="campeonato.list.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list campeonato">
			
				<g:if test="${campeonatoInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="campeonato.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${campeonatoInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${campeonatoInstance?.imagem}">
				<li class="fieldcontain">
					<span id="imagem-label" class="property-label"><g:message code="campeonato.imagem.label" default="Imagem" /></span>
					
						<span class="property-value" aria-labelledby="imagem-label">
								<g:if test="${campeonatoInstance.imagem}">
									<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="${campeonatoInstance.imagem}" title="${campeonatoInstance.descricao}"/>
								</g:if>
						</span>
					
				</li>
				</g:if>
				
				<g:if test="${campeonatoInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="campeonato.enabled.label" default="Ativo" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${campeonatoInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
							
				<g:if test="${campeonatoInstance?.jogos}">
				<li class="fieldcontain">
					<span id="jogos-label" class="property-label"><g:message code="campeonato.jogos.label" default="Jogos" /></span>
					
						<g:each in="${campeonatoInstance.jogos}" var="j">
							<span class="property-value" aria-labelledby="jogos-label"><g:link class="nounderline" controller="jogo" action="show" id="${j.id}"><g:formatDate format="dd/MM/yyyy HH:mm" date="${j?.datajogo}" /> - <g:if test="${j?.time1?.imagem}">
								<asset:image class="jogocampeonato" src="bandeiras/24/${j?.time1?.imagem}" title="${j?.time1?.descricao}"/>
								</g:if> ${j?.time1.descricao} ${j?.scoretime1} x ${j?.scoretime2} ${j?.time2.descricao} 
								<g:if test="${j?.time2?.imagem}">
								<asset:image class="jogocampeonato" src="bandeiras/24/${j?.time2?.imagem}" title="${j?.time2?.descricao}"/>
							</g:if></g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				
			
			</ol>
			<g:form url="[resource:campeonatoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${campeonatoInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
