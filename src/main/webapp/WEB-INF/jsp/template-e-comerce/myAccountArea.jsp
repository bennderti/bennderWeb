<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
     <!-- my-account-area start -->
    <div class="my-account-area">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-6">
<!--                    <form action="#">-->
                <form:form method="POST" action="login.html" id="form-login" commandName="loginForm">
                    <div class="form-fields">
                        <h2>
                            Iniciar sesión</h2>
                        <p>
                            <label>
                                Usuario <span class="required">*</span></label>
<!--                            <input type="text" />-->
                                <form:input path="user" autocomplete="off" id="user-login"/>
                        </p>
                        <p>
                            <label>
                                Password <span class="required">*</span></label>
<!--                            <input type="password" />-->
                                <form:password path="password" maxlength="15"/>
                        </p>
                    </div>                    
                    <!--</form>-->
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
                <div class="col-md-6 col-sm-6">
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
            </div>
        </div>
    </div>