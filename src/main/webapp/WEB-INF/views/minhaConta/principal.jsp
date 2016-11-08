<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:public>
<jsp:attribute name="extraScripts">
	<script>
		$(document).ready(function(){
			$('#dtNascimento').mask('00/00/0000');
		});
		$("#cpfCnpj").keypress(function(){
			try{
				$("#cpfCnpj").unmask();
			}catch(e){}
			
			var tamanho = $("#cpfCnpj").val().length;
			
			if(tamanho < 11){
				$('#cpfCnpj').mask('000.000.000-00', {reverse: true});
			}else{
				$('#cpfCnpj').mask('00.000.000/0000-00', {reverse: true});
			}
		});
		var maskBehavior = function (val) {
		 return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		},
		options = {onKeyPress: function(val, e, field, options) {
		 field.mask(maskBehavior.apply({}, arguments), options);
		 }
		};
		$('.telefoneECelular').mask(maskBehavior, options);
	</script>
</jsp:attribute>
	<jsp:body>
	    <!-- CORPO DA PAGINA -->
		<div class="container">
			<div class="row">
	            <div class="col-lg-12">
	         		<ul class="nav nav-tabs" role="tablist">
                        <li class="active">
							<a data-toggle="tab" href="#home-tab" onclick="carregaPessoa()">
								Home
							</a>
                        </li>
                        <li>
							<a data-toggle="tab" href="#dadosPessoais-tab">
								Dados pessoais
							</a>
                        </li>
                        <li>
	                        <a data-toggle="tab" href="#minhasEncomendas-tab">
								Minhas encomendas
	                        </a>
                        </li>
                    </ul>
                 
                   		 <!-- Tab panes -->
                     <div class="tab-content">
                         <div id="home-tab" class="tab-pane fade in active">
                             <h4 class="titulo-abas">Bem vindo(a), ${pessoa.nome}</h4>
                             <p>Aqui você encontrará suas informações pessoais e seus pedidos, sinta-se à vontade.</p>
                         </div>
                         
                         <div id="dadosPessoais-tab" class="tab-pane fade">
                             <h4 class="titulo-abas">Dados pessoais</h4>
                             <%@include file="dadosPessoais.jsp"%>
                         </div>
                         
                         <div id="minhasEncomendas-tab" class="tab-pane fade">
                             <h4 class="titulo-abas">Minhas encomendas</h4>
                             <%@include file="minhasEncomendas.jsp"%>
                         </div>
                  </div>
	            </div>
	        </div>         
		</div>
    </jsp:body>
</template:public>