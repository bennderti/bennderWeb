<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/head.jsp"/>
    <!-- all css here -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/cssTemplate.jsp"/>
</head>
<body class="home-1">
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- Add your site or application content here -->
    <!-- header-top-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/headerTopArea.jsp"/>
    <!-- header-top-area end -->
    <div class="sticky-wrapper">
        <header>			
            <!-- header-bottom-area start -->            
            <jsp:include page="/WEB-INF/jsp/template-e-comerce/headerBottomAreaSearch.jsp">
                <jsp:param name="categorias" value="${categorias}"/>
            </jsp:include>
            <!-- header-bottom-area end -->
            <!-- main-menu-area start -->
            <jsp:include page="/WEB-INF/jsp/template-e-comerce/mainMenuAreaHidden.jsp"/>          
            <!-- main-menu-area end -->
            <!-- mobile-menu-area start -->
            <jsp:include page="/WEB-INF/jsp/template-e-comerce/mainMenuAreaVisible.jsp"/>  
            <!-- mobile-menu-area end -->			
        </header>
    </div>
    <!-- HOME SLIDER -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/homeSlider.jsp"/> 
    <!-- END HOME SLIDER -->
    <!-- banner-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/bannerArea.jsp"/> 
    <!-- banner-area end -->
    <!-- service-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/serviceArea.jsp"/> 
    <!-- service-area end -->
    <!-- features-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/featuresArea.jsp"/> 
    <!-- features-area end -->
    <!-- new-product-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/newProductArea.jsp"/> 
    <!-- new-product-area end -->
    <!-- latest-blog-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/latestBlogArea.jsp"/>
    <!-- latest-blog-area end -->
    <!-- brand-area start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/brandArea.jsp"/>
    <!-- brand-area end -->
    <!-- footer start -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/footer.jsp"/>
    <!-- footer end -->
    <!-- Color Variations -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/colorSchemeSelect.jsp"/>
    <!-- all js here -->
    <!-- jquery latest version -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/jsTemplate.jsp"/>
    
       <!--Modal -->
    <jsp:include page="/WEB-INF/jsp/utils/modal.jsp">     
        <jsp:param name="btnAceptar" value="Aceptar"/>
        <jsp:param name="btnCancelar" value="Cancelar"/>
    </jsp:include>
    <!--Modal-->
</body>
</html>
