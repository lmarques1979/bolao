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
		
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<div class="contato">
				<h1><g:message code="contato.label"/></h1>
				<g:form controller="diversos" action="enviaremail"  >
			
					<div class="fieldcontain required"> 
						<label for="codigo">
							<g:message code="nomecontato.label"/>
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="nomecontato" size="30" maxlength="50" required=""/>
					
					</div>
					
					<div class="fieldcontain required">
						<label for="email">
							<g:message code="emailcontato.label"/>
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="emailcontato" size="40" maxlength="50" required=""/>
					
					</div>
					
					<div class="fieldcontain required">
						<label for="telefone">
							<g:message code="telefonecontato.label"/>
						</label>
						<g:textField name="telefonecontato" size="15" maxlength="14"/>
					
					</div>
					
					<div class="fieldcontain required">
						<label for="assunto">
							<g:message code="assuntocontato.label"/>
						</label>
						<g:textField name="assuntocontato" size="30" maxlength="50"/>
					
					</div>
					
					<div class="fieldcontain required">
						<label for="mensagem">
							<g:message code="mensagemcontato.label"/>
							<span class="required-indicator">*</span>
						</label>
						<g:textArea name="mensagemcontato" rows="5" cols="45" required=""/>
					
					</div>
					<fieldset>
						<g:submitButton name="create" value="${message(code: 'button.send.label')}" />
					</fieldset>
				
				</g:form>
			</div>
			
			
			
		</div>
	</body>
</html>
