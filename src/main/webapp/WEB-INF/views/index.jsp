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
			<img src="${contextPath}/resources/assets/img/logo-burst.png" alt="logo sweetmanu" height="38" width="90">
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
            			<img src="${contextPath}/resources/assets/img/icon-premium.svg" alt="administracao"
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
								<a href="${contextPath}">
									<img src="${contextPath}${produto.pathFoto}" alt="${produto.nome}" />
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
	
	<script>
/* PRELOADER */

function preloader() {
	if (document.images) {
		var img1 = new Image();
		var img2 = new Image();
		var img3 = new Image();
		var img4 = new Image();
		var img5 = new Image();
		var img6 = new Image();
		var img7 = new Image();
		var img8 = new Image();
		var img9 = new Image();
		var img10 = new Image();
		var img11 = new Image();
		var img12 = new Image();
		var img13 = new Image();
		var img14 = new Image();
		var img15 = new Image();
		var img16 = new Image();
		var img17 = new Image();
		var img18 = new Image();
		var img19 = new Image();
		var img20 = new Image();

		img1.src = "${contextPath}/resources/assets/img/psd-4.jpg";
		img2.src = "${contextPath}/resources/assets/img/font-1.jpg";
		img3.src = "${contextPath}/resources/assets/img/psd-1.jpg";
		img4.src = "${contextPath}/resources/assets/img/psd-2.jpg";
		img5.src = "${contextPath}/resources/assets/img/ai-1.jpg";
		img6.src = "${contextPath}/resources/assets/img/theme-2.jpg";
		img7.src = "${contextPath}/resources/assets/img/psd-3.jpg";
		img8.src = "${contextPath}/resources/assets/img/font-2.jpg";
		img9.src = "${contextPath}/resources/assets/img/font-3.jpg";
		img10.src = "${contextPath}/resources/assets/img/ai-2.jpg";
		img11.src = "${contextPath}/resources/assets/img/icons-1.jpg";
		img12.src = "${contextPath}/resources/assets/img/ui-1.jpg";
		img13.src = "${contextPath}/resources/assets/img/font-5.jpg";
		img14.src = "${contextPath}/resources/assets/img/theme-2.jpg";
		img15.src = "${contextPath}/resources/assets/img/psd-5.jpg";
		img16.src = "${contextPath}/resources/assets/img/icons-3.jpg";
		img17.src = "${contextPath}/resources/assets/img/font-4.jpg";
		img18.src = "${contextPath}/resources/assets/img/theme-3.jpg";
		img19.src = "${contextPath}/resources/assets/img/font-6.jpg";
		img20.src = "${contextPath}/resources/assets/img/theme-4.jpg";
	}
}
function addLoadEvent(func) {
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function() {
			if (oldonload) {
				oldonload();
			}
			func();
		}
	}
}
addLoadEvent(preloader);

</script>


</body>


</html>
