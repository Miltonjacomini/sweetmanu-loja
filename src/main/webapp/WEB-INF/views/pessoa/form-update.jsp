<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>
	<jsp:body>
		<div>
			<div class="container min-container">
				<h2 class="basic-title">Atualizar pessoa</h2>
				<form:form role="form" cssClass="well" commandName="pessoa"
					servletRelativeAction="/pessoa/${pessoa.id}" method="POST">
	
					<%@include file="form-inputs.jsp"%>
					<button type="submit" class="btn btn-primary">Atualizar</button>
	
				</form:form>
			</div>
		</div>
	</jsp:body>
</template:admin>
