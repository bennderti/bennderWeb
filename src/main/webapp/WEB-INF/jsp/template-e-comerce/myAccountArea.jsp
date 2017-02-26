<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/login/login.css"/>?v=<%=Calendar.getInstance().getTimeInMillis()%>">

     <!-- my-account-area start -->
    <div class="my-account-area">
        <div class="container">
            <div class="row center-login">
                <!--<div class="col-md-6 col-sm-6">-->
                <div class="">
                <form:form method="POST" action="login.html" id="form-login" commandName="loginForm">
                    <div class="form-fields">
                        <h2>
                            Iniciar sesión</h2>
                        <p>
                            <label>
                                Usuario <span class="required">*</span></label>
                                <form:input path="user" autocomplete="off" id="user-login" maxlength="50"/>
                        </p>
                        <p>
                            <label>
                                Password <span class="required">*</span></label>
                                <form:password path="password" maxlength="15" id="password"/>
                        </p>
                    </div>              
                    </form:form>    
                    <div class="form-action">
                        <!--<p class="lost_password">
                            <a href="#">Lost your password?</a></p>-->
                        <input type="submit" value="Ingresar" id="input-login" />
                        <!--<label>
                            <input type="checkbox" />
                            Remember me
                        </label>-->
                    </div>
                </div>
                <!--<div class="col-md-6 col-sm-6">
                    <form action="#">
                    <div class="form-fields">
                        <h2>
                            Registrar</h2>
                        <p>
                            <label>
                                Usuario <span class="required">*</span></label>
                            <input type="text" />
                        </p>
                        <p>
                            <label>
                                Password <span class="required">*</span></label>
                            <input type="password" />
                        </p>
                    </div>
                    <div class="form-action">
                        <input type="submit" value="Registrar" id="inicio" />
                    </div>
                    </form>
                </div>
                -->
            </div>
        </div>
    </div>