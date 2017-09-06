<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 02-03-2017
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- left-sidebar start -->
<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
    <!-- widget-categories start -->
    <aside class="widget widget-categories">
        <h3 class="sidebar-title">${nombreCategoria}</h3>
        <input type="hidden" id="inputCategoriaSeleccionada" value="${categoriaSeleccionada}">
        <ul class="sidebar-menu">
            <c:if test="${not empty categoriasRelacionadas}">
                <c:forEach items="${categoriasRelacionadas}" var="subCategoria">
                    <c:choose >
                        <c:when test="${categoriaSeleccionada eq subCategoria.nombre}">
                            <li class="active"><a href="<c:url value="/categoria/${subCategoria.nombre}.html"/>">${subCategoria.nombre} <span class="count">(${subCategoria.cantidadBeneficios})</span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/categoria/${subCategoria.nombre}.html"/>">${subCategoria.nombre} <span class="count">(${subCategoria.cantidadBeneficios})</span></a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:if>
        </ul>
    </aside>
    <!-- widget-categories end -->
    <!-- shop-filter start -->
    <aside class="widget shop-filter">
        <h3 class="sidebar-title">Precio</h3>
        <div class="info_widget">
            <div class="price_filter">
                <div id="slider-range"></div>
                <div class="price_slider_amount">
                    <input type="text" id="amount" name="price"  placeholder="Agregue Precio" />
                    <input type="submit" id="btn-filtrar-precio"  value="Filtrar"/>
                </div>
            </div>
        </div>
    </aside>
    <aside class="widget shop-filter">
        <h3 class="sidebar-title">Porcentaje Descuento</h3>
        <div class="info_widget">
            <div class="price_filter">
                <div id="slider-range-descuento"></div>
                <div class="price_slider_amount">
                    <input type="text" id="amount-descuento" name="price"  placeholder="Agregue Precio" />
                    <input type="submit" id="btn-filtrar-descuento"  value="Filtrar"/>
                </div>
            </div>
        </div>
    </aside>
    <!-- shop-filter end -->
    <!-- filter-by start -->
    <aside class="widget filter-by">
        <h3 class="sidebar-title">Filtrar por</h3>

        <h5><b>Proveedor</b></h5>
        <ul id="filtrosProveedor" class="sidebar-menu">
            <li><a href="#" data-filter="all">Todos</a><span class="count">(4)</span></li>
            <c:forEach items="${filtroProveedores}" var="proveedor">
                <li><a href="#" data-filter="${proveedor}">${proveedor}</a><span class="count">(6)</span></li>
            </c:forEach>
        </ul>

        <h5><b>Calificacion</b></h5>
        <ul id="filtrosRanking" class="sidebar-menu">
            <%--<li><a href="#" data-filter="all">Todos</a></li>--%>
            <li><a href="#" data-ranking="1"><i class="fa fa-star"></i></a></li>
            <li><a href="#" data-ranking="2"><i class="fa fa-star"></i><i class="fa fa-star"></i></a></li>
            <li><a href="#" data-ranking="3"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></a></li>
            <li><a href="#" data-ranking="4"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></a></li>
            <li><a href="#" data-ranking="5"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></a></li>
        </ul>

    </aside>
    <!-- filter-by end -->
</div>
<!-- left-sidebar end -->
