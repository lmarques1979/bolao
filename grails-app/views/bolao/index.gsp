
<%@ page import="bolao.Bolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bolao.label', default: 'Bolao')}" />
		<title><g:message code="bolao.list.label"/></title>
	</head>
	<body>
		<a href="#list-bolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="bolao.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-bolao" class="content scaffold-list" role="main">
			<h1><g:message code="bolao.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="descricao" title="${message(code: 'bolao.descricao.label', default: 'Descricao')}" />
					
						<th><g:message code="bolao.url.label" default="URL inscrição Bolão" /></th>
						
						<th><g:message code="bolao.admin.label" default="Admin" /></th>
					
						<th><g:message code="campeonato.label" default="Campeonato" /></th>
					
						<g:sortableColumn property="imagem" title="${message(code: 'bolao.imagem.label', default: 'Imagem')}" />
					
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${bolaoInstanceList}" status="i" var="bolaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						
						<td><g:link action="show" id="${bolaoInstance.id}">${fieldValue(bean: bolaoInstance, field: "descricao")}</g:link></td>
					
						<td>
							<g:link class="create" controller="Usuario" action="create?bolao=${bolaoInstance.id}">URL Cadastro Bolão</g:link>
						</td>
						
						<td>${bolaoInstance?.admin?.primeironome}
						     <g:if test="${bolaoInstance?.admin?.sobrenome}">
								${" "+ bolaoInstance?.admin?.sobrenome}
							 </g:if>	
						</td>
					
						<td>${bolaoInstance?.campeonato?.descricao}</td>
					
						
						
					    <td><g:if test="${bolaoInstance.imagem}">
								<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="bolao/${bolaoInstance.descricao}/${bolaoInstance.imagem}" title="${bolaoInstance.descricao}"/>
							</g:if>		
						</td>	
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bolaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
