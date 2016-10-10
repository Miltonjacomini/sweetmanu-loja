<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>SweetManu</title>

  <!-- bootstrap -->
  <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap-theme.min.css'/>">
</head>
<body>
	
	<h1>Nossos Produtos</h1>

	
	<section class="container">
		<ul class="">
			<c:forEach items="${produtos}" var="produto">
				<li class="">
					<a href="" class="" 
					   title="">
						<div class="">
						</div>
						${produto.nome}
					</a>
				</li>
			</c:forEach>
		</ul>
		
	</section>

</body>
</html>