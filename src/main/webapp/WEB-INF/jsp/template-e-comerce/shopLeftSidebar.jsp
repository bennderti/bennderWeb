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
        <ul class="sidebar-menu">
            <li><a href="#">Clothes</a> <span class="count">(14)</span></li>
            <li><a href="#">Men</a> <span class="count">(9)</span></li>
            <li><a href="#">Shoes</a> <span class="count">(2)</span></li>
            <li><a href="#">Sunglasses</a> <span class="count">(2)</span></li>
            <li><a href="#">Women</a> <span class="count">(8)</span></li>
        </ul>
    </aside>
    <!-- widget-categories end -->
    <!-- shop-filter start -->
    <aside class="widget shop-filter">
        <h3 class="sidebar-title">price</h3>
        <div class="info_widget">
            <div class="price_filter">
                <div id="slider-range"></div>
                <div class="price_slider_amount">
                    <input type="text" id="amount" name="price"  placeholder="Add Your Price" />
                    <input type="submit"  value="Filter"/>
                </div>
            </div>
        </div>
    </aside>
    <!-- shop-filter end -->
    <!-- filter-by start -->
    <aside class="widget filter-by">
        <h3 class="sidebar-title">Filter by</h3>
        <h5><b>Color</b></h5>
        <ul class="sidebar-menu">
            <li><a href="#">Red</a> <span class="count">(4)</span></li>
            <li><a href="#">Yellow</a> <span class="count">(6)</span></li>
            <li><a href="#">Blue</a> <span class="count">(1)</span></li>
            <li><a href="#">Green</a> <span class="count">(2)</span></li>
        </ul>
        <h5><b>Size</b></h5>
        <ul class="sidebar-menu">
            <li><a href="#">L</a> <span class="count">(4)</span></li>
            <li><a href="#">MS</a> <span class="count">(6)</span></li>
            <li><a href="#">S</a> <span class="count">(1)</span></li>
            <li><a href="#">XL</a> <span class="count">(2)</span></li>
        </ul>
    </aside>
    <!-- filter-by end -->
    <!-- widget-tags start -->
    <aside class="widget widget-tags">
        <h3 class="sidebar-title">Tags</h3>
        <ul>
            <li><a href="#">asian</a></li>
            <li><a href="#">brown</a></li>
            <li><a href="#">euro</a></li>
            <li><a href="#">fashion</a></li>
            <li><a href="#">france</a></li>
            <li><a href="#">hat</a></li>
            <li><a href="#">travel</a></li>
            <li><a href="#">white</a></li>
            <li><a href="#">t-shirt</a></li>
            <li><a href="#">teen</a></li>
        </ul>
    </aside>
    <!-- widget-tags end -->
    <!-- widget-recent start -->
    <aside class="widget top-product-widget hidden-sm">
        <h3 class="sidebar-title">upcoming product</h3>
        <div class="banner-curosel">
            <div class="banner">
                <a href="#"><img src="img/product/1.jpg" alt="" /></a>
                <div class="upcoming-pro">
                    <div data-countdown="2017/06/01"></div>
                </div>
            </div>
            <div class="banner">
                <a href="#"><img src="img/product/19.jpg" alt="" /></a>
                <div class="upcoming-pro">
                    <div data-countdown="2017/06/01"></div>
                </div>
            </div>
            <div class="banner">
                <a href="#"><img src="img/product/12.jpg" alt="" /></a>
                <div class="upcoming-pro">
                    <div data-countdown="2017/06/01"></div>
                </div>
            </div>
            <div class="banner">
                <a href="#"><img src="img/product/9.jpg" alt="" /></a>
                <div class="upcoming-pro">
                    <div data-countdown="2017/06/01"></div>
                </div>
            </div>
            <div class="banner">
                <a href="#"><img src="img/product/35.jpg" alt="" /></a>
                <div class="upcoming-pro">
                    <div data-countdown="2017/06/01"></div>
                </div>
            </div>
            <div class="banner">
                <a href="#"><img src="img/product/14.jpg" alt="" /></a>
                <div class="upcoming-pro">
                    <div data-countdown="2017/06/01"></div>
                </div>
            </div>
        </div>
    </aside>
    <!-- widget-recent end -->
</div>
<!-- left-sidebar end -->
