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
			<h1><g:message code="palpite.list.label"/> ${usuarioBolaoInstance.usuario.buscaNome(usuarioBolaoInstance.usuario)}</h1>
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
			<g:else>
					<table>
					<g:form id="formfiltropalpite" url="[action:'index',controller:'palpite']" method="POST">
					<g:hiddenField name="id" value="${usuarioBolaoInstance.id}" />
					<thead>
						<tr>
							<th><g:message code="palpite.filtro.label"/></th>
						</tr>
							
						</thead>
						<tbody>
							<tr>
								<td>
									<g:if test="${params.filtrodatapalpite}"> 
										<g:set var="filtrodatapalpite" value="${params.filtrodatapalpite}" />
									</g:if>
									<g:else>
									     <g:set var="filtrodatapalpite" value="2" />
									</g:else>
									
									<g:select id="filtropalpite" value="${filtrodatapalpite}" name="filtrodatapalpite" from="${[message(code: "filtro.todos.label"), message(code: "filtro.emaberto.label"), message(code: "filtro.finalizados.label")]}" keys="${['1','2','3']}"/>
									
								</td>
								
							</tr>
							
							
						</tbody>
					</g:form> 
					
					</table>
					<g:form url="[action:'save',controller:'palpite']" method="POST">
					<g:hiddenField name="usuariobolao" value="${usuarioBolaoInstance.id}" />				
					<table>
						
						<g:if test="${filtrodatapalpite!='3' && palpitesemAberto>0}"> 
							<thead>
								<tr class="semover">
									<th colspan="7">
											<g:actionSubmit id="botaopalpitesalvar" action="save" value="${message(code: 'button.create.label', default: 'Update')}" />
									</th>
								</tr>
							</thead>
						</g:if>
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
												<th colspan="7">${palpite?.jogo?.descricaofase}</th>
											</tr>
										</thead>	
								
									</g:if>
									
									<g:if test="${datajogoanterior!=datajogoatual}">
										<tbody>
											<tr class="datajogo">
												<td>${message(code: "datajogo.label")}: ${datajogoatual}</td>
												<td colspan="5"></td>
												<td>${message(code: "peso.label")}: ${palpite?.jogo?.peso}</td>
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
											<g:textField readonly class="readonly" name="scoretime1" maxlength="2" size="1" value="${palpite?.scoretime1}"/>
										</g:if>
										<g:else>
											<g:textField class="centro" name="scoretime1" maxlength="2" size="1" value="${palpite?.scoretime1}"/>
										</g:else>
									</td>
									
									<td>
										x
									</td>
									
									
									<td>
										<g:if test="${palpite.finalizado}">
											<g:textField readonly class="readonly" name="scoretime2" maxlength="2" size="1" value="${palpite?.scoretime2}"/>
										</g:if>
										<g:else>
											<g:textField class="centro" name="scoretime2" maxlength="2" size="1" value="${palpite?.scoretime2}"/>
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
									<g:each in="${palpite?.jogo?.extras}" status="k" var="extra">
										<g:if test="${k==0}">
												<tr class="datajogo">
													<td colspan="7">
														${message(code: "extras.label")}
													</td>
												</tr>
										</g:if>
										<tr>
											<td>${extra.descricao}</td>
											<td></td>
											<td>${extra.scoretime1}</td>
											<td> x </td>
											<td>${extra.scoretime2}</td>
										</tr>
										
									</g:each>
									<tr class="resultado">
										<td>${message(code: "resultadofinal.label")}</td>
										<td></td>
										<td>${palpite?.jogo?.scoretime1}</td>
										<td> x </td>
										<td>${palpite?.jogo?.scoretime2}</td>
										<td>${message(code: "pontos.label")}</td>
										<td>${palpite?.pontuacao}</td>
									</tr>
								</tbody>
								<g:set var="rodadaanterior" value="${rodadaatual}" />
								<g:set var="datajogoanterior" value="${datajogoatual}" />
						</g:each>
								
						<g:if test="${filtrodatapalpite!='3' && palpitesemAberto>0}"> 
							<thead>
								<tr class="semover">
									<th colspan="7">
											<g:actionSubmit id="botaopalpitesalvar" action="save" value="${message(code: 'button.create.label', default: 'Update')}" />
									</th>
								</tr>
							</thead>
						</g:if>
					</table>
					</g:form>
					<div class="pagination">
						<g:paginate total="${palpitesList ?: 0}" />
					</div>
					
					<asset:javascript src="filtrochange.js"/>
			</g:else>
			
		</div>
	</body>
</html>

