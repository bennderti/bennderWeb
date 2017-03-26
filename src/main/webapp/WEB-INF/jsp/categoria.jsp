<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 02-03-2017
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/head.jsp"/>
    <!-- all css here -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/cssTemplate.jsp"/>
    <style>
        li.active {
            background-color: #1d78cb;
        }
        li.active a{
            color: white;
        }
    </style>
</head>
<body>
<!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <!-- Add your site or application content here -->
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
    <jsp:include page="template-e-comerce/shopArea.jsp"/>
</body>
</html>
