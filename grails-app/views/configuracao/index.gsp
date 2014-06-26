
<%@ page import="bolao.Configuracao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'configuracao.label', default: 'Configuracao')}" />
		<title><g:message code="configuracao.list.label"/></title>
	</head>
	<body>
		<a href="#list-configuracao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<g:if test="${configuracaoInstanceCount==0}">
			<div class="nav" role="navigation">
				<ul>
					
						<li><g:link class="create" action="create"><g:message code="configuracao.create.label"/></g:link></li>
				</ul>
			</div>
		</g:if>
		<div id="list-configuracao" class="content scaffold-list" role="main">
			<h1><g:message code="configuracao.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="alturaimagens" title="${message(code: 'configuracao.alturaimagens.label', default: 'Altura Imagens')}" />
					
						<g:sortableColumn property="larguraimagens" title="${message(code: 'configuracao.larguraimagens.label', default: 'Largura Imagens')}" />
						
						<g:sortableColumn property="alturaimagensthumbs" title="${message(code: 'configuracao.alturaimagensthumbs.label', default: 'Altura Imagens Thumbnail')}" />
					
						<g:sortableColumn property="larguraimagensthumbs" title="${message(code: 'configuracao.larguraimagensthumbs.label', default: 'Largura Imagens Thumbnail')}" />
					
						<g:sortableColumn property="tamanhoiconetimes" title="${message(code: 'configuracao.tamanhoiconetimes.label', default: 'Tamanho Icone Times')}" />
					
						<g:sortableColumn property="itensporpagina" title="${message(code: 'configuracao.itensporpagina.label', default: 'Itens por Página')}" />
						
						<g:sortableColumn property="minutosparapalpite" title="${message(code: 'configuracao.minutosparapalpite.label', default: 'Minutos para Palpite')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${configuracaoInstanceList}" status="i" var="configuracaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${configuracaoInstance.id}">${fieldValue(bean: configuracaoInstance, field: "alturaimagens")}</g:link></td>
					
						<td>${fieldValue(bean: configuracaoInstance, field: "larguraimagens")}</td>
					
						<td>${fieldValue(bean: configuracaoInstance, field: "alturaimagensthumbs")}</td>
										
						<td>${fieldValue(bean: configuracaoInstance, field: "larguraimagensthumbs")}</td>
					
						<td>${fieldValue(bean: configuracaoInstance, field: "tamanhoiconetimes")}</td>
						
						<td>${fieldValue(bean: configuracaoInstance, field: "itensporpagina")}</td>
						
						<td>${fieldValue(bean: configuracaoInstance, field: "minutosparapalpite")}</td>
					
											
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${configuracaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
