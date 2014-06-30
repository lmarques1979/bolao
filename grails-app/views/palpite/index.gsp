<%@ page import="bolao.Palpite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'palpite.label', default: 'Palpite')}" />
		<title><g:message code="palpite.list.label"/></title>
	</head>
	<body>

		<a href="#list-palpite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-palpite" class="content scaffold-list" role="main">
			<h1><g:message code="palpite.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:if test="${flash.erros}">
			<ul class="errors" role="alert">
				<g:each in="${flash.erros}" status="i" var="erro">
					<li>${erro}</li>
				</g:each>
			</ul>
			</g:if>
			<table>
			<g:form url="[resource:palpitesList, action:'index']" >
			<thead>
					<tr>
						<th>Status</th>
					</tr>
					
				</thead>
				<tbody>
					<tr>
						<td>
							<g:if test="${session["filtrodatapalpite"]}"> 
								<g:set var="filtrodatapalpite" value="${session["filtrodatapalpite"]}" />
							</g:if>
							<g:else>
							     <g:set var="filtrodatapalpite" value="2" />
							</g:else>
							<!--onchange="this.form.submit()"-->
							<g:select  value="${filtrodatapalpite}" name="filtrodatapalpite" from="${['Todos', 'Pendentes', 'Finalizados']}" keys="${['1','2','3']}"/>
							
						</td>
						
					</tr>
					
					
				</tbody>
				<g:submitButton class="invisivel" name="create" value="Filtrar" />
			</g:form> 
			</table>
			<g:form url="[action:'save',controller:'palpite']" method="POST">
			<g:hiddenField name="usuariobolao" value="${usuarioBolaoInstance.id}" />				
			<table>
				<thead>
					<tr>
						<th colspan="6">
							<fieldset class="buttons">
								<g:actionSubmit class="save" action="save" value="${message(code: 'button.create.label', default: 'Update')}" />
							</fieldset>
						</th>
					</tr>
				<thead>
				<tbody>
				<g:set var="rodadaanterior" value="-1" />
				<g:set var="datajogoanterior" value="-1" />
				<g:each in="${palpitesList}" status="i" var="palpite">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
	
							<g:set var="rodadaatual" value="${palpite?.jogo?.descricaofase}" />	
							<g:set var="datajogoatual" value="${palpite?.jogo?.datajogo?.format('dd/MM/yyyy')}" />
							
							<g:hiddenField name="jogo" value="${palpite?.jogo?.id}" />
							<g:hiddenField name="id" value="${palpite?.id ? palpite?.id : "-1"}" />
							<g:hiddenField name="palpitefinalizado" value="${palpite?.finalizado}" />
														
							<g:if test="${rodadaanterior!=rodadaatual}">
								<thead>
									<tr class="fase">
										<th colspan="6">${palpite?.jogo?.descricaofase}</th>
									</tr>
								</thead>	
						
							</g:if>
							
							<g:if test="${datajogoanterior!=datajogoatual}">
								<tbody>
									<tr class="datajogo">
										<td>Data do Jogo: ${datajogoatual}</td>
										<td colspan="4"></td>
										<td>Peso: ${palpite?.jogo?.peso}</td>
									</tr>
								</tbody>	
							</g:if>
							<td>
								<g:formatDate format="HH:mm" date="${palpite?.jogo?.datajogo}"/> | ${palpite?.jogo?.estadio?.descricao}
							</td>
						
							<td><g:if test="${palpite?.jogo?.time1?.imagem}">
									<asset:image src="bandeiras/${params.tamanhoiconetimes}/${palpite?.jogo?.time1?.imagem}" title="${palpite?.jogo?.time1?.descricao}"/>
								</g:if><br>
								
								${palpite?.jogo?.time1?.descricao}
							</td>
							
							<td>
								<g:if test="${palpite.finalizado}">
									<g:textField readonly class="readonly" name="scoretime1" maxlength="1" size="1" value="${palpite?.scoretime1}"/>
								</g:if>
								<g:else>
									<g:textField class="centro" name="scoretime1" maxlength="1" size="1" value="${palpite?.scoretime1}"/>
								</g:else>
							</td>
							
							<td>
								<g:if test="${palpite.finalizado}">
									<g:textField readonly class="readonly" name="scoretime2" maxlength="1" size="1" value="${palpite?.scoretime2}"/>
								</g:if>
								<g:else>
									<g:textField class="centro" name="scoretime2" maxlength="1" size="1" value="${palpite?.scoretime2}"/>
								</g:else>
							</td>
						
							<td>	
								<g:if test="${palpite?.jogo?.time2?.imagem}">
									<asset:image src="bandeiras/${params.tamanhoiconetimes}/${palpite?.jogo?.time2?.imagem}" title="${palpite?.jogo?.time2?.descricao}"/>
								</g:if><br>
								
								${palpite?.jogo?.time2?.descricao}</td>
						
							<td>
								<!--<g:if test="${jogoInstance?.campeonato?.imagem}">
									<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="campeonatos/${jogoInstance?.campeonato?.descricao}/${jogoInstance?.campeonato?.imagem}" title="${jogoInstance?.campeonato?.descricao}"/>
								</g:if><br>-->
								${palpite?.jogo?.campeonato?.descricao}
							</td>
							
						</tr>
						<tbody>
							<tr class="resultado">
								<td colspan="2">Resultado Final</td>
								<td>${palpite?.jogo?.scoretime1}</td>
								<td>${palpite?.jogo?.scoretime2}</td>
								<td>Pontos</td>
								<td>${palpite?.pontuacao}</td>
							</tr>
						</tbody>
						<g:set var="rodadaanterior" value="${rodadaatual}" />
						<g:set var="datajogoanterior" value="${datajogoatual}" />
				</g:each>
						
				<thead>
					<tr>
						<th colspan="6">
							<fieldset class="buttons">
								<g:actionSubmit class="save" action="save" value="${message(code: 'button.create.label', default: 'Update')}" />
							</fieldset>
						</th>
					</tr>
				<thead>
			</table>
			</g:form>
			<div class="pagination">
				<g:paginate total="${palpitesList ?: 0}" />
			</div>
		</div>
	</body>
</html>
