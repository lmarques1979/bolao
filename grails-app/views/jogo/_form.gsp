<%@ page import="bolao.Jogo" %>

<table>
			<thead>
					<tr>
						<th>Data do Jogo</th>
						<th>Hora do Jogo</th>
						<th>Local do Jogo</th>
						<th>Time da Casa</th>
						<th>Time Visitante</th>
						<th>Campeonato</th>
						
					</tr>
			</thead>
			<tbody>
					<tr>
						<td>
							<g:textField name="datajogo" class="w8em format-d-m-y" size="12ß" value="${params.datajogo}"  />
							
						</td>
						<td>
							<g:textField name="horajogo" size="5" id="hora" class="time" value="${params.horajogo}" />
							
						</td>
						
						<td>
							<g:textField name="local" size="30" value="${jogoInstance?.local}"/>
							
						</td>
						<td>
							<g:select id="time1" name="time1.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time1?.id}" class="many-to-one"/>
							
						</td>
						<td>
							
								<g:select id="time2" name="time2.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time2?.id}" class="many-to-one"/>
							
						</td>
						<td>
							<g:select id="campeonato" name="campeonato.id" from="${bolao.Campeonato.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.campeonato?.id}" class="many-to-one"/>
							
						</td>
					
					</tr>
</table>











