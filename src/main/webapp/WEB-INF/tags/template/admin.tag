<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SweetManu</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="SweetManu - Doces Gourmet, Salgados e Afins">
	<meta name="author" content="Milton Jacomini Neto">
    
	<!-- bootstrap -->
	<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap-theme.min.css'/>">
	<link rel="icon" type="image/png" href="<c:url value='/resources/img/favicon.png'/>">
	<!-- style -->
	<link rel="stylesheet" href="<c:url value='/resources/css/index.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources/css/forms.css'/>">
	<jsp:invoke fragment="extraStyles"/>
</head>

<body>
  <!-- INICIO NAV (alterar pra include)-->
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">

        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="<c:url value='/'/>">SweetManu</a>
      </div>

      <div class="collapse navbar-collapse" id="menu">
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            	Menu 
            	<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
	        	<li>
	        		<a href="<c:url value='/produto/form'/>"><span class="glyphicon glyphicon-plus-sign"></span> 
	        			Adicionar produto
	        		</a>
	        	</li>	              
             	<li>
             		<a href="<c:url value='/produto'/>"><span class="glyphicon glyphicon-menu-hamburger"></span>
             			Lista produtos
             		</a>
             	</li>
			  	<li role="separator" class="divider"></li>
              	<li>
              		<a href="<c:url value='/produtoTipo/form'/>"><span class="glyphicon glyphicon-plus-sign"></span>
              			Adicionar tipo produto
              		</a>
              	</li>	              
              	<li>
              		<a href="<c:url value='/produtoTipo'/>"><span class="glyphicon glyphicon-menu-hamburger"></span>
              			Lista tipos
              		</a>
              	</li>
              	<li role="separator" class="divider"></li>
              	<li>
              		<a href="<c:url value='/pessoa/form'/>"><span class="glyphicon glyphicon-plus-sign"></span>
              			Adicionar pessoa
              		</a>
              	</li>	              
              	<li>
              		<a href="<c:url value='/pessoa'/>"><span class="glyphicon glyphicon-menu-hamburger"></span>
              			Lista pessoas
              		</a>
              	</li>
			  	<li role="separator" class="divider"></li>
              	<li>
              		<a href="<c:url value='/encomenda'/>"><span class="glyphicon glyphicon-menu-hamburger"></span>
              			Lista encomendas
              		</a>
              	</li>
            </ul>
          </li>
            <security:authorize access="hasRole('ROLE_ADMIN')">
	            <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
		            	aria-haspopup="true" aria-expanded="false">
		            	<security:authentication property="principal.username"/><span class="caret"></span>
		            </a>
		            <ul class="dropdown-menu">
			        	<li>
			        		<a href="<c:url value='/logout'/>"> 
			        			logout
			        		</a>
			        	</li>	
	        		</ul>
	        	</li>
	        </security:authorize>
        </ul>
      </div>
    </div>
  </nav>

  <!-- FINAL NAV -->
	<jsp:doBody />

<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<jsp:invoke fragment="extraScripts"/>

</body>
</html>