<%@ page import="bolao.UsuarioBolao" %>



<div class="fieldcontain ${hasErrors(bean: usuarioBolaoInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="usuarioBolao.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${seguranca.Usuario.list()}" optionKey="id" required="" value="${usuarioBolaoInstance?.usuario?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioBolaoInstance, field: 'bolao', 'error')} required">
	<label for="bolao">
		<g:message code="usuarioBolao.bolao.label" default="Bolao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="bolao" name="bolao.id" from="${bolao.Bolao.list()}" optionKey="id" required="" value="${usuarioBolaoInstance?.bolao?.id}" class="many-to-one"/>

</div>

