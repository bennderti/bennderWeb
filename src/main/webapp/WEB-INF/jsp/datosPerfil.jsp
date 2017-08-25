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
                                            <a href="#"><img src="<c:url value="/resources/img/bennder/logo.png"/>"></a>
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
                        <li><a href="#">Datos cuenta acceso</a></li>
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
                <div class="container">
                        <form:form method="POST"
                                action="../beneficio/guardar.html"
                                id="form-perfil"
                                modelAttribute="datosPerfilForm"
                                accept-charset="iso-8859-1"
                                cssClass="form-horizontal">
                        <h3>Datos de Acceso</h3>
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="ipt-usuario">Usuario:</label>
                             <div class="col-md-4">
                                 <form:input path="usuario" id="ipt-usuario" cssClass="form-control"
                                             placeholder="Nombre de usuario" maxlength="50" readonly="true"/>
                             </div>
                         </div>
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="ipt-password">Password:</label>
                             <div class="col-md-4">
                                 <form:input path="password" id="ipt-password" cssClass="form-control"
                                             placeholder="Ingrese nueva contraseña" maxlength="50"/>
                                 <button type="button" class="btn btn-default btn-primary" onclick="Perfil.cambiarPassword();">Cambiar</button>                                 
                             </div>
                         </div>
                        <h3>Datos Personales</h3>
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="ipt-nombre">Nombres:</label>
                             <div class="col-md-4">
                                 <form:input path="nombres" id="ipt-nombre" cssClass="form-control"
                                             placeholder="Ingrese nombres" maxlength="50"/>
                             </div>
                         </div>
                        <div class="form-group">
                             <label class="control-label col-sm-2" for="ipt-apellidoP">Apellido Paterno:</label>
                             <div class="col-md-4">
                                 <form:input path="apellidoP" id="ipt-apellidoP" cssClass="form-control"
                                             placeholder="Ingrese apellido paterno" maxlength="50"/>
                             </div>
                         </div>
                        <div class="form-group">
                             <label class="control-label col-sm-2" for="ipt-apellidoM">Apellido Materno:</label>
                             <div class="col-md-4">
                                 <form:input path="apellidoM" id="ipt-apellidoM" cssClass="form-control"
                                             placeholder="Ingrese apellido materno" maxlength="50"/>
                             </div>
                         </div>   
                         <h3>Dirección:</h3> 
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="select-region">Región:</label>
                             
                             <%--<div class="col-md-4">
                                 <form:select path="direccion.comuna.region.idRegion"
                                              id="select-region"
                                              cssClass="form-control"
                                              onchange="Perfil.onChangeRegion();">
                                     <form:option value="-1" label="--Seleccione Región--"/>
                                     <form:options items="${regiones}" itemValue="idRegion" itemLabel="nombre"/>
                                 </form:select>
                             </div>--%>
                         </div>
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="select-comunas">Comuna:</label>
                             <%--<div class="col-md-4">
                                 <c:choose>
                                     <c:when test="${not empty comunasRegion}">
                                         <form:select path="direccion.comuna.idComuna"
                                                      id="select-comunas"
                                                      cssClass="form-control">
                                             <form:option value="-1" label="--Seleccione Comuna--"/>
                                             <form:options items="${comunasRegion}" itemValue="idComuna" itemLabel="nombre"/>
                                         </form:select>
                                     </c:when>
                                     <c:otherwise>
                                         <select id="select-comunas" class="form-control" name="direccion.comuna.idComuna">
                                             <option value="-1">--Seleccione Comuna--</option>
                                         </select>
                                     </c:otherwise>
                                 </c:choose>
                             </div>--%>
                         </div>
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="ipt-calle">Calle:</label>
                             <%--<div class="col-md-4">
                                 <form:input path="direccion.calle" id="ipt-calle" cssClass="form-control" placeholder="Ingrese Calle"
                                             maxlength="20"/>
                             </div>--%>
                         </div>
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="ipt-nro">Nro:</label>
                             <%--
                             <div class="col-md-4">
                                 <form:input path="direccion.numero" id="ipt-nro" cssClass="form-control" placeholder="Ingrese Número"
                                             maxlength="10"/>
                             </div>--%>
                         </div>
                         <%--<form:hidden path="direccion.idDireccion"/>--%>
                     </form:form>
                     <div class="form-group">
                         <div class="col-sm-offset-2 col-sm-10">
                             <button type="submit" class="btn btn-primary btn-guardar-beneficio"
                                     onclick="Perfil.onValidaGuardaSucursal();">Guardar
                             </button>
                             <button type="button" class="btn btn-default" onclick="Perfil.onCancelar();">Cancelar</button>
                         </div>
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
    <script type="text/javascript" src="<c:url value="/resources/js/perfil/perfil.js"/>?v=<%=Calendar.getInstance().getTimeInMillis()%>"></script>
    
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
