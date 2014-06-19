<%@ page import="bolao.Palpite" %>

<div class="fieldcontain ${hasErrors(bean: palpiteInstance, field: 'scoretime1', 'error')} required">
	<label for="scoretime1">
		<g:message code="palpite.scoretime1.label" default="Scoretime1" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="scoretime1" type="number" value="${palpiteInstance.scoretime1}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: palpiteInstance, field: 'scoretime2', 'error')} required">
	<label for="scoretime2">
		<g:message code="palpite.scoretime2.label" default="Scoretime2" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="scoretime2" type="number" value="${palpiteInstance.scoretime2}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: palpiteInstance, field: 'jogo', 'error')} required">
	<label for="jogo">
		<g:message code="palpite.jogo.label" default="Jogo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="jogo" name="jogo.id" from="${bolao.Jogo.list()}" optionKey="id" required="" value="${palpiteInstance?.jogo?.id}" class="many-to-one"/>

</div>

