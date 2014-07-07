<%@ page import="bolao.Jogo" %>

<table>
			
					
			
			<tbody>
					<thead>
						<tr>
							<th>${message(code: "jogo.datajogo.label")}</th>
							<th>${message(code: "jogo.horajogo.label")}</th>
							<th>${message(code: "jogo.peso.label")}</th>
							<th>${message(code: "jogo.rodada.label")}</th>
							<th>${message(code: "jogo.descfase.label")}</th>
							<th>${message(code: "jogo.estadio.label")}</th>
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
						
						<td>
							<g:textField name="descricaofase" size="8" value="${jogoInstance?.descricaofase}"/>
							
						</td>
						
						<td>
							
							<g:select id="estadio" name="estadio.id" from="${bolao.Estadio.list()}" optionValue="estadioCidadeEstado" optionKey="id" required="" value="${jogoInstance?.estadio?.id}" class="many-to-one"/>
							
						</td>
					</tr>
					<thead>
						<tr>
							<th>${message(code: "jogo.time1.label")}</th>
							<th>${message(code: "jogo.scoretime1.label")}</th>
							<th>${message(code: "jogo.scoretime2.label")}</th>
							<th>${message(code: "jogo.time2.label")}</th>
							<th>${message(code: "jogo.campeonato.label")}</th>
							<th>${message(code: "jogo.encerrado.label")}</th>
						</tr>
					</thead>
					<tr>
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
						
						<td>
							<g:select id="campeonato" name="campeonato.id" from="${bolao.Campeonato.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.campeonato?.id}" class="many-to-one"/>
							
						</td>
						<td>
							<g:checkBox name="encerrado" value="${jogoInstance?.encerrado}" />
						</td>
					</tr>
</table>