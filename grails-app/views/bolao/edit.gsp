<%@ page import="bolao.Bolao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bolao.label', default: 'Bolao')}" />
		<title><g:message code="bolao.edit.label"/></title>
	</head>
	<body>
		<a href="#edit-bolao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="bolao.list.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="bolao.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="edit-bolao" class="content scaffold-edit" role="main">
			<h1><g:message code="bolao.edit.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${bolaoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${bolaoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:bolaoInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${bolaoInstance?.version}" />
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
