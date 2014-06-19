<%@ page import="bolao.Campeonato" %>



<div class="fieldcontain ${hasErrors(bean: campeonatoInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="campeonato.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" maxlength="50" required="" value="${campeonatoInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: campeonatoInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="campeonato.imagem.label" default="Imagem" />
		
	</label>
	<input type="file" name="arquivo" value="${campeonatoInstance?.imagem}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: campeonatoInstance, field: 'jogos', 'error')} ">
	<label for="jogos">
		<g:message code="campeonato.jogos.label" default="Jogos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${campeonatoInstance?.jogos?}" var="j">
    <li><g:link controller="jogo" action="show" id="${j.id}">${j?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="jogo" action="create" params="['campeonato.id': campeonatoInstance?.id]">${message(code: 'add.label', args: [message(code: 'jogo.label', default: 'Jogo')])}</g:link>
</li>
</ul>


</div>

