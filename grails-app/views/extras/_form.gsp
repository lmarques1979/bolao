<%@ page import="bolao.Extras" %>
<%@ page import="bolao.Jogo" %>

<g:set var="jogo" value="${Jogo.get(Long.valueOf(params.id).longValue())}"/>
<g:hiddenField name="jogo" value="${jogo.id}"/>

<table>
		<thead>
			<tr>
				<th><g:message code="extras.descricao.label"/></th>
				<th><g:message code="jogo.time1.label"/></th>
				<th><g:message code="extras.scoretime1.label"/></th>
				<th><g:message code="extras.scoretime2.label"/></th>
				<th><g:message code="jogo.time2.label"/></th>
			</tr>
		</thead>
		<tbody>
					<tr>
						<td><g:textField name="descricao" required="" value="${extrasInstance?.descricao}"/></td>
						<td><g:if test="${jogo?.time1?.imagem}">
								<asset:image src="bandeiras/${params.tamanhoiconetimes}/${jogo?.time1?.imagem}" title="${jogo?.time1?.descricao}"/>
							</g:if>
						</td>
						<td><g:field name="scoretime1" required="" type="number" size="2" maxlength="2" value="${extrasInstance.scoretime1}"/></td>
						<td><g:field name="scoretime2" required="" type="number" size="2" maxlength="2" value="${extrasInstance.scoretime2}"/></td>
						<td><g:if test="${jogo?.time2?.imagem}">
								<asset:image src="bandeiras/${params.tamanhoiconetimes}/${jogo?.time2?.imagem}" title="${jogo?.time2?.descricao}"/>
							</g:if>
						</td>
					</tr>
		</tbody>
</table>