<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:body>
	<div id="wrapper-container">
			<div class="container object">
				<div class="row">
					<div class="col-lg-9">
						<h2>Carrinho de compras</h2>
					</div>
					<div class="col-lg-3">
						<a href="<c:url value='/'/>">
		          			<span class="btn btn-default btn-sweetmanu">Quero mais!!</span>
		          		</a>
						<a href="<c:url value='/carrinho/enviarPedido'/>">
		          			<span class="btn btn-default btn-sweetmanu">Enviar pedido</span>
		          		</a>
	          		</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
					    <table class="table table-condensed">
					      <tr>
					        <th>Nome</th>
					        <th>Tipo</th>
					        <th>Valor</th>
					        <th>Quant.</th>
					      </tr>
			
						  <c:forEach items='${carrinhoCompras.itens}' var='item'>
						  	<tr>	
								<td>${item.nome}</td>
						        <td>${item.produtoTipo.nome}</td>
						        <td>${item.valor}</td>
						        <td>
						        	${carrinhoCompras.getQuantidade(item)}
						        	<a href="<c:url value='/carrinho/adiciona'/>/${item.id}">
					          			<span class="glyphicon glyphicon-plus glyphicon-sweet"></span>
					          		</a>
					          		<a href="<c:url value='/carrinho/remover'/>/${item.id}">
					          			<span class="table-remove glyphicon glyphicon-minus glyphicon-sweet"></span>
					          		</a>
						        </td>
					      	</tr>
						  </c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</template:public>