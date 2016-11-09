<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:attribute name="extraScripts">
		<script>
			$(document).ready(function(){
				$('#dtNascimento').mask('00/00/0000');
			});
			$("#cpfCnpj").keypress(function(){
				try{
					$("#cpfCnpj").unmask();
				}catch(e){}
				
				var tamanho = $("#cpfCnpj").val().length;
				
				if(tamanho < 11){
					$('#cpfCnpj').mask('999.999.999-99', {reverse: true});
				}else{
					$('#cpfCnpj').mask('99.999.999/9999-99', {reverse: true});
				}
			})
		</script>
</jsp:attribute>
	<jsp:body>

		<div id="wrapper-container">
			
			<div class="container object">
		
				<div class="row">
					<div class="col-lg-6 col-lg-offset-4">
						<h2>cadastrinho básico  :)</h2>
					</div>
				</div>
				
				<div class="row">
	                <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 form-cadastro">
						
						<form:form id="formCadastro" servletRelativeAction="/minhaConta/cadastro" commandName="pessoa" method="POST">
						
							<div class="col-lg-6">
								<div class="form-group">
		                        	<input type="text" name="nome" class="form-control" placeholder="Nome" required autofocus>
		                        </div>
		                        <div class="form-group">
		                        	<input id="cpfCnpj" type="text" name="cpfCnpj" class="form-control" placeholder="Cpf/Cnpj" required>
		                        </div>
		                        <div class="form-group">
		                        	<input type="password" name="usuario.senha" class="form-control" placeholder="Senha" required>
		                        </div>
		                    </div>
		                    <div class="col-lg-6">
		                    	<div class="form-group">
		                        	<input type="email" name="usuario.email" class="form-control" placeholder="E-mail" required>
		                        </div>
		                    	<div class="form-group">
		                        	<input id="dtNascimento" type="text" name="dtNascimento" class="form-control date" placeholder="Data Nascimento" required>
		                     	</div>
		                     	<div class="form-group">
		                        	<input type="password" name="usuario.senhaConfirma" class="form-control" placeholder="Confirmar Senha" required>
		                        </div>
		                    </div>
		                    <div class="col-lg-12">
	                    		<input type="submit" class="btn btn-info btn-block">
	                    	</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</template:public>