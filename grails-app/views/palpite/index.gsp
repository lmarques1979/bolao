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
			<g:form url="[action:'save',controller:'palpite']" method="POST" >
							
			<table>
				<thead>
					<tr>
						<th colspan="7">
							<fieldset class="buttons">
								<g:actionSubmit class="save" action="save" value="${message(code: 'button.create.label', default: 'Update')}" />
							</fieldset>
						</th>
					</tr>
				<thead>
				<tbody>
				<g:set var="rodadaanterior" value="-1" />
				<g:each in="${palpitesList}" status="i" var="palpite">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							
							<g:set var="rodadaatual" value="${palpite?.jogo?.descricaofase}" />	
							<g:hiddenField name="jogo" value="${palpite?.jogo?.id}" />
							<g:hiddenField name="id" value="${palpite?.id ? palpite?.id : "-1"}" />
														
							<g:if test="${rodadaanterior!=rodadaatual}">
								<thead>
									<tr>
										<th colspan="7">${palpite?.jogo?.descricaofase}</th>
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
							<td>
								<g:formatDate format="dd/MM/yyyy HH:mm" date="${palpite?.jogo?.datajogo}"/>
							</td>
						
							<td>${palpite?.jogo?.estadio?.descricao}</td>
							
							<td><g:if test="${palpite?.jogo?.time1?.imagem}">
									<asset:image src="bandeiras/${params.tamanhoiconetimes}/${palpite?.jogo?.time1?.imagem}" title="${palpite?.jogo?.time1?.descricao}"/>
								</g:if><br>
								
								${palpite?.jogo?.time1?.descricao}
							</td>
							
							<td>
								<g:textField class="centro" name="scoretime1" maxlength="1" size="1" value="${palpite?.scoretime1}"/>
							</td>
							
							<td>
								<g:textField class="centro" name="scoretime2" maxlength="1" size="1" value="${palpite?.scoretime2}"/>
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
								<td colspan="3">Resultado Final</td>
								<td>${palpite?.jogo?.scoretime1}</td>
								<td>${palpite?.jogo?.scoretime2}</td>
								<td colspan="2">Pontos</td>
							</tr>
						</tbody>
						<g:set var="rodadaanterior" value="${rodadaatual}" />
				</g:each>
						
				<thead>
					<tr>
						<th colspan="7">
							<fieldset class="buttons">
								<g:actionSubmit class="save" action="save" value="${message(code: 'button.create.label', default: 'Update')}" />
							</fieldset>
						</th>
					</tr>
				<thead>
			</table>
			</g:form>
			<div class="pagination">
				<g:paginate total="${usuarioBolaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
