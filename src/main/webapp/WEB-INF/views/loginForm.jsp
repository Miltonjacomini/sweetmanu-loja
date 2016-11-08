<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
	  <meta charset="UTF-8">
	  <title>SweetManu</title>
	  <!-- bootstrap -->
	  <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
	  <link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
	  <link rel="icon" type="image/png" href="<c:url value='/resources/img/favicon.png'/>">
	</head>
	<body>
	  	<c:if test="${not empty error}">
            <div class="alert alert-danger alert-dismissable">
	            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
	  	</c:if>
		<div class="container">
		    <div class="card card-container">
		        <img id="logo-img" class="logo-img" src="<c:url value='/resources/img/login.png'/>" />
		        
		        <form:form servletRelativeAction="/login" method="POST" class="form-signin">
		            <input type="email" id="inputEmail" name="username" class="form-control" placeholder="email" required autofocus>
		            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="password" required>
		            
		            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">logar</button>
		        </form:form>
		        <!-- /form -->
		        
		        <div class="signin-help">
					<p>esqueceu sua senha? <a href="<c:url value='/minhaConta/recuperarSenha'/>">clique aqui</a></p>
					<p>novo usuário? <a href="<c:url value='/minhaConta/cadastro'/>">criar conta</a></p>
				</div>
		    </div>
		</div>
	
	</body>
</html>