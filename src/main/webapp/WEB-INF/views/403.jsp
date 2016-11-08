<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
            </div>
        </div>
   </div>
	<!-- CORPO DA PAGINA -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Vixi deu Erro, algo aconteceu!!! :( </h2>
				<h3>Mensagem de erro:</h3>
				<br/> 
				<p>${errorMessage}</p>
			</div>	
		</div>
	</div>

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

</body>

</html>
