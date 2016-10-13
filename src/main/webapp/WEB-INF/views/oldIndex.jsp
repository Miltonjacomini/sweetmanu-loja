<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<c:url value="/" var="contextPath" />
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
					<a href="" title="${produto.nome}">
						<c:if test="${!produto.pathFoto.isEmpty()}">
							<input type="image" src="${contextPath}${produto.pathFoto}" alt="${produto.nome}" />
						</c:if>
						<div class="">
							${produto.nome}
						</div>
						${contextPath}${produto.pathFoto}
					</a>
				</li>
			</c:forEach>
		</ul>
		
	</section>

</body>
</html>