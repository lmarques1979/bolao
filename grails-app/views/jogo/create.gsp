<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'jogo.label', default: 'Jogo')}" />
		<asset:stylesheet src="datepicker.css"/>
		<asset:stylesheet src="jquery.timepicker.css"/>
		<title><g:message code="jogo.create.label" /></title>
	</head>
	<body>
		<a href="#create-jogo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="create-jogo" class="content scaffold-create" role="main">
			<h1><g:message code="jogo.create.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${jogoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${jogoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:jogoInstance, action:'save']" id='formjogo'>
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'button.create.label', default: 'Create')}" />
				</fieldset>
				<script type='text/javascript'>
					(function() {
						document.forms['formjogo'].elements['datajogo'].focus();
				})();
				</script>
			</g:form>
		</div>
	</body>
</html>
<asset:javascript src="datepicker.js"/>
<asset:javascript src="jquery.timepicker.js"/>
<asset:javascript src="timepickerinit.js"/>