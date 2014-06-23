<%@ page import="bolao.UsuarioBolao" %>

<div class="fieldcontain ${hasErrors(bean: usuarioBolaoInstance, field: 'bolao', 'error')} required">
	<label for="bolao">
		<g:message code="usuarioBolao.bolao.label" default="Bolao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="bolao" name="bolao.id" optionValue="descricao" from="${bolao.Bolao.list()}" optionKey="id" required="" value="${usuarioBolaoInstance?.bolao?.id}" class="many-to-one"/>

</div>