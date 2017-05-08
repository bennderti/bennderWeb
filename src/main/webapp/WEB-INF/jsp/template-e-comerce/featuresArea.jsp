<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- features-area start -->
    <div class="features-area pad-60">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>
                            Promociones Destacadas</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="product-tab">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="home">
                                <div class="row">
                                    <div class="product-curosel">
                                        <c:if test="${not empty destacados}"> 
                                            <c:forEach items="${destacados}" var="destacado">
                                                <!-- single-product start -->
                                                <div class="col-lg-12">
                                                    <div class="single-product">
                                                        <div class="product-img">
                                                            <a href="single-product.html">
                                                                <img class="primary-img" src='<c:url value="${destacado.imagenesBeneficio[0].urlImagen}"/>' alt="" />
                                                                <img class="secondary-img" src='<c:url value="${destacado.imagenesBeneficio[1].urlImagen}"/>'  alt="" />
                                                            </a><!--span class="sale">sale</span-->
                                                            <!--div class="product-action">
                                                                <div class="pro-button-top">
                                                                    <a href="#">add to cart</a>
                                                                </div>
                                                                <div class="pro-button-bottom">
                                                                    <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>
                                                                    </a><a href="#"><i class="fa fa-search-plus"></i></a>
                                                                </div>
                                                            </div-->
                                                        </div>
                                                        <div class="product-info">
                                                            <h3>
                                                                <a href="<c:url value="/detalleBeneficio/${destacado.idBeneficio}.html"/>">${destacado.titulo}</a>
                                                            </h3>
                                                            <h4>${destacado.nombreProveedor}</h4>                                                            
                                                            <c:if test="${destacado.tipoBeneficio.idTipoBeneficio == 1}">
                                                                <div class="pro-price">
                                                                    <span class="normal">${destacado.porcentajeDescuento}%</span>
                                                                </div>
                                                            </c:if>
                                                            <c:if test="${destacado.tipoBeneficio.idTipoBeneficio == 2}">
                                                                <div class="pro-price">
                                                                    <fmt:setLocale value="es_CL" scope="session"/>
                                                                    <span class="normal">
                                                                        <fmt:formatNumber value="${destacado.precioOferta}" type="currency" currencySymbol="$"/>
                                                                    </span> 
                                                                    <span class="old">
                                                                        <fmt:formatNumber value="${destacado.precioNormal}" type="currency" currencySymbol="$"/>
                                                                    </span>
                                                                </div>
                                                            </c:if>
                                                            <div class="pro-rating">
                                                                <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                                                    class="fa fa-star"></i><i class="fa fa-star"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- single-product end -->
                                            </c:forEach>    
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