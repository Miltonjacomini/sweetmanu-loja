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
	  <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap-theme.min.css'/>">
	  <link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
	  <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/small-logo-01.png'/>">
	</head>
	<body>
	  
		<div class="container">
		    <div class="card card-container">
		        <img id="logo-img" class="logo-img" src="https://placeholdit.imgix.net/~text?txtsize=24&txt=150x150&w=150&h=150" />
		        
		        <form:form servletRelativeAction="/login" method="POST" class="form-signin">
		            <input type="email" id="inputEmail" name="username" class="form-control" placeholder="email" required autofocus>
		            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="password" required>
		            
		            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">logar</button>
		        </form:form>
		        <!-- /form -->
		        
		        <div class="signin-help">
					<p>esqueceu sua senha? <a href="#">clique aqui</a></p>
					<p>novo usuário? <a href="#">criar conta</a></p>
				</div>
		    </div>
		</div>
	
	</body>
</html>