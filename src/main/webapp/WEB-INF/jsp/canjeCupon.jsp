<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <!--head-->
     <jsp:include page="/WEB-INF/jsp/template-e-comerce/head.jsp"/>
    <!-- all css here -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/cssTemplate.jsp"/>
</head>
<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- Add your site or application content here -->
    <!-- header-top-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/headerTopArea.jsp"/>
    <!-- header-top-area end -->
    <div class="sticky-wrapper">
        <header>			
                        <div class="header-bottom-area">
                            <div class="container">
                                <div class="row logo-bennder">
                                    <div class="">
                                        <div class="logo">
                                            <a href="index.html"><img src="<c:url value="/resources/img/bennder/logo.png"/>"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
			<!-- header-bottom-area end -->         
			<!-- main-menu-area end -->
			<!-- mobile-menu-area start -->
			<%--<jsp:include page="/WEB-INF/jsp/template-e-comerce/mainMenuAreaVisible.jsp"/>--%>
			<!-- mobile-menu-area end -->			
        </header>
    </div>
    <!-- HOME SLIDER -->
    <!-- heading-banner start -->
    <div class="heading-banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="breadcrumb">
                        <li><a href="#">Validación cupón</a></li>
                        <!--<li class="active">Login</li>-->
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- heading-banner end -->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/login/login.css"/>?v=<%=Calendar.getInstance().getTimeInMillis()%>">
    <!-- my-account-area start -->
    <div class="my-account-area">
        <div class="container">
            <div class="row center-login">
                <!--<div class="col-md-6 col-sm-6">-->
                <div class="">
                <form:form method="POST" action="validacionCanjeCuponPOS.html" id="form-valida-canje-cupon" commandName="validaCuponForm">
                    <div class="form-fields">
                        <h2>
                            Datos validación</h2>
                        <p>
                            <label>
                                RUT Vendedor (sin dv) <span class="required">*</span></label>
                                <form:input path="idVendedor" autocomplete="off" id="id-vendedor" maxlength="50" cssClass="form-control"/>
                        </p>
                        <p>
                            <label>
                                Sucursal <span class="required">*</span></label>
                                <form:select path="idDireccionSucursal" id = "direccion-sucursal" cssClass="form-control">
                                    <form:option value="-1" label="--Seleccione sucursal--"/>
                                    <form:options items="${listaSucursal}" itemValue="idDireccion" itemLabel="nombreSucursal"/>
                                </form:select>
                        </p>  
                        <p>
                            <label>
                                Password Sucursal <span class="required">*</span></label>
                                <form:password path="passwordSucursal" maxlength="15" id="password-sucursal" cssClass="form-control"/>
                        </p>  
                    </div>              
                    </form:form>    
                    <div class="form-action">
                        <input type="submit" value="Validar" id="valida-cupon" />
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- my-account-area end -->
    <!-- footer start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/footer.jsp">
        <jsp:param name="footerTopAreaShow" value="no"/>
        <jsp:param name="footerBottomAreaCopyrightShow" value="si"/>
        <jsp:param name="footerBottomAreaPaymentShow" value="no"/>
    </jsp:include>
    <!-- footer end -->
    <!-- Color Variations -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/colorSchemeSelect.jsp"/>
       
    <!-- all js here -->
    <!-- jquery latest version -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/jsTemplate.jsp"/>
    <!--Js Login (dejar versión *.min.js ofuscada-->
    <script type="text/javascript" src="<c:url value="/resources/js/beneficio/canjeCupon.js"/>?v=<%=Calendar.getInstance().getTimeInMillis()%>"></script>
    
    <!--Modal -->
    <jsp:include page="/WEB-INF/jsp/utils/modal.jsp">     
        <jsp:param name="btnAceptar" value="Aceptar"/>
        <jsp:param name="btnCancelar" value="Cancelar"/>
    </jsp:include>
    <!--Modal-->    
    <!-- Loading -->
    <jsp:include page="/WEB-INF/jsp/utils/loading.jsp"/>
    <!-- Loading -->
</body>
</html>
