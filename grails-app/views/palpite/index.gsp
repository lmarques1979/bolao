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
			
				<tbody>
				<g:set var="rodadaanterior" value="-1" />
				
				<g:each in="${resultado}" status="i" var="usuarioBolao">
						<g:hiddenField name="usuariobolao" value="${usuarioBolao.id}" />
						
						<g:each in="${resultado.bolao.campeonato.jogos}" status="j" var="jogo">
							<g:each in="${jogo}" status="k" var="detalhejogo">
								<tr class="${(k % 2) == 0 ? 'even' : 'odd'}">
									
									<g:set var="rodadaatual" value="${detalhejogo?.descricaofase}" />	
									<g:hiddenField name="jogo[${k}]" value="${detalhejogo.id}" />
									
									
									<g:if test="${rodadaanterior!=rodadaatual}">
										<thead>
											<tr>
												<th colspan="7">${detalhejogo?.descricaofase}</th>
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
										<g:formatDate format="dd/MM/yyyy HH:mm" date="${detalhejogo?.datajogo}"/>
									</td>
								
									<td>${detalhejogo?.estadio?.descricao}</td>
									
									<td><g:if test="${detalhejogo?.time1?.imagem}">
											<asset:image src="bandeiras/${params.tamanhoiconetimes}/${detalhejogo?.time1?.imagem}" title="${detalhejogo?.time1?.descricao}"/>
										</g:if><br>
										
										${detalhejogo?.time1?.descricao}
									</td>
									
									<td>
										<g:textField name="scoretime1[${k}]" maxlength="1" size="1" value=""/>
									</td>
									
									<td>
										<g:textField name="scoretime2[${k}]" maxlength="1" size="1" value=""/>
									</td>
								
									<td>	
										<g:if test="${detalhejogo?.time2?.imagem}">
											<asset:image src="bandeiras/${params.tamanhoiconetimes}/${detalhejogo?.time2?.imagem}" title="${detalhejogo?.time2?.descricao}"/>
										</g:if><br>
										
										${detalhejogo?.time2?.descricao}</td>
								
									<td>
										<!--<g:if test="${jogoInstance?.campeonato?.imagem}">
											<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="campeonatos/${jogoInstance?.campeonato?.descricao}/${jogoInstance?.campeonato?.imagem}" title="${jogoInstance?.campeonato?.descricao}"/>
										</g:if><br>-->
										${detalhejogo?.campeonato?.descricao}
									</td>
									
								</tr>
								<g:set var="rodadaanterior" value="${rodadaatual}" />
								<g:set var="total" value="${k}" />
							</g:each>
						</g:each>
				</g:each>
				<g:hiddenField name="totaljogos" value="${total}" />
				<thead>
					<tr>
						<th colspan="7">
							<fieldset class="buttons">
								<g:actionSubmit class="direita save" action="save" value="${message(code: 'button.create.label', default: 'Update')}" />
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
