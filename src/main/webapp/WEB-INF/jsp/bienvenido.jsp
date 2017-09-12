<%-- 
    Document   : bienvenida
    Created on : 21-mar-2017, 0:18:28
    Author     : Marcos
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="/WEB-INF/jsp/template-e-comerce/jsTemplate.jsp"/>   
        <jsp:include page="/WEB-INF/jsp/utils/modal.jsp">     
            <jsp:param name="btnAceptar" value="Aceptar"/>
            <jsp:param name="btnCancelar" value="Cancelar"/>
        </jsp:include>   
        

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bennder - Bienvenido</title>

        <!-- CSS -->        
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href='<c:url value="/resources/css/bienvenida/bootstrap/css/bootstrap.min.css"/>'>     
        <link rel="stylesheet" href='<c:url value="/resources/css/bienvenida/font-awesome/css/font-awesome.min.css"/>'>     
        <link rel="stylesheet" href='<c:url value="/resources/css/bienvenida/css/form-elements.css"/>'>
        <link rel="stylesheet" href='<c:url value="/resources/css/bienvenida/css/style.css"/>'>
        <link rel="stylesheet" href='<c:url value="/resources/css/bienvenida/bootstrap/css/bootstrap-select.css"/>'>  

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->       
    </head>

    <body>    
        <!-- Top menu -->
        <nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
            <div style="padding-left: 70px;">
                <div class="navbar-header">					
                    <a class="navbar-brand" href="index.html" style="height: 55px;">Work - Life Balance</a>
                </div>                         
            </div>
        </nav>

        <!-- Top content -->
        <div class="top-content">
            <div class="container" style="margin-left: inherit;">                
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1 col-md-8 form-box f1">
                    	<form role="form" action="" method="post">
                            <div>
                                <h1>Bienvenido a <strong>Bennder</strong></h1>
                                <div class="description">
                                    <p>Un mundo de Beneficios!</p>
                                </div>
                            </div>
                            
                            <div class="f1-steps">
                                <div class="f1-progress">
                                    <div class="f1-progress-line" data-now-value="100" data-number-of-steps="1" style="width: 100%;"></div>
                                </div>
                                <div class="f1-step active" style="width: 100%;">
                                    <div class="f1-step-icon">
                                        <i class="fa fa-heart"></i>
                                    </div>
                                    <p>Categorías</p>
                                </div>
                            </div>
                        </form>    
                        
                        <h4 class="f1">Ayudanos seleccionando tus preferencias</h4>
         
                        <c:forEach items="${categorias}" var="categoria">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="maxOption2" class="col-lg-2 control-label">${categoria.nombre}</label>
                                    <div class="col-lg-10">
                                        <select id="maxOption2" class="selectpicker show-menu-arrow form-control" multiple>
                                            <c:forEach items="${categoria.subCategorias}" var="subCategoria">
                                                <option id="${subCategoria.idCategoria}">${subCategoria.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </form>                            
                            <hr>
                        </c:forEach>
                            
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <div class="f1-buttons">
                                    <button type="button" class="btn btn-next" style="color: white;" onclick="BienvenidaBennder.siguiente()">Siguiente</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>                    
            </div>
        </div>

        <!-- Javascript -->

<!--        <script src='<c:url value="/resources/css/bienvenida/js/jquery-1.11.1.min.js"/>'></script>-->
<!--        <script src='<c:url value="/resources/css/bienvenida/bootstrap/js/bootstrap.min.js"/>'></script>-->
        <script src='<c:url value="/resources/css/bienvenida/js/jquery.backstretch.min.js"/>'></script>
        <script src='<c:url value="/resources/css/bienvenida/js/retina-1.1.0.min.js"/>'></script>
        <script src='<c:url value="/resources/css/bienvenida/js/scripts.js"/>'></script>
        <script src='<c:url value="/resources/css/bienvenida/bootstrap/js/bootstrap-select.js"/>'></script>    
        <script src='<c:url value="/resources/js/bienvenido/bienvenida.js"/>'></script>  
    </body>
</html>

