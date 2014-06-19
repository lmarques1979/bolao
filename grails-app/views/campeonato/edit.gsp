<%@ page import="bolao.Campeonato" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campeonato.label', default: 'Campeonato')}" />
		<title><g:message code="campeonato.edit.label"/></title>
	</head>
	<body>
		<a href="#edit-campeonato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-campeonato" class="content scaffold-edit" role="main">
			<h1><g:message code="campeonato.edit.label"/></h1>
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
			<g:uploadForm url="[resource:campeonatoInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${campeonatoInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'button.update.label', default: 'Update')}" />
				</fieldset>
			</g:uploadForm>
		</div>
	</body>
</html>
