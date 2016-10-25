<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
	<jsp:body>
		<!-- PORTFOLIO -->
		<div id="wrapper-container">
			
			<div class="container object">
				
				<div id="main-container-image">
						
					<section class="work">
						<c:forEach items="${produtos}" var="produto">
							<figure class="white">
								<a href="<c:url value='/produto/detalhe'/>/${produto.id}">
									<img src="https://s3-sa-east-1.amazonaws.com/sweetmanu-uploads/${produto.pathFoto}" 
										alt="${produto.nome}" />
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
			
		</div>
	</jsp:body>
</template:public>