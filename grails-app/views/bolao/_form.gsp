<%@ page import="bolao.Bolao" %>

<div class="fieldcontain ${hasErrors(bean: bolaoInstance, field: 'campeonato', 'error')} required">
	<label for="campeonato">
		<g:message code="campeonato.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:select id="campeonato" name="campeonato.id" from="${bolao.Campeonato.list()}" optionValue="descricao" optionKey="id" required="" value="${bolaoInstance?.campeonato?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bolaoInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="bolao.descricao.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" maxlength="50" required="" value="${bolaoInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bolaoInstance, field: 'informacao', 'error')}">
	<label for="descricao">
		<g:message code="bolao.informacao.label"/>
	</label>
	<g:textArea name="informacao" maxlength="1000" required="" value="${bolaoInstance?.informacao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bolaoInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="bolao.imagem.label"/>
		
	</label>
	<input type="file" name="arquivo" value="${bolaoInstance?.imagem}"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: bolaoInstance, field: 'autorizacao', 'error')} required">
	<label for="descricao">
		<g:message code="bolao.autorizacao.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:checkBox name="autorizacao" value="${bolaoInstance?.autorizacao}" />

</div>