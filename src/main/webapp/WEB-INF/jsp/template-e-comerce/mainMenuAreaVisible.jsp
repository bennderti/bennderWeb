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
                                    <span>
                                        <a class="mega-title" href="#">WOMEN CLOTH </a>
                                        <a href="shop.html">casual shirt</a>
                                        <a href="shop.html">rikke t-shirt</a>
                                        <a href="shop.html">mia top </a>
                                        <a href="shop.html">muscle tee </a>
                                    </span>
                                    <span>
                                        <a class="mega-title" href="#">MEN CLOTH </a>
                                        <a href="shop.html">casual shirt</a>
                                        <a href="shop.html">rikke t-shirt</a>
                                        <a href="shop.html">mia top </a>
                                        <a href="shop.html">muscle tee </a>
                                    </span>
                                    <span>
                                        <a class="mega-title" href="#">WOMEN JEWELRY </a>
                                        <a href="shop.html">necklace </a>
                                        <a href="shop.html">chunky short striped </a>
                                        <a href="shop.html">samhar cuff</a>
                                        <a href="shop.html">nail set </a>
                                    </span>
                                    <span class="mega-menu-img">
                                        <a href="shop.html"><img alt="" src='<c:url value="/resources/img/5_hover_2.jpg"/>'></a>
                                    </span>
                                </div>										
                            </li>
                            <li><a href="shop.html">Footwear </a></li>
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