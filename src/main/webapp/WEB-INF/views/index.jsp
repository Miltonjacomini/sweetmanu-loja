<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:body>
	    <!-- Page Content -->
	    <div class="container">
	        <div class="row carousel-holder">
	            <div class="col-md-12">
	                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	                    <ol class="carousel-indicators">
	                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	                    </ol>
	                    <div class="carousel-inner">
	                        <div class="item active carousel-img">
	                            <img class="slide-image" src="<c:url value='https://s3-sa-east-1.amazonaws.com/sweetmanu/banner1.jpg'/>" alt="">
	                        </div>
	                        <div class="item carousel-img">
	                            <img class="slide-image" src="<c:url value='https://s3-sa-east-1.amazonaws.com/sweetmanu/banner2.jpg'/>" alt="">
	                        </div>
	                        <div class="item carousel-img">
	                            <img class="slide-image" src="<c:url value='https://s3-sa-east-1.amazonaws.com/sweetmanu/banner3.jpg'/>" alt="">
	                        </div>
	                    </div>
	                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
	                        <span class="glyphicon glyphicon-chevron-left"></span>
	                    </a>
	                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
	                        <span class="glyphicon glyphicon-chevron-right"></span>
	                    </a>
	                </div>
	            </div>
	        </div>
	
            <div class="row">
				<section id="produtos">
					<c:forEach items="${produtos}" var="produto">
	                   <div class="col-sm-4 col-lg-4 col-md-4">
	                       <div class="thumbnail">
                       	   	   <div class="div-img">
                       	   	   		<img class="img-produto" src="https://s3-sa-east-1.amazonaws.com/sweetmanu/${produto.pathFoto}" alt="${produto.nome}">
                       	   	   </div>
	                           <div class="caption">
	                               <h4 class="pull-right">R$ ${produto.valor}</h4>
                                   <a href="<c:url value='/produto/detalhe'/>/${produto.id}">${produto.nome}</a>
	                               <p>${produto.descricao}</p>
	                           </div>
	                       </div>
	                   </div>
                	</c:forEach>
                </section>
         	</div>
	    </div>
    <!-- /.container -->
    </jsp:body>
</template:public>