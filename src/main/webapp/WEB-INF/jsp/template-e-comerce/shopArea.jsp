<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 02-03-2017
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- shop-area start -->
<div class="shop-area">
    <div class="container">
        <div class="row">

            <jsp:include page="shopLeftSidebar.jsp">
                <jsp:param name="nombreCategoria" value="${nombreCategoria}"/>
            </jsp:include>
            <jsp:include page="shopContent.jsp">
                <jsp:param name="beneficios" value="${beneficios}"/>
            </jsp:include>

        </div>
    </div>
</div>
<!-- shop-area end -->
<jsp:include page="/WEB-INF/jsp/template-e-comerce/jsTemplate.jsp"/>
<jsp:include page="/WEB-INF/jsp/utils/loading.jsp"/>
<%--<script type="text/javascript" src="<c:url value="/resources/js/vendor/mixitup.min.js"/>"></script>--%>
<script type="text/javascript" src="<c:url value="/resources/js/beneficio/categoria.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/modal/bennder-loading.js"/>"></script>