<%@ page import="bolao.Jogo" %>

<table>
			
					
			
			<tbody>
					<thead>
						<tr>
							<th>Data</th>
							<th>Hora</th>
							<th>Peso Bolão</th>
							<th>Fase</th>
							<th>Desc. Fase</th>
							<th>Local do Jogo</th>
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
							<th>Time 1</th>
							<th>Score Time 1</th>
							<th>Score Time 2</th>
							<th>Time 2</th>
							<th>Campeonato</th>
							<th>Encerrado</th>
						</tr>
					</thead>
					<tr>
						<td>
							<g:select id="time1" name="time1.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time1?.id}" class="many-to-one"/>
							
						</td>
						
						<td>
							<g:textField name="scoretime1" maxlength="1" size="1" value="${jogoInstance?.scoretime1}"/>
						</td>
						
						<td>
							<g:textField name="scoretime2" maxlength="1" size="1" value="${jogoInstance?.scoretime2}"/>
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