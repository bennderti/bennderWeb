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
                        
			<!-- header-bottom-area end -->         
			<!-- main-menu-area end -->
			<!-- mobile-menu-area start -->
			<jsp:include page="/WEB-INF/jsp/template-e-comerce/mainMenuAreaVisible.jsp"/>
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
                        <li><a href="#">Cargador de imagenes para beneficios</a></li>
                        <!--<li class="active">Login</li>-->
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- heading-banner end -->
    <!-- my-account-area start -->
    
    
    <div class="my-account-area">
        <div class="container">
            <div class="row">                
                <div class="col-lg-4 col-lg-offset-4"> 
                    <div class="input-group">
                            <select id="select-proveedores"  class="form-control" >
                                <option value="-1">Seleccione proveedor...</option>
                                <c:if test="${not empty proveedores}">
                                    <c:forEach items="${proveedores}" var="p">
                                        <option value="${p.idProveedor}">${p.nombre}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                    </div>
                    <br>
                    <div class="input-group">
                            <select id="select-categorias"  class="form-control" >
                                <option value="-1">Seleccione categoria...</option>
                            </select>
                    </div>
                    <br>
                    <div class="input-group">
                            <select id="select-sub-categorias"  class="form-control">
                                <option value="-1">Seleccione sub categoria...</option>
                            </select>
                    </div>
                    <br>
                    <div class="input-group">
                            <select id="select-beneficio"  class="form-control">
                                <option value="-1">Seleccione beneficio</option>
                            </select>
                    </div>    
                    <br>  
                </div>                 
                <div class="col-lg-4 col-lg-offset-4 images-upload" style="display: none"> 
                    <h3>Seleccione imagenes a subir</h3>
                    <form:form method="post" action="uploadImagesBeneficios.html" modelAttribute="uploadForm" enctype="multipart/form-data">
                        <p>Selecciona imagenes y presiona <strong>+ Imagen</strong> para agrear mas imagenes. Cabe mencionar que las imagenes a cargar actualizarán las anteriores.</p>

                        <input id="addFile" type="button" value="+ Imagen" class="btn btn-primary" onclick="Cargador.addFile();"/>
                            <table id="fileTable">
                                    <tr>
                                        <td>
                                            <div class="input-group">
                                                <span class="input-group-addon beautiful">
                                                    <input type="radio" name="optradio" onclick="Cargador.onSelectPrincipal(0)" > Principal
                                                </span> 
                                                <input name="files[0]" type="file" class="form-control">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="input-group">
                                                <span class="input-group-addon beautiful">
                                                    <input type="radio" name="optradio" onclick="Cargador.onSelectPrincipal(1)"> Principal
                                                </span> 
                                                <input name="files[1]" type="file" class="form-control">
                                            </div>
                                        </td>
                                    </tr>
                            </table>
                        <br/><input id="btn-upload-images-submit" type="submit" value="" style="display: none;"/>
                        <input type="hidden" name="idBeneficio" id="input-idBeneficio"/>
                        <input type="hidden" name="indexPrincipal" id="input-indexPrincipal"/>
                        <input id="btn-upload-images" type="button" value="Subir imagenes" class="btn btn-primary" onclick="Cargador.uploadImagesBeneficios();"/>                        
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    
    
    <!-- my-account-area end -->
    <!-- footer start -->
    <!-- footer end -->
    <!-- Color Variations -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/colorSchemeSelect.jsp"/>
       
    <!-- all js here -->
    <!-- jquery latest version -->
    <jsp:include page="/WEB-INF/jsp/template-e-comerce/jsTemplate.jsp"/>
    <!--Js Login (dejar versión *.min.js ofuscada-->
    
    <!--Modal -->
    <jsp:include page="/WEB-INF/jsp/utils/modal.jsp">     
        <jsp:param name="btnAceptar" value="Aceptar"/>
        <jsp:param name="btnCancelar" value="Cancelar"/>
    </jsp:include>
    <!--Modal-->    
    <!-- Loading -->
    <jsp:include page="/WEB-INF/jsp/utils/loading.jsp"/>
    <!-- Loading -->
    <script type="text/javascript" src="<c:url value="/resources/js/cargador/cargador.js"/>?v=<%=Calendar.getInstance().getTimeInMillis()%>"></script>
    
</body>
</html>
