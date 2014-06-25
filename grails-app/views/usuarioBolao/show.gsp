
<%@ page import="bolao.UsuarioBolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioBolao.label', default: 'UsuarioBolao')}" />
		<title><g:message code="usuarioBolao.list.label"/></title>
	</head>
	<body>
	
		<a href="#show-usuarioBolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="bolao">
				<span>${usuarioBolaoInstance?.bolao?.descricao}</span>
		</div>
		<div class="principal">
			
			<div class="avatar">
			
				<div class="avatarimagem">
					<g:if test="${usuarioBolaoInstance?.bolao?.imagem}">
						<asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="bolao/${usuarioBolaoInstance?.bolao?.descricao}/${usuarioBolaoInstance?.bolao?.imagem}" title="${usuarioBolaoInstance?.bolao?.descricao}"/>
					</g:if>
				</div>
				
				
				
				<div class="informacao">
						<span>${usuarioBolaoInstance?.bolao?.informacao}</span>
				</div>
				
			</div>
			
			
			<div class="sobrebolao">
				<asset:image src="skin/bolao_criacao.png" title="Data de Criação"/><span>Data de Criação: <g:formatDate format="dd/MM/yyyy HH:mm" date="${usuarioBolaoInstance?.bolao?.dateCreated}"/></span><div class="clearer"></div>
				<asset:image src="skin/administrador.png" title="Administrador"/><span>Administrador: ${usuarioBolaoInstance?.bolao?.admin?.username}</span><div class="clearer"></div>
				<asset:image src="skin/membros.png" title="Quantidade de Membros"/><span>Membros: ${usuarioBolaoInstanceCount}</span><div class="clearer"></div>
			</div>
		
		</div>
		
		<div class=principaldetalhes>
			<span>Detalhes do ${usuarioBolaoInstance?.bolao?.descricao}</span>
			<div class="detalhesbolao">
			
			</div>
		
		</div>
		
		
	</body>
</html>
