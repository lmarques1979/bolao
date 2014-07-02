
<%@ page import="bolao.UsuarioBolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioBolao.label', default: 'UsuarioBolao')}" />
		<title><g:message code="usuarioBolao.list.label"/></title>
	</head>
	<body>
		<a href="#list-usuarioBolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-usuarioBolao" class="content scaffold-list" role="main">
			
					<g:if test="${flash.message}">
						<div class="message" role="status">${flash.message}</div>
					</g:if>
					
					<table>
						<thead>
							<tr>
								<th colspan="4"><g:message code="bolao.autorizar.label" default="Bolao" /></th>
							</tr>
							<tr>
								<th><g:message code="bolao.nomebolao.label"/></th>
								<th><g:message code="bolao.nomeusuariobolao.label"/></th>
								<th><g:message code="bolao.emailusuariobolao.label"/></th>
								<th></th>
							</tr>
						</thead>
						<tbody>						
			
						<g:each in="${usuarioBolaoInstanceList}" status="i" var="usuarioBolaoInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td>
								${usuarioBolaoInstance.bolao.descricao}
							</td> 
							
							<td>
								${usuarioBolaoInstance.usuario.buscaNome(usuarioBolaoInstance.usuario)}
							</td> 
							
							<td>
								${usuarioBolaoInstance.usuario.email}
							</td> 
							
							<td>
								<g:if test="${usuarioBolaoInstance.autorizado==false}">
									<g:link action="autorizar" id="${usuarioBolaoInstance.id}">
										<asset:image src="skin/ok_24.png" title="Autorizar ${usuarioBolaoInstance.usuario.buscaNome(usuarioBolaoInstance.usuario)}"/>
									</g:link>
								</g:if>
								<g:else>
									<g:link action="desautorizar" id="${usuarioBolaoInstance.id}">
										<asset:image src="skin/remove_24.png" title="Desautorizar ${usuarioBolaoInstance.usuario.buscaNome(usuarioBolaoInstance.usuario)}"/>
									</g:link>
								</g:else>
							</td> 
							
						</tr>
					</g:each>
					</tbody>
				</table>
			</div>
	</body>
</html>
