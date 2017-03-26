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
        <%--<jsp:include page="/WEB-INF/jsp/template-e-comerce/cssTemplate.jsp"/>--%>

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
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1>Bienvenido a <strong>Bennder</strong></h1>
                        <div class="description">
                       	    <p>
                                Un mundo de Beneficios!
                            </p>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3 form-box">
                    	<form role="form" action="" method="post" class="f1">

                    		<h3>Te Queremos Conocer</h3>
                    		<p>Ayudanos a completar la siguiente Información</p>
                    		<div class="f1-steps">
                    			<div class="f1-progress">
                    			    <div class="f1-progress-line" data-now-value="16.66" data-number-of-steps="3" style="width: 16.66%;"></div>
                    			</div>
                    			<div class="f1-step active">
                    				<div class="f1-step-icon"><i class="fa fa-user"></i></div>
                    				<p>Información Adicional</p>
                    			</div>
                    			<div class="f1-step">
                    				<div class="f1-step-icon"><i class="fa fa-heart"></i></div>
                    				<p>Preferencias</p>
                    			</div>
<!--                    		    <div class="f1-step">
                    				<div class="f1-step-icon"><i class="fa fa-twitter"></i></div>
                    				<p>Bienvenida</p>
                    			</div>-->
                    		</div>
                    		
                    		<fieldset>
                    		    <h4>Datos de Contacto</h4>
                    			<div class="form-group">
                    			    <label class="sr-only" for="f1-first-name">Email personal</label>
                                    <input type="text" name="f1-first-name" placeholder="Email personal..." class="f1-first-name form-control" id="f1-first-name">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="f1-last-name">Celular</label>
                                    <input type="text" name="f1-last-name" placeholder="Celular..." class="f1-last-name form-control" id="f1-last-name">
                                </div>
                                <div class="form-group">
<!--                                    <label class="sr-only" for="f1-about-yourself">About yourself</label>
                                    <textarea name="f1-about-yourself" placeholder="About yourself..." 
                                    	                 class="f1-about-yourself form-control" id="f1-about-yourself"></textarea>-->
                                    <div class="dropdown">
                                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                            Estado Civil
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                            <li><a href="#">Solter@</a></li>
                                            <li><a href="#">Casad@</a></li>
                                            <li><a href="#">Viud@</li>
                                            <li role="separator" class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="f1-buttons">
                                    <button type="button" class="btn btn-next">Siguiente</button>
                                </div>
                            </fieldset>

                            <fieldset>
                                <h4>Set up your account:</h4>
                                <div class="form-group">
                                    <label class="sr-only" for="f1-email">Email</label>
                                    <input type="text" name="f1-email" placeholder="Email..." class="f1-email form-control" id="f1-email">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="f1-password">Password</label>
                                    <input type="password" name="f1-password" placeholder="Password..." class="f1-password form-control" id="f1-password">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="f1-repeat-password">Repeat password</label>
                                    <input type="password" name="f1-repeat-password" placeholder="Repeat password..." 
                                                        class="f1-repeat-password form-control" id="f1-repeat-password">
                                </div>
                                <div class="f1-buttons">
                                    <button type="button" class="btn btn-previous">Previous</button>
                                    <button type="button" class="btn btn-next">Next</button>
                                </div>
                            </fieldset>

                            <fieldset>
                                <h4>Social media profiles:</h4>
                                <div class="form-group">
                                    <label class="sr-only" for="f1-facebook">Facebook</label>
                                    <input type="text" name="f1-facebook" placeholder="Facebook..." class="f1-facebook form-control" id="f1-facebook">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="f1-twitter">Twitter</label>
                                    <input type="text" name="f1-twitter" placeholder="Twitter..." class="f1-twitter form-control" id="f1-twitter">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="f1-google-plus">Google plus</label>
                                    <input type="text" name="f1-google-plus" placeholder="Google plus..." class="f1-google-plus form-control" id="f1-google-plus">
                                </div>
                                <div class="f1-buttons">
                                    <button type="button" class="btn btn-previous">Previous</button>
                                    <button type="submit" class="btn btn-submit">Submit</button>
                                </div>
                            </fieldset>
                    	
                    	</form>
                    </div>
                </div>
                    
            </div>
        </div>


        <!-- Javascript -->
        <script src='<c:url value="/resources/css/bienvenida/js/jquery-1.11.1.min.js"/>'></script>
        <script src='<c:url value="/resources/css/bienvenida/bootstrap/js/bootstrap.min.js"/>'></script>
        <script src='<c:url value="/resources/css/bienvenida/js/jquery.backstretch.min.js"/>'></script>
        <script src='<c:url value="/resources/css/bienvenida/js/retina-1.1.0.min.js"/>'></script>
        <script src='<c:url value="/resources/css/bienvenida/js/scripts.js"/>'></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>

