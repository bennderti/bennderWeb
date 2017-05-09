<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- latest-blog-area start -->
<div class="latest-blog-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h2>
                        Vistos o más Visitados
                    </h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="latest-blog-curosel">
                <c:if test="${not empty visitados}"> 
                    <c:forEach items="${visitados}" var="visto">
                        <!-- single-latest-blog start -->
                        <div class="col-lg-12">
                            <div class="single-latest-blog">
                                <div class="latest-blog-img">
                                    <a href="<c:url value="/detalleBeneficio/${visto.idBeneficio}.html"/>">
                                        <img src='<c:url value="${visto.imagenesBeneficio[0].urlImagen}"/>' alt="" />
                                    </a>
                                </div>
                                <div class="latest-blog-content">
                                    <h3>                                        
                                        <a href="<c:url value="/detalleBeneficio/${visto.idBeneficio}.html"/>">${visto.titulo}</a>
                                    </h3>
                                    <h4>${visto.nombreProveedor}</h4> 
                                    <div class="meta">
                                        <span class="post-category">en <a href="<c:url value="/categoria/${visto.nombreCategoria}.html"/>">${visto.nombreCategoria}</a></span> <span class="meta-border">
                                            |</span> <span class="time"><i class="fa fa-clock-o"></i>${visto.fechaExpiracion}</span>
                                    </div>
                                    <p>
                                        ${visto.descripcion}
                                    </p>
                                </div>
                            </div>
                        </div>
                        <!-- single-latest-blog end -->
                    </c:forEach>
                </c:if>               
            </div>
        </div>
    </div>
</div>