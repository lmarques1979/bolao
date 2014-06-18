<%@ page import="bolao.Jogo" %>

<div class="fieldcontain ${hasErrors(bean: jogoInstance, field: 'datajogo', 'error')} required">
	<label for="datajogo">
		<g:message code="jogo.datajogo.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="datajogo" precision="day"  value="${jogoInstance?.datajogo}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: jogoInstance, field: 'time1', 'error')} required">
	<label for="time1">
		<g:message code="jogo.time1.label" default="Time 1" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="time1" name="time1.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time1?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jogoInstance, field: 'time2', 'error')} required">
	<label for="time2">
		<g:message code="jogo.time2.label" default="Time 2" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="time2" name="time2.id" from="${bolao.Time.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.time2?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: jogoInstance, field: 'campeonato', 'error')} required">
	<label for="campeonato">
		<g:message code="campeonato.label" default="Campeonato" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="campeonato" name="campeonato.id" from="${bolao.Campeonato.list()}" optionValue="descricao" optionKey="id" required="" value="${jogoInstance?.campeonato?.id}" class="many-to-one"/>

</div>

