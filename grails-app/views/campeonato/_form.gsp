<%@ page import="bolao.Campeonato" %>



<div class="fieldcontain ${hasErrors(bean: campeonatoInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="campeonato.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" maxlength="50" required="" value="${campeonatoInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: campeonatoInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="campeonato.imagem.label" default="Imagem" />
		
	</label>
	<input type="file" name="arquivo" value="${campeonatoInstance?.imagem}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: campeonatoInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="campeonato.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${campeonatoInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: campeonatoInstance, field: 'jogos', 'error')} ">
	<label for="jogos">
		<g:message code="campeonato.jogos.label" default="Jogos" />
	</label>
	
	<g:each in="${campeonatoInstance.jogos}" var="j">
		<span class="property-value" aria-labelledby="jogos-label"><g:link class="nounderline" controller="jogo" action="show" id="${j.id}"><g:formatDate format="dd/MM/yyyy HH:mm" date="${j?.datajogo}" /> - <g:if test="${j?.time1?.imagem}">
			<asset:image class="jogocampeonato" src="bandeiras/24/${j?.time1?.imagem}" title="${j?.time1?.descricao}"/>
			</g:if> ${j?.time1.descricao} ${j?.scoretime1} x ${j?.scoretime2} ${j?.time2.descricao} 
			<g:if test="${j?.time2?.imagem}">
				<asset:image class="jogocampeonato" src="bandeiras/24/${j?.time2?.imagem}" title="${j?.time2?.descricao}"/>
			</g:if></g:link>
		</span>
	</g:each>
	
</div>

	

