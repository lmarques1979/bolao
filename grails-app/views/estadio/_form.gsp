<%@ page import="bolao.Estadio" %>

<div class="fieldcontain ${hasErrors(bean: estadioInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="estadio.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" maxlength="50" required="" value="${estadioInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: estadioInstance, field: 'cidade', 'error')} required">
	<label for="cidade">
		<g:message code="estadio.cidade.label" default="Cidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cidade" maxlength="50" required="" value="${estadioInstance?.cidade}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: estadioInstance, field: 'estado', 'error')} required">
	<label for="estado">
		<g:message code="estadio.estado.label" default="Estado" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="estado" maxlength="50" required="" value="${estadioInstance?.estado}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: estadioInstance, field: 'pais', 'error')} required">
	<label for="pais">
		<g:message code="estadio.pais.label" default="Pais" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pais" name="pais.id" from="${bolao.Pais.list()}" optionKey="id" required="" optionValue="descricao" value="${estadioInstance?.pais?.id}" class="many-to-one"/>

</div>

