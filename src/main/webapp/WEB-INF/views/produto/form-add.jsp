<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>
	<div>
		<div class="container min-container">
			<h2 class="basic-title">Adicionar produto</h2>
			<form:form role="form" cssClass="well" commandName="produto"
				servletRelativeAction="/produto" method="POST">
				<%@include file="form-inputs.jsp"%>
				<button type="submit" class="btn btn-primary">Salvar</button>

			</form:form>
		</div>
	</div>
</template:admin>
