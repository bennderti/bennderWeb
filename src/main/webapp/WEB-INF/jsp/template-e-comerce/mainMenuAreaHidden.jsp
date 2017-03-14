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
                            <li><a href="index.html">home</a>
                                <ul>
                                    <li><a href="index.html">Homepage Version 1</a></li>
                                    <li><a href="index-2.html">Homepage Version 2</a></li>
                                    <li><a href="index-3.html">Homepage Version 3</a></li>													
                                </ul>
                            </li>
                            <li><a href="about.html">About</a></li>

                            <li><a href="index.html">Shop</a>
                                <ul>
                                    <li><a href="shop.html">Shop Sidebar Left</a></li>
                                    <li><a href="shop-right.html">Shop Sidebar Right</a></li>
                                    <li><a href="shop-list.html">Shop List View</a></li>
                                    <li><a href="single-product.html">single-product</a></li>
                                </ul>
                            </li>
                            <li><a href="blog.html">Blog</a>
                                <ul>
                                    <li><a href="single-blog.html">single-blog</a></li>
                                    <li><a href="single-blog-video.html">single-blog-video</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Clothing</a>
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
                            <li><a href="shop.html">Footwear </a></li>
                            <li><a href="shop.html">Bags </a></li>
                            <li><a href="shop.html">Shoes </a></li>
                            <li><a href="#">pages</a>
                                <ul>
                                    <li><a href="about.html">about us</a></li>
                                    <li><a href="cart.html">shopping cart</a></li>
                                    <li><a href="checkout.html">checkout</a></li>
                                    <li><a href="wishlist.html">wishlist</a></li>
                                    <li><a href="login.html">login</a></li>												
                                    <li><a href="contact.html">contact us</a></li>
                                </ul>											
                            </li>
                            <li><a href="contact.html">contact</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div> 