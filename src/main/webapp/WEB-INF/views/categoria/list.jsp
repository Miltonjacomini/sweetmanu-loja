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
      <h2 class="basic-title">Lista de categorias</h2>
        <div class="well">
          <table class="table table-condensed table-bordered table-striped table-hover">
          		  <thead>
	                  <tr>
	                  	<td>Id</td>
		                  	<td>Nome</td>
		                  	<td>Descrição</td>
						<td>Ações</td>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='categoria'>         		
	                  <tr>
						<td>
							<a href="<c:url value='/categoria'/>/${categoria.id}">
								${categoria.id}
							</a>
						</td>
	                	<td>${categoria.nome}</td>
	                	<td>${categoria.descricao}</td>
	                    <td>
	                    	<a href="<c:url value='/categoria/remover'/>/${categoria.id}">
	                    		Remover
	                    	</a>
	                    </td>
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/categoria"/>
          <a href="<c:url value='/categoria/form'/>" class="btn btn-success">
          	<span class="glyphicon glyphicon-plus-sign"></span> 
         		Nova
          </a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
