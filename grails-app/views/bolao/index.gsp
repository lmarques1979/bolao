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
					
						<th><g:message code="bolao.informacao.label"/></th>
						
						<th><g:message code="bolao.url.label"/></th>
												
						<th><g:message code="bolao.admin.label"/></th>
					
						<th><g:message code="campeonato.label"/></th>
					
						<th><g:message code="bolao.autorizacao.label"/></th>
						
						<th><g:message code="bolao.imagem.label"/></th>
						
						<th><g:message code="bolao.enabled.label"/></th>
						
										
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${bolaoInstanceList}" status="i" var="bolaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						
						<td><g:link action="show" id="${bolaoInstance.id}">${fieldValue(bean: bolaoInstance, field: "descricao")}</g:link></td>
					
						<td class="esquerda">${bolaoInstance?.informacao}</td>
						
						<td>
							<g:link  target="_blank"  class="create" controller="index" params="[bolao: bolaoInstance?.id]">URL Cadastro Bolão</g:link>
						</td>
						
						<td>${bolaoInstance?.admin?.primeironome}
						     <g:if test="${bolaoInstance?.admin?.sobrenome}">
								${" "+ bolaoInstance?.admin?.sobrenome}
							 </g:if>	
						</td>
					
						<td>${bolaoInstance?.campeonato?.descricao}</td>
						
						<td>
							<g:formatBoolean boolean="${bolaoInstance?.autorizacao}" /><br>
							<g:if test="${bolaoInstance?.autorizacao==true}">
								<g:link class="autorizacao" controller="UsuarioBolao" action="listaautorizacao" id="${bolaoInstance.id}"><g:message code="bolao.autorizar.label"/></g:link><Br>
							</g:if>
							
						</td>
					
					    <td><g:if test="${bolaoInstance.imagem}">
								<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="${bolaoInstance.imagem}" title="${bolaoInstance.descricao}"/>
							</g:if>		
						</td>	
						<td>
							<g:formatBoolean boolean="${bolaoInstance?.enabled}" /><br>
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
