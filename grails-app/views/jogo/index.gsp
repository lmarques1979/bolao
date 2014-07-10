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
				<li><g:link class="create" action="create"><g:message code="jogo.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-jogo" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<g:form url="[resource:jogoInstance, action:'filtro']" >
			<thead>
					<tr>
						<th>${message(code: "filtro.statusjogo.label")}</th>
						<th>${message(code: "campeonato.label")}</th>
					</tr>
					
				</thead>
				<tbody>
					<tr>
						<td>
							<g:if test="${params.filtrodata}"> 
								<g:set var="filtrodata" value="${params.filtrodata}" />
							</g:if>
							<g:else>
							     <g:set var="filtrodata" value="2" />
							</g:else>
							
							<g:select onchange="this.form.submit()" value="${filtrodata}" name="filtrodata" from="${[message(code: "filtro.todos.label"), message(code: "filtro.pendente.label"), message(code: "filtro.encerrado.label")]}" keys="${['1','2','3']}"/>
							
						</td>
						
						<td>
							<g:if test="${params.filtrocampeonato}"> 
								<g:set var="filtrocampeonato" value="${params.filtrocampeonato}" />
							</g:if>
							<g:else>
							     <g:set var="filtrocampeonato" value="-1" />
							</g:else>
							
							<g:select onchange="this.form.submit()" id="campeonato" name="filtrocampeonato" noSelection="${['-1':message(code: "filtro.campeonato.label")]}" from="${bolao.Campeonato.list()}" optionValue="descricao" optionKey="id" required="" value="${filtrocampeonato}" class="many-to-one"/>
						</td>
						
					</tr>
					
					
				</tbody>
				<g:submitButton class="invisivel" name="create" value="Filtrar" />
			</g:form> 
			</table>
			<h1><g:message code="jogo.list.label"/></h1>
			<table>
			
				<tbody>
				
				<g:set var="rodadaanterior" value="-1" />
				<g:set var="datajogoanterior" value="-1" />
				<g:each in="${jogoInstanceList}" status="i" var="jogoInstance">
				
					<g:set var="rodadaatual" value="${jogoInstance?.descricaofase}" />
					<g:set var="datajogoatual" value="${jogoInstance?.datajogo?.format('dd/MM/yyyy')}" />
					<g:if test="${rodadaanterior!=rodadaatual}">
						<thead>
							<tr class="fase">
								<th colspan="7">${jogoInstance?.descricaofase}</th>
							</tr>
							
						</thead>	
						
					</g:if>
					<g:if test="${datajogoanterior!=datajogoatual}">
								<tbody>
									<tr class="datajogo">
										<td>${message(code: "jogo.datajogo.label")}: ${datajogoatual}</td>
										<td colspan="5"></td>
										<td>${message(code: "jogo.peso.label")}: ${jogoInstance?.peso}</td>
									</tr>
								</tbody>	
					</g:if>
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>
							<g:link action="show" id="${jogoInstance.id}">
								<g:formatDate format="HH:mm" date="${jogoInstance?.datajogo}"/> | ${jogoInstance?.estadio?.descricao}
							</g:link>
						</td>
					
						<td><g:if test="${jogoInstance?.time1?.imagem}">
								<asset:image src="bandeiras/${params.tamanhoiconetimes}/${jogoInstance?.time1?.imagem}" title="${jogoInstance?.time1?.descricao}"/>
							</g:if><br>
							
							${jogoInstance?.time1?.descricao}
						</td>
						
						<td>
							${jogoInstance?.scoretime1}
						</td>
						
						<td>
							x
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
					<g:set var="datajogoanterior" value="${datajogoatual}" />
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jogoInstanceCount ?: 0}" params="${params}" />
			</div>
		</div>
	</body>
</html>
