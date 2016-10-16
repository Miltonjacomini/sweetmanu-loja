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

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Behavioral Meta Data -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/small-logo-01.png'/>">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,900,900italic,700italic,700,500italic,400italic,500,300italic,300' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
	<link rel='stylesheet' type='text/css' href="<c:url value='/resources/assets/css/style.css'/>">

</head>

<body>

<a name="ancre"></a>

<!-- CACHE -->
<div class="cache"></div>

<!-- HEADER -->

<div id="wrapper-header">
	<div id="main-header" class="object">
		<div class="logo">
			<img alt="logo sweetmanu" height="38" width="90"
				src="<c:url value='/resources/assets/img/logo-burst.png'/>"> 
		</div>
    </div>
</div>

<!-- NAVBAR -->

<div id="wrapper-navbar">
		<div class="navbar object">
    		<div id="wrapper-sorting">
	            <div id="wrapper-title-1">
	            <div class="top-rated object">Home</div>
	            	<div id="fleche-nav-1"></div>
	    		</div>
	            
	            <div id="wrapper-title-2">
	            <a href="#"><div class="recent object">Sobre nós</div></a>
	                <div id="fleche-nav-2"></div>
	    		</div>
	            
	            <div id="wrapper-title-3">
	            <a href="#"><div class="oldies object">Portfólio</div></a>
	                <div id="fleche-nav-3"></div>
	    		</div>
            </div>
            
            <div id="wrapper-bouton-icon">
            	<div id="bouton-premium">
            		<a href="<c:url value='/indexAdmin'/>">
            			<img src="<c:url value='/resources/assets/img/icon-premium.svg'/>"
            			 	 alt="administracao"
            				 title="Administração" height="28" width="28">
            		</a>
            	</div>
			</div>
    	</div>
    </div>

<!-- PORTFOLIO -->

	<div id="wrapper-container">
    
		<div class="container object">

			<div id="main-container-image">
                       
					<section class="work">

						<c:forEach items="${produtos}" var="produto">
							<figure class="white">
								<a href="">
									<img src="https://s3-sa-east-1.amazonaws.com/sweetmanu-uploads/${produto.pathFoto}" alt="${produto.nome}" />
									<dl>
										<dt>${produto.nome}</dt>
										<dd>${produto.descricao}</dd>	
									</dl>
								</a>
	                            <div id="wrapper-part-info">
	                            	<div id="part-info">${produto.nome}</div>
								</div>
	                        </figure>	
						</c:forEach>
                        
					</section>
                    
				</div>	
            	    
			</div>
         
    <div id="wrapper-oldnew">
    	<div class="oldnew">
        	<div class="wrapper-oldnew-prev">
            	<div id="oldnew-prev"></div>
        	</div>
            <div class="wrapper-oldnew-next">
            	<div id="oldnew-next"></div>
    		</div>
        </div>
	</div>     
            
	<div id="wrapper-thank">
    	<div class="thank">
        	<div class="thank-text">Sweet<span style="letter-spacing:-5px;"></span>Manu</div>
    	</div>
	</div>
	    
    <div id="wrapper-copyright">
		<div class="copyright">
    		<div class="copy-text object"><a style="color:#D0D1D4;" href="http://sweetmanu.com.br">SweetManu</a> - Todos os direitos reservados.</div>
    		
			<div class="wrapper-navbouton">
    			<div class="google object">g</div>
    			<div class="facebook object">f</div>
    			<div class="linkin object">i</div>
    			<div class="dribbble object">d</div>
    		</div>
    	</div>
    </div>

</div>



<!-- SCRIPT -->

	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value='/resources/assets/js/jquery.scrollTo.min.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/jquery.localScroll.min.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/jquery-animate-css-rotate-scale.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/fastclick.min.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/jquery.animate-colors-min.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/jquery.animate-shadow-min.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/main.js'/>"></script>
	


</body>


</html>
