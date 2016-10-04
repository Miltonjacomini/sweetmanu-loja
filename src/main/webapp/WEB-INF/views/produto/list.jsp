<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>

<jsp:attribute name="extraStyles">
<link rel="stylesheet" href="<c:url value='/resources/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
<jsp:attribute name="extraScripts">
<script src="<c:url value='/resources/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>

<jsp:body>
  <div>
    <div class ="container min-container">
      <h2 class="basic-title">Lista de produtos</h2>
        <div class="well">
          <table class="table table-condensed table-bordered table-striped table-hover">
          		  <thead>
	                  <tr>
	                  	<td>Id</td>
	                  	<td>Nome</td>
	                  	<td>Descrição</td>
	                  	<td>Valor</td>
						<td>Ações</td>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='produto'>         		
	                  <tr>
						<td><a href="<c:url value='/produto'/>/${produto.id}">${produto.id}</a></td>
		                  	<td>${produto.nome}</td>
		                  	<td>${produto.descricao}</td>
		                  	<td>${produto.valor}</td>
	                    <td><a href="<c:url value='/produto/remover'/>/${produto.id}">Remover</a></td>
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/produto"/>
          <a href="<c:url value='/produto/form'/>" class="btn btn-success">
          	<span class="glyphicon glyphicon-plus-sign"></span>
          	Novo
          </a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
