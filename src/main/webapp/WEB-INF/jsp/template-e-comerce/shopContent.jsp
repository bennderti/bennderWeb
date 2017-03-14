<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 02-03-2017
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- shop-content start -->
<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
    <div class="shop-content">
        <!-- Nav tabs -->
        <ul class="shop-tab" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                      data-toggle="tab"><i class="fa fa-th"></i></a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">
                <i class="fa fa-list"></i></a></li>
        </ul>
        <div class="show-result">
            <p>
                Showing 1&ndash;12 of 19 results</p>
        </div>
        <div class="toolbar-form">
            <form action="#">
                <div class="tolbar-select">
                    <select>
                        <option value="volvo">Sort by Popularity</option>
                        <option value="saab">Default sorting</option>
                        <option value="mercedes">Sort by average rating</option>
                        <option value="audi">Sort by newness</option>
                        <option value="audi">Sort by Price: low to high</option>
                        <option value="audi">Sort by Price: high to low</option>
                    </select>
                </div>
            </form>
        </div>
        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
                <div class="row">
                    <c:if test="${not empty beneficios}">
                        <c:forEach items="${beneficios}" var="beneficio">
                            <!-- single-product start -->
                            <div class="col-lg-4 col-md-4 col-sm-4">
                                <div class="single-product">
                                    <div class="product-img">
                                        <a href="single-product.html">
                                            <img class="primary-img" src='<c:url value="/resources/img/product/1.jpg"/>' alt="" />
                                            <img class="secondary-img" src='<c:url value="/resources/img/product/2.jpg"/>' alt="" />
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
                                        <h3><a href="single-product.html">${beneficio.titulo}</a></h3>
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
                        </c:forEach>
                    </c:if>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="profile">
                <div class="row shop-list">
                    <!-- single-product start -->
                    <div class="col-md-12">
                        <div class="single-product">
                            <div class="product-img">
                                <a href="single-product.html">
                                    <img class="primary-img" src="img/product/15.jpg" alt="" />
                                    <img class="secondary-img" src="img/product/16.jpg" alt="" />
                                </a>
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
                                <div class="product-desc">
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla augue nec
                                        est tristique auctor. Donec non est at libero vulputate rutrum. Morbi ornare lectus
                                        quis justo gravida semper. Nulla tellus mi, vulputate adipiscing cursus eu, suscipit
                                        id nulla.</p>
                                </div>
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
                        </div>
                    </div>
                    <!-- single-product end -->
                </div>
            </div>
        </div>
    </div>
    <div class="shop-pagination">
        <div class="pagination">
            <ul>
                <li class="active">1</li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#"><i class="fa fa-chevron-right"></i></a></li>
            </ul>
        </div>
    </div>
</div>
<!-- shop-content end -->
