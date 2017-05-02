<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 29-03-2017
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- single-product-area start -->
<fmt:setLocale value="es_CL" scope="session"/>
<div class="single-product-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12">
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="single-pro-tab-content">
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <c:if test="${not empty beneficio.imagenesBeneficio}">
                                    <div role="tabpanel" class="tab-pane active" id="0">
                                        <a href="#">
                                            <%--<img src="data:image/jpg;base64, ${beneficio.imagenesBeneficio[0].imagenBase64}" alt="" />--%>
                                            <img src="${beneficio.imagenesBeneficio[0].urlImagen}" alt="" />
                                        </a>
                                    </div>
                                    <c:forEach items="${beneficio.imagenesBeneficio}" var="imagen" begin="1" varStatus="loop">
                                        <div role="tabpanel" class="tab-pane" id="${loop.index}">
                                            <a href="#">
                                                <%--<img src="data:image/jpg;base64, ${imagen.imagenBase64}" alt="" />--%>
                                                <img src="${imagen.urlImagen}" alt="" />
                                            </a>
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                            <!-- Nav tabs -->
                     
                            <ul class="single-product-tab" role="tablist">
                                <li role="presentation" class="active">
                                    <a href="#0" aria-controls="0" role="tab" data-toggle="tab">
                                    <%--<img src="data:image/jpg;base64, ${beneficio.imagenesBeneficio[0].imagenBase64}" alt="" />--%>
                                    <img src="${beneficio.imagenesBeneficio[0].urlImagen}" alt="" />
                                    </a>
                                </li>
                                <c:forEach items="${beneficio.imagenesBeneficio}" var="imagen" begin="1" varStatus="loop">
                                    <li role="presentation">
                                        <a href="#${loop.index}" aria-controls="${loop.index}" role="tab" data-toggle="tab">
                                            <%--<img src="data:image/jpg;base64, ${imagen.imagenBase64}" alt="" />--%>
                                            <img src="${imagen.urlImagen}" alt="" />
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-6 col-xs-12 shop-list">
                        <div class="product-info product-single">
                            <h3>${beneficio.titulo}</h3>

                            <div class="pro-rating">
                                <c:choose>
                                    <c:when test="${beneficio.calificacion == 1}">
                                        <i class="fa fa-star"></i>
                                    </c:when>
                                    <c:when test="${beneficio.calificacion == 2}">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </c:when>
                                    <c:when test="${beneficio.calificacion == 3}">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </c:when>
                                    <c:when test="${beneficio.calificacion == 4}">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </c:when>
                                    <c:when test="${beneficio.calificacion == 5}">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </c:when>
                                </c:choose>
                                    <%--<p><span class="stars">${beneficio.calificacion}</span></p>--%>
                            </div>
                            <c:if test="${beneficio.tipoBeneficio.idTipoBeneficio == 1}">
                                <div class="pro-price">
                                    <span class="normal">${beneficio.porcentajeDescuento}%</span>
                                </div>
                            </c:if>
                            <c:if test="${beneficio.tipoBeneficio.idTipoBeneficio == 2}">
                                <div class="pro-price">
                                    <span class="normal"><fmt:formatNumber value="${beneficio.precioOferta}" type="currency" currencySymbol="$"/></span> <span class="old"><fmt:formatNumber value="${beneficio.precioNormal}" type="currency" currencySymbol="$"/></span>
                                </div>
                            </c:if>
                            <hr class="page-divider">
                            <div class="product-desc">
                                <p>
                                    ${beneficio.nombreProveedor}
                                    </p>
                            </div>
                            <hr class="page-divider">
                            <div class="product-action">
                                <div class="pro-button-top">
                                    <a href="#" onclick="BeneficioBennder.getBeneficio(${beneficio.idBeneficio});">Obtener Beneficio</a>
                                </div>
                                <div class="pro-button-bottom">
                                    <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>
                                </a><a href="#"><i class="fa fa-search-plus"></i></a>
                                </div>
                            </div>
                            <hr class="page-divider small">
                            <table>
                                <tbody>
                                <tr>
                                    <td class="title">Categoria:</td>
                                    <td>${beneficio.nombreCategoria}</td>
                                </tr>
                                <tr>
                                    <td class="title">Stock:</td>
                                    <td>${beneficio.stock} ${beneficio.stock == 1 ? 'unidad' : 'unidades'}</td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="widget-icon">
                                <i class="fa fa-clock-o"></i> Termina el dia <fmt:formatDate value="${beneficio.fechaExpiracion}" pattern="dd MMMM yyyy" />
                            </div>
                            <%--<div class="widget-icon">--%>
                                <%--<a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i>--%>
                            <%--</a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-google-plus">--%>
                            <%--</i></a>--%>
                            <%--</div>--%>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="product-tabs">
                            <div>
                                <!-- Nav tabs -->
                                <ul class="pro-details-tab" role="tablist">
                                    <li role="presentation" class="active"><a href="#tab-desc" aria-controls="tab-desc"
                                                                              role="tab" data-toggle="tab">Descripcion</a></li>
                                    <li role="presentation"><a href="#tab-condiciones" aria-controls="tab-condiciones" role="tab"
                                                               data-toggle="tab">Condiciones</a></li>
                                </ul>
                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="tab-desc">
                                        <div class="product-tab-desc">
                                            <p>
                                                ${beneficio.descripcion}
                                            </p>
                                        </div>
                                    </div>
                                    <c:if test="${not empty beneficio.condiciones}">
                                        <div role="tabpanel" class="tab-pane" id="tab-condiciones">
                                            <div class="product-tab-desc">
                                                <h3>Condiciones sobre esta promocion</h3>
                                                <ul>
                                                    <c:forEach items="${beneficio.condiciones}" var="condicion">
                                                        <li>${condicion}</li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </c:if>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
                                            
<script type="text/javascript" src="<c:url value="/resources/js/beneficio/beneficio.js"/>?v=<%=Calendar.getInstance().getTimeInMillis()%>"></script>

<!-- single-product-area end -->
