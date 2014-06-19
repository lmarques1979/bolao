<%@ page import="bolao.Palpite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'palpite.label', default: 'Palpite')}" />
		<title><g:message code="palpite.edit.label" /></title>
	</head>
	<body>
		<a href="#edit-palpite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="palpite.list.label" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="palpite.create.label" /></g:link></li>
			</ul>
		</div>
		<div id="edit-palpite" class="content scaffold-edit" role="main">
			<h1><g:message code="palpite.edit.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${palpiteInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${palpiteInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:palpiteInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${palpiteInstance?.version}" />
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
