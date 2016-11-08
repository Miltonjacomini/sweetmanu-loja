<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:body>
		<!-- PORTFOLIO -->
		<div class="row">
			<div class="col-lg-6 col-lg-offset-4">
				<h2>recuperação de senha</h2>
			</div>
		</div>
		<div class="row">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 form-cadastro">
				<form:form id="formCadastro" servletRelativeAction="/minhaConta/recuperarSenha" method="POST">
					<div class="col-lg-6">
						<div class="form-group">
							<label for="nome">Digite seu e-mail cadastrado</label>
                        	<input type="text" name="email" class="form-control" placeholder="ex: contato@sweetmanu.com.br" required autofocus>
                        </div>
					</div>
				</form:form>
			</div>
		</div>
	</jsp:body>
</template:public>