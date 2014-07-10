<%@ page import="bolao.Bolao"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title><g:message code="titulopagina.label"/></title>
		
	</head>
	<body>
		 <div id="page-body" role="main">
			<g:if test="${params.bolao}">
			
				<g:set var="bolaoInstance" value="${Bolao.get(params.bolao.toLong())}"/>
				<div class="pontuacao">
					<h1>${message(code: 'cadastreseouloguese.label')}</h1><div class="clearer"></div>
					
					<g:if test="${bolaoInstance.imagem}">
						<asset:image height="100" width="100" src="bolao/${bolaoInstance.descricao}/${bolaoInstance.imagem}" title="${bolaoInstance.descricao}"/>
					</g:if>
							
					<ul>
						<li>${message(code: 'jacadastrado.label')}</li>
						<li>${message(code: 'semcadastro.label')}</li>
					</ul>
				</div>
			</g:if>
		</div>
	</body>
</html>
