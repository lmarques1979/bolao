<%@ page import="bolao.Resenha" %>



<div class="fieldcontain ${hasErrors(bean: resenhaInstance, field: 'resenha', 'error')} ">
	<label for="resenha">
		<g:message code="resenha.resenha.label" default="Resenha" />
		
	</label>
	<g:textField name="resenha" value="${resenhaInstance?.resenha}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: resenhaInstance, field: 'autorizacao', 'error')} ">
	<label for="autorizacao">
		<g:message code="resenha.autorizacao.label" default="Autorizacao" />
		
	</label>
	<g:checkBox name="autorizacao" value="${resenhaInstance?.autorizacao}" />

</div>

<div class="fieldcontain ${hasErrors(bean: resenhaInstance, field: 'usuariobolao', 'error')} required">
	<label for="usuariobolao">
		<g:message code="resenha.usuariobolao.label" default="Usuariobolao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuariobolao" name="usuariobolao.id" from="${bolao.UsuarioBolao.list()}" optionKey="id" required="" value="${resenhaInstance?.usuariobolao?.id}" class="many-to-one"/>

</div>

