<%@ page import="bolao.Jogo" %>

<table>
			<tbody>
					<thead>
						<tr>
							<th colspan="7">${message(code: "jogo.timezone.label")} *</th>
						</tr>
					</thead>
					<tr>
						<td>
							<g:timeZoneSelect class="timezone" name="timezone" value="${tz}" />
						</td>
					</tr>
					<thead>
						<tr>
							<th>${message(code: "jogo.datajogo.label")} *</th>
							<th>${message(code: "jogo.horajogo.label")} *</th>
							<th>${message(code: "jogo.peso.label")} *</th>
							<th>${message(code: "jogo.rodada.label")} *</th>
							<th colspan="3">${message(code: "jogo.descfase.label")} *</th>
						</tr>
					</thead>
					<tr>
						<td>
							<g:textField name="datajogo" class="w8em format-d-m-y" size="9" value="${params.datajogo}"  />
							
						</td>
						<td>
							<g:textField name="horajogo" size="3" id="hora" class="time" value="${params.horajogo}" />
							
						</td>
						
						<td>
							<g:textField name="peso" size="2" value="${jogoInstance?.peso}"/>
							
						</td>
						
						<td>
							<g:textField name="fase" size="1" value="${jogoInstance?.fase}"/>
							
						</td>
						
						<td colspan="3">
							<g:textField name="descricaofase" size="8" value="${jogoInstance?.descricaofase}"/>
						</td> 
					</tr>
					<thead>
						<tr>
							<th>${message(code: "jogo.estadio.label")}</th>
							<th>${message(code: "jogo.time1.label")} *</th>
							<th>${message(code: "jogo.scoretime1.label")}</th>
							<th>${message(code: "jogo.scoretime2.label")}</th>
							<th>${message(code: "jogo.time2.label")} *</th>
							<th colspan="2">${message(code: "extras.label")}</th>
						</tr>
					</thead>
					<tr>
						<td>
							
							<g:select id="estadio" name="estadio.id" from="${bolao.Estadio.list()}" optionValue="estadioCidadeEstado" optionKey="id" required="" value="${jogoInstance?.estadio?.id}" class="many-to-one"/>
							
						</td>
						<td>
							<g:select id="time1" name="time1.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time1?.id}" class="many-to-one"/>
							
						</td>
						
						<td>
							<g:textField class="centro" name="scoretime1" maxlength="1" size="1" value="${jogoInstance?.scoretime1}"/>
						</td>
						
						<td>
							<g:textField class="centro" name="scoretime2" maxlength="1" size="1" value="${jogoInstance?.scoretime2}"/>
						</td>
						
						<td>
							<g:select id="time2" name="time2.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time2?.id}" class="many-to-one"/>
							
						</td>
						
						<td colspan="2">
							<g:link controller="extras" action="create" id="${jogoInstance.id}">
								<asset:image src="skin/add.png" title="${ message(code: 'adicionarextra.label')}"/>
							</g:link>
						</td>
					</tr>
					<thead>
						<tr>
							<th>${message(code: "jogo.campeonato.label")}</th>
							<th>${message(code: "jogo.encerrado.label")}</th>
						</tr>
					</thead>
					<tr>
						<td>
							<g:select id="campeonato" name="campeonato.id" from="${bolao.Campeonato.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.campeonato?.id}" class="many-to-one"/>
						</td>
						<td>
							<g:checkBox name="encerrado" value="${jogoInstance?.encerrado}" />
						</td>
					</tr>
					<thead>
						<tr>
							<th colspan="6">${message(code: "extras.label")}</th>
							<th>${message(code: "manutencao.extras.label")}</th>
						</tr>
					</thead>
					<g:each in="${jogoInstance.extras}" status="i" var="extra">
							<tr>
								<td>${extra.descricao}</td>
								<td>${extra.jogo.time1.descricao}</td>
								<td>${extra.scoretime1}</td>
								<td>x</td>
								<td>${extra.scoretime2}</td>
								<td>${extra.jogo.time2.descricao}</td>
								<td>
									<g:link controller="extras" action="edit" id="${extra.id}">
										<asset:image src="skin/edit.png"/>
									</g:link>
									<g:form controller="extras" action="delete" method="DELETE">
										<g:hiddenField name="id" value="${extra.id}" />
										<g:actionSubmitImage controller="extras" action="delete" value="${message(code: 'button.delete.label')}" title="${message(code: 'button.delete.label')}" src="${assetPath(src:'skin/remove.png')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
									</g:form>
								</td>
							</tr>
					</g:each>
					
</table>