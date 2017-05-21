<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- mobile-menu-area start -->
<div class="mobile-menu-area visible-xs">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="mobile-menu">
                    <nav id="dropdown">
                        <ul>
                            <li><a href="<c:url value="/home.html"/>">home</a>
                            </li>

                            <li><a href="#">Categorias</a>
                                <div class="mega-menu">
                                    <c:if test="${not empty sessionScope.categorias}">
                                        <c:forEach items="${sessionScope.categorias}" var="categoria">
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