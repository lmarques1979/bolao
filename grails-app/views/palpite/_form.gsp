<%@ page import="bolao.Palpite" %>

<table>
			<thead>
					<tr>
						<th>Local</th>
						<th>Time da Casa</th>
						<th>Score Time da Casa</th>
						<th>Score Time Visitante</th>
						<th>Time Visitante</th>
						
					</tr>
			</thead>
			<tbody>
					<tr>
						<td>${palpiteInstance?.jogo?.local}</td>
						<td>${palpiteInstance?.jogo?.time1?.descricao}</td>
						<td>
							<div class="fieldcontain ${hasErrors(bean: palpiteInstance, field: 'scoretime1', 'error')} required">
								<label for="scoretime1">
									<g:message code="palpite.scoretime1.label" default="Scoretime1" />
									<span class="required-indicator">*</span>
								</label>
								<g:field name="scoretime1" type="number" value="${palpiteInstance.scoretime1}" required=""/>
							
							</div>
						</td>
						<td>
							<div class="fieldcontain ${hasErrors(bean: palpiteInstance, field: 'scoretime2', 'error')} required">
								<label for="scoretime2">
									<g:message code="palpite.scoretime2.label" default="Scoretime2" />
									<span class="required-indicator">*</span>
								</label>
								<g:field name="scoretime2" type="number" value="${palpiteInstance.scoretime2}" required=""/>
							
							</div>
						</td>
						<td>${palpiteInstance?.jogo?.time2?.descricao}</td>
					
					</tr>
</table>