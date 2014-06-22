<%@ page import="bolao.Estadio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'estadio.label', default: 'Estadio')}" />
		<title><g:message code="estadio.edit.label"/></title>
	</head>
	<body>
		<a href="#edit-estadio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="edit-estadio" class="content scaffold-edit" role="main">
			<h1><g:message code="estadio.edit.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${estadioInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${estadioInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:estadioInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${estadioInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
