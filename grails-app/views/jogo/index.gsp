<%@ page import="bolao.Jogo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'jogo.label', default: 'Jogo')}" />
		<title><g:message code="jogo.list.label"/></title>
	</head>
	<body>
		<a href="#list-jogo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-jogo" class="content scaffold-list" role="main">
			<h1><g:message code="jogo.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="datajogo" title="${message(code: 'jogo.datajogo.label', default: 'Datajogo')}" />
					
						<th><g:message code="jogo.local.label" default="Local" /></th>
						
						<th><g:message code="jogo.time1.label" default="Time1" /></th>
						
						<th><g:message code="jogo.scroretime1.label" default="Score Time1" /></th>
						
						<th><g:message code="jogo.scroretime2.label" default="Score Time2" /></th>
					
						<th><g:message code="jogo.time2.label" default="Time2" /></th>
					
						<th><g:message code="jogo.campeonato.label" default="Campeonato" /></th>
					
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${jogoInstanceList}" status="i" var="jogoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>
							<g:link action="show" id="${jogoInstance.id}">
								<g:formatDate format="dd/MM/yyyy HH:mm" date="${jogoInstance?.datajogo}"/>
							</g:link>
						</td>
					
						<td>${fieldValue(bean: jogoInstance, field: "local")}</td>
						
						<td><g:if test="${jogoInstance?.time1?.imagem}">
								<asset:image src="bandeiras/${params.tamanhoiconetimes}/${jogoInstance?.time1?.imagem}" title="${jogoInstance?.time1?.descricao}"/>
							</g:if><br>
							
							${jogoInstance?.time1?.descricao}
						</td>
						
						<td>
							${jogoInstance?.scoretime1}
						</td>
						
						<td>
							${jogoInstance?.scoretime2}
						</td>
					
						<td>	
							<g:if test="${jogoInstance?.time2?.imagem}">
								<asset:image src="bandeiras/${params.tamanhoiconetimes}/${jogoInstance?.time2?.imagem}" title="${jogoInstance?.time2?.descricao}"/>
							</g:if><br>
							
							${jogoInstance?.time2?.descricao}</td>
					
						<td>
							<g:if test="${jogoInstance?.campeonato?.imagem}">
								<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="campeonatos/${jogoInstance?.campeonato?.descricao}/${jogoInstance?.campeonato?.imagem}" title="${jogoInstance?.campeonato?.descricao}"/>
							</g:if><br>
							${jogoInstance?.campeonato?.descricao}</td>
					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jogoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
