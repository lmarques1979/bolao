<%@ page import="bolao.Time" %>



<div class="fieldcontain ${hasErrors(bean: timeInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="time.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" maxlength="50" required="" value="${timeInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: timeInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="time.imagem.label" default="Imagem" />
		
	</label>
	<g:textField name="imagem" maxlength="50" value="${timeInstance?.imagem}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: timeInstance, field: 'campeonato', 'error')} required">
	<label for="regra">
		<g:message code="time.campeonato.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:select id="campeonato" name="campeonato.id" from="${bolao.Campeonato.list()}" optionKey="id" optionValue="descricao" required="" value="${timeInstance?.campeonato?.id}" class="many-to-one"/>

</div>