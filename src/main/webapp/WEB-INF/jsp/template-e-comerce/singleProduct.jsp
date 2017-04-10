<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 29-03-2017
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- single-product-area start -->
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
                                            <img src="${beneficio.imagenesBeneficio[0].path}" alt="" />
                                        </a>
                                    </div>
                                    <c:forEach items="${beneficio.imagenesBeneficio}" var="imagen" begin="1" varStatus="loop">
                                        <div role="tabpanel" class="tab-pane" id="${loop.index}">
                                            <a href="#">
                                                <%--<img src="data:image/jpg;base64, ${imagen.imagenBase64}" alt="" />--%>
                                                <img src="${imagen.path}" alt="" />
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
                                    <img src="${beneficio.imagenesBeneficio[0].path}" alt="" />
                                    </a>
                                </li>
                                <c:forEach items="${beneficio.imagenesBeneficio}" var="imagen" begin="1" varStatus="loop">
                                    <li role="presentation">
                                        <a href="#${loop.index}" aria-controls="${loop.index}" role="tab" data-toggle="tab">
                                            <%--<img src="data:image/jpg;base64, ${imagen.imagenBase64}" alt="" />--%>
                                            <img src="${imagen.path}" alt="" />
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-6 col-xs-12 shop-list">
                        <div class="product-info product-single">
                            <h3><a href="single-product.html">${beneficio.titulo}</a></h3>
                            <h4></h4>

                            <div class="pro-rating">
                                <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                    class="fa fa-star"></i><i class="fa fa-star"></i><a class="reviews" href="#">16 reviews</a>
                                | <a class="add-review" href="#">Add Your Review</a>
                            </div>
                            <c:if test="${beneficio.tipoBeneficio.idTipoBeneficio == 1}">
                                <div class="pro-price">
                                    <span class="normal">${beneficio.porcentajeDescuento}%</span>
                                </div>
                            </c:if>
                            <c:if test="${beneficio.tipoBeneficio.idTipoBeneficio == 2}">
                                <div class="pro-price">
                                    <fmt:setLocale value="es_CL" scope="session"/>
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
                                    <td class="title">
                                        Category:
                                    </td>
                                    <td>
                                        Men Dress
                                    </td>
                                </tr>
                                <tr>
                                    <td class="title">
                                        Product Code:
                                    </td>
                                    <td>
                                        PS08
                                    </td>
                                </tr>
                                <tr>
                                    <td class="title">
                                        Tags:
                                    </td>
                                    <td>
                                        Fashion - clothes - Dress - Men - jean
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="widget-icon">
                                <a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i>
                            </a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-google-plus">
                            </i></a>
                            </div>
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
                                                                              role="tab" data-toggle="tab">Description</a></li>
                                    <li role="presentation"><a href="#page-comments" aria-controls="page-comments" role="tab"
                                                               data-toggle="tab">Reviews (1)</a></li>
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
                                    <div role="tabpanel" class="tab-pane" id="page-comments">
                                        <div class="product-tab-desc">
                                            <div class="product-page-comments">
                                                <h2>
                                                    1 review for Integer consequat ante lectus</h2>
                                                <ul>
                                                    <li>
                                                        <div class="product-comments">
                                                            <img src="img/author.jpg" alt="" />
                                                            <div class="product-comments-content">
                                                                <p>
                                                                    <strong>admin</strong> - <span>March 7, 2015:</span> <span class="pro-comments-rating">
                                                                            <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                                                        class="fa fa-star"></i></span>
                                                                </p>
                                                                <div class="desc">
                                                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla augue nec
                                                                    est tristique auctor. Donec non est at libero vulputate rutrum.
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                                <div class="review-form-wrapper">
                                                    <h3>
                                                        Add a review</h3>
                                                    <form action="#">
                                                        <input type="text" placeholder="your name" />
                                                        <input type="email" placeholder="your email" />
                                                        <div class="your-rating">
                                                            <h5>
                                                                Your Rating</h5>
                                                            <span><a href="#"><i class="fa fa-star"></i></a><a href="#"><i class="fa fa-star"></i>
                                                            </a></span><span><a href="#"><i class="fa fa-star"></i></a><a href="#"><i class="fa fa-star">
                                                            </i></a><a href="#"><i class="fa fa-star"></i></a></span><span><a href="#"><i class="fa fa-star">
                                                            </i></a><a href="#"><i class="fa fa-star"></i></a><a href="#"><i class="fa fa-star">
                                                            </i></a><a href="#"><i class="fa fa-star"></i></a></span><span><a href="#"><i class="fa fa-star">
                                                            </i></a><a href="#"><i class="fa fa-star"></i></a><a href="#"><i class="fa fa-star">
                                                            </i></a><a href="#"><i class="fa fa-star"></i></a><a href="#"><i class="fa fa-star">
                                                            </i></a></span>
                                                        </div>
                                                        <textarea id="product-message" cols="30" rows="10" placeholder="Your Rating"></textarea>
                                                        <input type="submit" value="submit" />
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 col-sm-12">
                        <div class="section-title">
                            <h2>
                                Related Products</h2>
                        </div>
                    </div>
                    <div class="clear">
                    </div>
                    <div class="related-curosel">
                        <!-- single-product start -->
                        <div class="col-lg-12">
                            <div class="single-product">
                                <div class="product-img">
                                    <a href="single-product.html">
                                        <img class="primary-img" src="img/product/9.jpg" alt="" />
                                        <img class="secondary-img" src="img/product/7.jpg" alt="" />
                                    </a>
                                    <div class="product-action">
                                        <div class="pro-button-top">
                                            <a href="#">add to cart</a>
                                        </div>
                                        <div class="pro-button-bottom">
                                            <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>
                                        </a><a href="#"><i class="fa fa-search-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-info">
                                    <h3>
                                        <a href="single-product.html">Feugiat justo lacinia</a></h3>
                                    <div class="pro-price">
                                        <span class="normal">$150</span> <span class="old">$180</span>
                                    </div>
                                    <div class="pro-rating">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- single-product end -->
                        <!-- single-product start -->
                        <div class="col-lg-12">
                            <div class="single-product">
                                <div class="product-img">
                                    <a href="single-product.html">
                                        <img class="primary-img" src="img/product/19.jpg" alt="" />
                                        <img class="secondary-img" src="img/product/20.jpg" alt="" />
                                    </a>
                                    <div class="product-action">
                                        <div class="pro-button-top">
                                            <a href="#">add to cart</a>
                                        </div>
                                        <div class="pro-button-bottom">
                                            <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>
                                        </a><a href="#"><i class="fa fa-search-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-info">
                                    <h3>
                                        <a href="single-product.html">Feugiat justo lacinia</a></h3>
                                    <div class="pro-price">
                                        <span class="normal">$150</span> <span class="old">$180</span>
                                    </div>
                                    <div class="pro-rating">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- single-product end -->
                        <!-- single-product start -->
                        <div class="col-lg-12">
                            <div class="single-product">
                                <div class="product-img">
                                    <a href="single-product.html">
                                        <img class="primary-img" src="img/product/5.jpg" alt="" />
                                        <img class="secondary-img" src="img/product/6.jpg" alt="" />
                                    </a>
                                    <div class="product-action">
                                        <div class="pro-button-top">
                                            <a href="#">add to cart</a>
                                        </div>
                                        <div class="pro-button-bottom">
                                            <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>
                                        </a><a href="#"><i class="fa fa-search-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-info">
                                    <h3>
                                        <a href="single-product.html">Feugiat justo lacinia</a></h3>
                                    <div class="pro-price">
                                        <span class="normal">$150</span> <span class="old">$180</span>
                                    </div>
                                    <div class="pro-rating">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- single-product end -->
                        <!-- single-product start -->
                        <div class="col-lg-12">
                            <div class="single-product">
                                <div class="product-img">
                                    <a href="single-product.html">
                                        <img class="primary-img" src="img/product/25.jpg" alt="" />
                                        <img class="secondary-img" src="img/product/26.jpg" alt="" />
                                    </a>
                                    <div class="product-action">
                                        <div class="pro-button-top">
                                            <a href="#">add to cart</a>
                                        </div>
                                        <div class="pro-button-bottom">
                                            <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>
                                        </a><a href="#"><i class="fa fa-search-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-info">
                                    <h3>
                                        <a href="single-product.html">Feugiat justo lacinia</a></h3>
                                    <div class="pro-price">
                                        <span class="normal">$150</span> <span class="old">$180</span>
                                    </div>
                                    <div class="pro-rating">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- single-product end -->
                        <!-- single-product start -->
                        <div class="col-lg-12">
                            <div class="single-product">
                                <div class="product-img">
                                    <a href="single-product.html">
                                        <img class="primary-img" src="img/product/9.jpg" alt="" />
                                        <img class="secondary-img" src="img/product/10.jpg" alt="" />
                                    </a>
                                    <div class="product-action">
                                        <div class="pro-button-top">
                                            <a href="#">add to cart</a>
                                        </div>
                                        <div class="pro-button-bottom">
                                            <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>
                                        </a><a href="#"><i class="fa fa-search-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-info">
                                    <h3>
                                        <a href="single-product.html">Feugiat justo lacinia</a></h3>
                                    <div class="pro-price">
                                        <span class="normal">$150</span> <span class="old">$180</span>
                                    </div>
                                    <div class="pro-rating">
                                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- single-product end -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
                                            
                                                <script type="text/javascript" src="<c:url value="/resources/js/beneficio/beneficio.js"/>?v=<%=Calendar.getInstance().getTimeInMillis()%>"></script>
    
<!-- single-product-area end -->
