<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 29-03-2017
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/head.jsp"/>
    <!-- all css here -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/cssTemplate.jsp"/>
</head>
<body>
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

    <!-- header-top-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/headerTopArea.jsp">
        <jsp:param name="muestraSesion" value="si"/>
    </jsp:include>
    <!-- header-top-area end -->
    <div class="sticky-wrapper">
        <header>
            <!-- header-bottom-area start -->
            <jsp:include page="/WEB-INF/jsp/template-e-comerce/headerBottomAreaSearch.jsp">
                <jsp:param name="categorias" value="${categorias}"/>
            </jsp:include>
            <!-- header-bottom-area end -->
            <!-- main-menu-area start -->
            <jsp:include page="/WEB-INF/jsp/template-e-comerce/mainMenuAreaHidden.jsp">
                <jsp:param name="categorias" value="${categorias}"/>
            </jsp:include>
            <!-- main-menu-area end -->
            <!-- mobile-menu-area start -->
            <jsp:include page="/WEB-INF/jsp/template-e-comerce/mainMenuAreaVisible.jsp"/>
            <!-- mobile-menu-area end -->
        </header>
    </div>
    <!-- header-top-area end -->

    <jsp:include page="template-e-comerce/singleProduct.jsp">
        <jsp:param name="beneficio" value="${beneficio}"/>
    </jsp:include>

    <jsp:include page="/WEB-INF/jsp/template-e-comerce/jsTemplate.jsp"/>
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
