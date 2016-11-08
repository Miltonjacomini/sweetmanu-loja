<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<c:forEach items='${pedidos}' var='pedido'>
				<table class="table table-striped">
					<tr>
						<th>Data Envio</th>
						<th>Pedido</th>
						<th>Status</th>
						<th>Total pedido R$</th>
						<th></th>
					</tr>
					<tr>	
						<td>
							<template:localDate pattern="dd/MM/yyyy" date="${pedido.dtCriacao}"/>
						</td>
						<td>${pedido.id}</td>
						<td>${pedido.status}</td>
						<td>${pedido.getValorTotal(pedido.produtos)}</td>
						<c:if test="${pedido.status == 'ENVIADO' || pedido.status == 'CONFIRMADO'}">
							<td>
								<a href="<c:url value='/minhaConta/cancelarPedido'/>/${pedido.id}">
				          			<span class="btn btn-default btn-sweetmanu">Cancelar pedido</span>
				          		</a>
							</td>
						</c:if>
					</tr>
					<tr>
						<table class="table table-condensed">
							<tr>
								<th>Produto</th>
								<th>Quantidade</th>
								<th>Valor</th>
							</tr>
							<c:forEach items='${pedido.produtos}' var='produto'>
								<tr>	
									<td>${produto.nome}</td>
									<td>${pedido.getQuantidadeProduto(produto)}</td>
									<td>${produto.valor}</td>
								</tr>
							</c:forEach>
						</table>
					</tr>
				</table>
			</c:forEach>
		</div>
	</div>
</div>