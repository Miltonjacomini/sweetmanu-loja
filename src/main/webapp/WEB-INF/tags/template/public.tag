<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="icon" type="image/png" href="<c:url value='/resources/img/favicon.png'/>">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="SweetManu - Doces Gourmet, Salgados e Afins">
    <meta name="author" content="Milton Jacomini Neto">

    <title>SweetManu</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <jsp:invoke fragment="extraStyles"/>
</head>

<body>
    <div class="navbar navbar-fixed-top navbar-default">
        <div class="navbar-inner">
            <div class="container">
                <button type="button" style="float: left;" class="pull-left btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="brand" href="<c:url value='/'/>">
                  <img alt="logo sweetmanu" height="220" width="210"
                       src="<c:url value='/resources/img/sweetmanu-topo.png'/>">
                </a>

                <div class="nav-collapse">
                    <ul class="nav navbar-nav menu-text">
                        <li> <a href="<c:url value='/'/>">LOJA</a></li>
                        <li> <a href="<c:url value='/sobreNos'/>">SOBRE NÓS</a></li>
                        <li> <a href="<c:url value='/contato'/>">CONTATO</a></li>
                    </ul>
                </div>

                <sec:authorize access="hasRole('ROLE_CLIENTE')">
               	<div class="logout navbar-text pull-right">
	                (
	                <a href="<c:url value='/logout'/>"> 
	        			sair
	        		</a>
	        		)
        		</div>
        		</sec:authorize>
        		<a href="<c:url value='/minhaConta'/>">
                  <span class="navbar-text pull-right">MINHA CONTA</span>
                </a>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
	               	<a href="<c:url value='/indexAdmin'/>">
	                  <span class="navbar-text pull-right">ADMIN</span>
	                </a>
        		</sec:authorize>
                <a href="<c:url value='/carrinho'/>">
                  <span class="navbar-text pull-right">CARRINHO</span>
                </a>
            </div>
        </div>
    </div>
	
	<c:if test="${messageSuccess != null || message != null || messageWarning != null || messageError != null}">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="panel-messages">
						<c:if test="${messageSuccess != null}">
				            <div class="alert alert-success alert-dismissable">
					            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				                ${messageSuccess}
				            </div>
			            </c:if>
			            <c:if test="${message != null}">
				            <div class="alert alert-info alert-dismissable">
					            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				                ${message}
				            </div>
			            </c:if>
			            <c:if test="${messageWarning != null}">
				            <div class="alert alert-warning alert-dismissable">
					            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				                ${messageWarning}
				            </div>
			            </c:if>
			            <c:if test="${messageError != null}">
				            <div class="alert alert-danger alert-dismissable">
			   		            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				                ${messageError}
				            </div>
			            </c:if>
			        </div>
	        	</div>
	        </div>
		</div>
	</c:if>
	<!-- CORPO DA PAGINA -->
	<jsp:doBody />
         
    <div class="container">
        <hr>
        <!-- Footer -->
        <footer class="footer">
            <div class="row">
                <div class="col-lg-12">
                    <p>SweetManu todos os direitos reservados, Desenvolvido por Gaia Sistemas</p>
                </div>
            </div>
        </footer>
    </div>
    <!-- /.container -->

    <!-- jQuery -->
	<script src="<c:url value='/resources/js/jquery.js'/>"></script>
	 <!-- jQuery MAsk -->
	<script src="<c:url value='/resources/js/jquery.mask.min.js'/>"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	<jsp:invoke fragment="extraScripts"/>
</body>

</html>