<%@ page import="bolao.Bolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bolao.label', default: 'Bolao')}" />
		<title><g:message code="regulamento.list.label"/></title>
	</head>
	<body>
		<a href="#list-bolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-bolao" class="content scaffold-list" role="main">
			
			<div class="pontuacao">
				<h1>${message(code: 'pontuacaospan.label')}</h1><div class="clearer"></div>
				<h1 class="subitem">${message(code: 'haveravencedor.label')}</h1>
				 
				<ul>
					<li>${message(code: 'placarexato.label')}</li>
					<li>${message(code: 'scorevencedor.label')}</li>
					<li>${message(code: 'diferencagols.label')}</li>
					<li>${message(code: 'scoreperdedor.label')}</li>
					<li>${message(code: 'acertovencedor.label')}</li>
				</ul>
				
				<h1 class="subitem">${message(code: 'empatada.label')}</h1>
				 
				<ul>
					<li>${message(code: 'placarexato.label')}</li>
					<li>${message(code: 'empatenaoexato.label')}</li>
					<li>${message(code: 'estimulado.label')}</li>
					
				</ul>
				
			</div>
		</div>
	</body>
</html>
