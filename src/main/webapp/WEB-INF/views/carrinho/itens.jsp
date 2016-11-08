<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:body>
	<div id="wrapper-container">
			<div class="container object">
				<div class="row">
					<div class="col-lg-10">
						<h2 class="page-header">Carrinho de compras</h2>
					</div>
					<div class="col-lg-2" style="margin-top: 20px;">
						<a href="#" >Enviar encomenda</a>
					</div>
				</div>
			
				<div id="table" class="table-editable">
				    <table class="table">
				      <tr>
				        <th>Nome</th>
				        <th>Tipo</th>
				        <th>Valor</th>
				        <th>Quantidade</th>
				        <th>Remover</th>
				      </tr>
		
					  <c:forEach items='${carrinhoCompras.itens}' var='item'>
					  	<tr>	
							<td>${item.nome}</td>
					        <td>${item.produtoTipo.nome}</td>
					        <td>${item.valor}</td>
					        <td>
					        	<input type="text" width="3%" value="${carrinhoCompras.getQuantidade(item)}" />	
					        </td>
					        <td>
				          		<a href="<c:url value='/carrinho/remover'/>/${item.id}">
				          			<span class="table-remove glyphicon glyphicon-remove"></span>
				          		</a>
					        </td>
				      	</tr>
					  </c:forEach>
					</table>
				</div>
			</div>
		</div>
	</jsp:body>
</template:public>