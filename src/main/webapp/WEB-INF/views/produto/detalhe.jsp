<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:body>
		<div id="wrapper-container">
			<div class="container object">
				<!-- Detalhe Produto -->
				<!-- Header do Produto -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">${produto.nome}</h1>
					</div>
				</div>

				<!-- Portfolio Item Row -->
				<div class="row">
					<div class="col-md-4">
						<img class="img-responsive"
							src="https://s3-sa-east-1.amazonaws.com/sweetmanu-uploads/${produto.pathFoto}"
							alt="${produto.nome}">
					</div>
		
					<div class="col-md-4">
						<h3>Descrição</h3>
						<p>${produto.descricao}</p>
						<h3>R$&nbsp;${produto.valor}</h3>
					</div>
					<div class="col-md-2">
					<a href="<c:url value='/carrinho/adiciona'/>/${produto.id}">
	          			<span class="btn btn-default btn-sweetmanu">Adicionar</span>
	          		</a>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</template:public>