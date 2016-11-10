<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:body>
		<!-- PORTFOLIO -->
		<div class="row"> 
			<div class="col-lg-12 text-center titulo-pagina">
				<h2>recuperação de senha</h2>
			</div>
		</div>
		<div class="row">
            <div class="col-lg-8 col-lg-offset-3">
            	<form action="${pageContext.request.contextPath}/minhaConta/enviarSenha" method="POST">
            		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="col-lg-8">
						<label for="email">Digite seu e-mail cadastrado</label>
						<input name="email" type="text" placeholder="ex: contato@sweetmanu.com.br" required autofocus style="width:250px;"/>
                		<input class="btn btn-default btn-sweetmanu" value="Enviar" type="submit">
					</div>
				</form>
			</div>
		</div>
	</jsp:body>
</template:public>