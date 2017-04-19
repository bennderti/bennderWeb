<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- main-menu-area start -->
<div class="main-menu-area hidden-xs">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <div class="main-menu">
                    <nav>
                        <ul>
                            <li><a href="home.html">home</a>
<!--                                <ul>
                                    <li><a href="index.html">Homepage Version 1</a></li>
                                    <li><a href="index-2.html">Homepage Version 2</a></li>
                                    <li><a href="index-3.html">Homepage Version 3</a></li>													
                                </ul>-->
                            </li>
                            <li><a href="#">Categorias</a>
                                <div class="mega-menu">
                                    <c:if test="${not empty categorias}">
                                        <c:forEach items="${categorias}" var="categoria">
                                            <span>
                                                <a class="mega-title" href="<c:url value="/categoria/${categoria.nombre}.html"/>">${categoria.nombre}</a>
                                                <c:forEach items="${categoria.subCategorias}" var="subCategoria">
                                                    <a href="<c:url value="/categoria/${subCategoria.nombre}.html"/>">${subCategoria.nombre}</a>
                                                </c:forEach>
                                            </span>
                                        </c:forEach>
                                    </c:if>
                                </div>										
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div> 