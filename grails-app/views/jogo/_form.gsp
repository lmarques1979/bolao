<%@ page import="bolao.Jogo" %>

<table>
			<thead>
					<tr>
						<th>Data do Jogo</th>
						<th>Hora do Jogo</th>
						<th>Local do Jogo</th>
						<th>Time 1</th>
						<th>Score Time 1</th>
						<th>Score Time 2</th>
						<th>Time 2</th>
						<th>Campeonato</th>
						
					</tr>
			</thead>
			<tbody>
					<tr>
						<td>
							<g:textField name="datajogo" class="w8em format-d-m-y" size="8" value="${params.datajogo}"  />
							
						</td>
						<td>
							<g:textField name="horajogo" size="3" id="hora" class="time" value="${params.horajogo}" />
							
						</td>
						
						<td>
							<g:textField name="local" size="20" value="${jogoInstance?.local}"/>
							
						</td>
						<td>
							<g:select id="time1" name="time1.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time1?.id}" class="many-to-one"/>
							
						</td>
						
						<td>
							<g:textField name="scoretime1" size="1" value="${jogoInstance?.scoretime1}"/>
						</td>
						
						<td>
							<g:textField name="scoretime2" size="1" value="${jogoInstance?.scoretime2}"/>
						</td>
						
						<td>
							<g:select id="time2" name="time2.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time2?.id}" class="many-to-one"/>
							
						</td>
						
						<td>
							<g:select id="campeonato" name="campeonato.id" from="${bolao.Campeonato.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.campeonato?.id}" class="many-to-one"/>
							
						</td>
					
					</tr>
</table>