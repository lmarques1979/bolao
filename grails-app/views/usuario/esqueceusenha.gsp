<html>
<head>
	<meta name='layout' content='main'/>
	<title>Esqueceu a Senha?</title>
</head>

<body>
<div id='login'>
	<div class='inner'>

		<div class='fheader'>Esqueceu a senha?</div> 

		<g:if test='${flash.message}'>
			<g:each in="${flash.message}" status="i" var="mensagem">
				<div class='login_message'>${mensagem}</div>
			</g:each>
		</g:if><br>

		<form action='enviarsenha' method='POST' id='loginForm' class='cssform' autocomplete='off'>
			<p>
				<label for='username'>Usuário:</label>
				<input type='text' value="${params.username}" size="15" class='text_' name='username' id='username'/>
			</p>

			<p>
				<label for='email'>E-mail:</label>
				<input type='text' value="${params.email}" size="30" class='text_' name='email' id='email'/>
			</p>

			
			<p>
				<input type='submit' id="submit" value='Enviar'/>
			</p>
		</form>
	</div>
</div>
<script type='text/javascript'>
	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();
</script>
</body>
</html>
