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
			<g:form url="[resource:jogoInstance, action:'filtro']" >
			<thead>
					<tr>
						<th>Datas Jogos</th>
						<th>Campeonato</th>
						
					</tr>
					
				</thead>
				<tbody>
					<tr>
						<td>
							<g:if test="${session["filtrodata"]}"> 
								<g:set var="filtrodata" value="${session["filtrodata"]}" />
							</g:if>
							<g:else>
							     <g:set var="filtrodata" value="2" />
							</g:else>
														
							<g:select onchange="this.form.submit()" value="${filtrodata}" name="filtrodata" from="${['Todos', 'Pendentes', 'Finalizados']}" keys="${['1','2','3']}"/>
							
						</td>
						
						<td>
							<g:if test="${session["filtrocampeonato"]}"> 
								<g:set var="filtrocampeonato" value="${session["filtrocampeonato"]}" />
							</g:if>
							<g:else>
							     <g:set var="filtrocampeonato" value="-1" />
							</g:else>
							<g:select onchange="this.form.submit()" id="campeonato" name="filtrocampeonato" noSelection="${['-1':'Selecionar Campeonato...']}" from="${bolao.Campeonato.list()}" optionValue="descricao" optionKey="id" required="" value="${filtrocampeonato}" class="many-to-one"/>
						</td>
					</tr>
										
				</tbody>
				<g:submitButton class="invisivel" name="create" value="Filtrar" />
			</g:form> 
			</table>
			<table>
			
				<tbody>
				
				<g:set var="rodadaanterior" value="-1" />
				<g:each in="${jogoInstanceList}" status="i" var="jogoInstance">
				
					<g:set var="rodadaatual" value="${jogoInstance?.descricaofase}" />
					
					<g:if test="${rodadaanterior!=rodadaatual}">
						<thead>
							<tr>
								<th colspan="7">${jogoInstance?.descricaofase}</th>
							</tr>
							
							<tr>
					
								
								<th><g:message code="jogo.datajogo.label" default="Local" /></th>
								
								<th><g:message code="jogo.estadio.label" default="Local" /></th>
								
								<th><g:message code="jogo.time1.label" default="Time1" /></th>
								
								<th><g:message code="jogo.scoretime1.label" default="Score Time1" /></th>
								
								<th><g:message code="jogo.scoretime2.label" default="Score Time2" /></th>
							
								<th><g:message code="jogo.time2.label" default="Time2" /></th>
							
								<th><g:message code="jogo.campeonato.label" default="Campeonato" /></th>
						
							</tr>
						</thead>	
						
					</g:if>
					
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>
							<g:link action="show" id="${jogoInstance.id}">
								<g:formatDate format="dd/MM/yyyy HH:mm" date="${jogoInstance?.datajogo}"/>
							</g:link>
						</td>
					
						<td>${jogoInstance?.estadio?.descricao}</td>
						
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
							<!--<g:if test="${jogoInstance?.campeonato?.imagem}">
								<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="campeonatos/${jogoInstance?.campeonato?.descricao}/${jogoInstance?.campeonato?.imagem}" title="${jogoInstance?.campeonato?.descricao}"/>
							</g:if><br>-->
							${jogoInstance?.campeonato?.descricao}</td>
					
					
					</tr>
					
					<g:set var="rodadaanterior" value="${rodadaatual}" />

				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jogoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
