<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bolao.label', default: 'Bolao')}" />
		<title><g:message code="bolao.cadastro.label"/></title>
	</head>
	<body>
		
		<div id="list-bolao" class="content scaffold-list" role="main">
		
			<div class="cadastrobolao">
				
				<div class="cadastrologin">
					<g:link class="cadastrado" params="[bolao: params.bolao]" controller="Login" action="auth">Caso JÁ TENHA cadastro clique aqui</g:link><br>
					<span>ou</span><br>
				</div>
				
				
				<div class="cadastrologin">		
					<g:link class="cadastrese" params="[bolao: params.bolao]" controller="Usuario" action="create">Cadastre-se aqui</g:link>
				</div>
			</div>
		</div>
	</body>
</html>
