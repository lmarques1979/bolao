<%@ page import="bolao.Pais" %>

<div class="fieldcontain ${hasErrors(bean: paisInstance, field: 'codigo', 'error')} required">
	<label for="codigo">
		<g:message code="pais.codigo.label" default="Codigo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="codigo" size="2" maxlength="2" required="" value="${paisInstance?.codigo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: paisInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="pais.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" size="35" maxlength="50" required="" value="${paisInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: paisInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="pais.imagem.label" default="Imagem" />
		
	</label>
	<g:textField name="imagem" size="35" maxlength="50" value="${paisInstance?.imagem}"/>

</div>

