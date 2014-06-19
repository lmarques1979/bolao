<%@ page import="bolao.Configuracao" %>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'alturaimagens', 'error')} required">
	<label for="alturaimagens">
		<g:message code="configuracao.alturaimagens.label" default="Altura Imagens" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="alturaimagens" required="" value="${configuracaoInstance?.alturaimagens}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'larguraimagens', 'error')} required">
	<label for="larguraimagens">
		<g:message code="configuracao.larguraimagens.label" default="Largura Imagens" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="larguraimagens" required="" value="${configuracaoInstance?.larguraimagens}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'tamanhoiconetimes', 'error')} required">
	<label for="tamanhoiconetimes">
		<g:message code="configuracao.tamanhoiconetimes.label" default="Tamanho Icone Times" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="tamanhoiconetimes" required="" value="${configuracaoInstance?.tamanhoiconetimes}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'itensporpagina', 'error')} required">
	<label for="tamanhoiconetimes">
		<g:message code="configuracao.itensporpagina.label" default="Itens por Página" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="itensporpagina" required="" value="${configuracaoInstance?.itensporpagina}"/>

</div>
