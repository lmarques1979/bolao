<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campeonato.label', default: 'Campeonato')}" />
		<title><g:message code="campeonato.create.label"/></title>
	</head>
	<body>
		<a href="#create-campeonato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="create-campeonato" class="content scaffold-create" role="main">
			<h1><g:message code="campeonato.create.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${campeonatoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${campeonatoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:uploadForm url="[resource:campeonatoInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'button.create.label', default: 'Create')}" />
				</fieldset>
			</g:uploadForm>
		</div>
	</body>
</html>
