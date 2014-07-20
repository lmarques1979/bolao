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
		<link rel="shortcut icon" href="${assetPath(src:'favicon.ico')}" type="image/x-icon">
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
						 <li><g:link class="atualizapontos" controller="UsuarioBolao" action="atualizapontos"><g:message code="atualizapontos.label"/></g:link></li>
						
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
							<span class="logout">${message(code: "usuario.username.label")}: ${usuario} - Bolão:<g:link controller="UsuarioBolao" action="pontuacao" id="${session["usuariobolao"].id}">${session["usuariobolao"].bolao.descricao}</g:link></span>
						</g:if>
						<g:else>
							<span class="logout">${message(code: "usuario.username.label")}: ${usuario}</span>
						</g:else>
					</li>
				</sec:ifLoggedIn>
				
				<sec:ifNotLoggedIn>
					<li><g:link params="[bolao: params.bolao]" class="cadastrousuario" controller="Usuario" action="create" ><g:message code="criar.usuario.label"/></g:link></li>
				</sec:ifNotLoggedIn>
				
				<li><g:link id="${params.id}" action="${params.action ? params.action : 'index'}" controller="${params.controller ? params.controller : 'index'}" params="[lang: 'pt_BR']"><asset:image class="internacionalizacao" src="bandeiras/24/Brazil.png" title="${message(code:'portuguesbrasil.label')}"/></g:link></li>
				<li><g:link id="${params.id}" action="${params.action ? params.action : 'index'}" controller="${params.controller ? params.controller : 'index'}" params="[lang: 'en']"><asset:image class="internacionalizacao" src="bandeiras/24/britain.png" title="${message(code:'english.label')}"/></g:link></li>
				<li><g:link id="${params.id}" action="${params.action ? params.action : 'index'}" controller="${params.controller ? params.controller : 'index'}" params="[lang: 'es']"><asset:image class="internacionalizacao" src="bandeiras/24/Spain.png" title="${message(code:'spain.label')}"/></g:link></li>
				
				
			</ul>
		<sec:ifNotLoggedIn>
			
			<div class="loginprincipal">
				<g:form url='/${meta(name:'app.name')}/j_spring_security_check' method='POST' id='formlogin' class='cssform' autocomplete='off'>
				
					<input type='hidden' name='bolao' value='${params.bolao}'/>
					<label for='password'><g:message code="springSecurity.login.username.label"/>:</label>
					<input type='text' name='j_username' id='username'/>
					
					<label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
					<input type='password' name='j_password' id='password'/>
					<g:actionSubmitImage title="${message(code: 'entrar.label')}" value="${message(code: 'button.create.label')}" src="${assetPath(src:'skin/loginSpring.png')}" />
					<g:link controller="Usuario" action="esqueceusenha" class="esqueceusenha"><g:message code="esqueceusenha.label"/></g:link>
				</g:form>
				<script type='text/javascript'>
					(function() {
						document.forms['formlogin'].elements['j_username'].focus();
					})();
				</script>

			</div>
		</sec:ifNotLoggedIn>
		</div><div class="clearer"></div>
		<div id="grailsLogo" role="banner"><a href="${createLink(uri: '/')}"><asset:image src="logo/logo.png" alt="Bolao"/></a>
			<g:if test="${ ( (params.controller=='usuarioBolao' && params.action!='index') || (params.controller!='usuarioBolao') ) }">
				<g:if test="${sec.loggedInUserInfo(field: 'imagem')}">
					<asset:image class="avatarmain" height="120" width="120" src="${sec.loggedInUserInfo(field: 'imagem')}" title="${sec.loggedInUserInfo(field: 'primeironome') + ' ' + sec.loggedInUserInfo(field: 'sobrenome')}"/>
				</g:if>
				<g:else>
					<sec:ifLoggedIn>
						<asset:image class="avatarmain" height="120" width="120" src="noimage.jpg" title="${sec.loggedInUserInfo(field: 'username')}"/>
					</sec:ifLoggedIn>
				</g:else>
			</g:if>
		</div>
		
		<g:layoutBody/>
		<div class="footer" role="contentinfo">
			<span> | </span>
			<g:link controller="diversos" action="pontuacao">
					<g:message code="regulamentogeral.message"/>
			</g:link><span> | </span>
			<g:link controller="diversos" action="contato">
					<g:message code="contato.message"/>
			</g:link>
			<span> | </span>
		</div>
		<div class="clearer"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
