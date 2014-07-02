<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
			    <li><!--<a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>-->
				<!-- Usuario admin -->
				<sec:ifLoggedIn>
					<g:if test="${sec.loggedInUserInfo(field: 'username') == 'admin'}">
						 <li><g:link class="configuracao" controller="Configuracao" action="index" ><g:message code="configuracao.label"/></g:link></li>
						 <li><g:link class="paises" controller="Pais" action="index" ><g:message code="pais.label"/></g:link></li>
						 <li><g:link class="estadio" controller="Estadio" action="index" ><g:message code="estadio.label"/></g:link></li>
						 <li><g:link class="campeonato" controller="Campeonato" action="index" ><g:message code="campeonato.label"/></g:link></li>
						 <li><g:link class="times" controller="Time" action="index" ><g:message code="time.label"/></g:link></li>
						 <li><g:link class="jogos" controller="Jogo" action="index" ><g:message code="jogo.label"/></g:link></li>
						 <li><g:link class="usuarios" controller="Usuario" action="index"><g:message code="usuarios.label"/></g:link></li>
						 <li><g:link class="atualizapontos" controller="Palpite" action="atualizapontos"><g:message code="atualizapontos.label"/></g:link></li>
						
					</g:if>
					<!-- Usuarios logados -->
					<g:if test="${sec.loggedInUserInfo(field: 'username') != 'admin'}">
						 <li><g:link class="bolao" controller="Bolao" action="index"><g:message code="bolao.label"/></g:link></li>
						 <li><g:link class="meusboloes" controller="UsuarioBolao" action="index"><g:message code="usuariobolao.label"/></g:link></li>
						 <li><g:link class="usuario" controller="Usuario" action="show" id="${sec.loggedInUserInfo(field:"id")}"><g:message code="dadosusuario.label"/></g:link></li>
					</g:if> 
					
					<li><g:link class="logout" controller="logout" action="index"><g:message code="logout.label"/></g:link></li>
					<li>
						<g:if test="${sec.loggedInUserInfo(field: 'primeironome')}">
							    <g:set var="usuario" value="${sec.loggedInUserInfo(field: 'primeironome')}" />
						</g:if>
						<g:if test="${sec.loggedInUserInfo(field: 'sobrenome')}">
							    <g:set var="usuario" value="${usuario + ' ' + sec.loggedInUserInfo(field: 'sobrenome')}" />
						</g:if>
						<g:if test="${session["usuariobolao"]}">
							<span class="logout">Usuário: ${usuario} - Bolão:<g:link controller="UsuarioBolao" action="pontuacao" id="${session["usuariobolao"].id}">${session["usuariobolao"].bolao.descricao}</g:link></span>
						</g:if>
						<g:else>
							<span class="logout">Usuário: ${usuario}</span>
						</g:else>
					</li>
				</sec:ifLoggedIn>
				
				<sec:ifNotLoggedIn>
					<li><g:link class="cadastrousuario" controller="Usuario" action="create"><g:message code="usuario.create.label"/></g:link></li>
					<li><g:link class="login" controller="login" action="auth"><g:message code="login.label"/></g:link></li>
				</sec:ifNotLoggedIn>
				
				
			</ul>
		</div><div class="clearer"></div>
		<div id="grailsLogo" role="banner"><a href="${createLink(uri: '/')}"><asset:image src="logo/logo.png" alt="Bolao"/></a>
		
				<g:if test="${sec.loggedInUserInfo(field: 'imagem')}">
					<asset:image class="avatarmain" height="120" width="120" src="usuarios/${sec.loggedInUserInfo(field: 'username')}/${sec.loggedInUserInfo(field: 'imagem')}" title="${sec.loggedInUserInfo(field: 'username')}"/>
				</g:if>
				<g:else>
					<sec:ifLoggedIn>
						<asset:image class="avatarmain" height="120" width="120" src="usuarios/noimage.jpg" title="${sec.loggedInUserInfo(field: 'username')}"/>
					</sec:ifLoggedIn>
				</g:else>
		</div>
		
		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
