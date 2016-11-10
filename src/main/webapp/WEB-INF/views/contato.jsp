<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:body>
	    <!-- Page Content -->
	    <div class="container">
	    		
	    		<div class="col-lg-12 text-center titulo-pagina">
	    			<h2>Entre em contato conosco</h2>
	    		</div>
	    		
	    	<div class="row">
	    		<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 form-cadastro">
	    			<form action="${pageContext.request.contextPath}/contato" method="POST">
	            		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    			<div class="col-lg-5">
		    				<input type="text" name="nome" placeholder="Nome" class="form-control" required style="margin-bottom:10px;">
		    				<input type="text" name="email" placeholder="E-mail" class="form-control" required style="margin-bottom:10px;">
		    				<input type="text" name="assunto" placeholder="Assunto" class="form-control" required style="margin-bottom:10px;">
		    				<input type="submit" value="Enviar" class="btn btn-default btn-sweetmanu" width="100%;">
		    			</div>
		    			<div class="col-lg-7">
		    				<textarea name="mensagem" placeholder="Mensagem" rows="10" cols="80" class="form-control"></textarea>
		    			</div>
	    			</form>
	    		</div>
	    	</div>
	    </div>
	</jsp:body>
</template:public>