<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 07-05-2017
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pro-rating">
    <c:choose>
        <c:when test="${param.calificacion == 1}">
            <i class="fa fa-star"></i>
        </c:when>
        <c:when test="${param.calificacion == 2}">
            <i class="fa fa-star"></i><i class="fa fa-star"></i>
        </c:when>
        <c:when test="${param.calificacion == 3}">
            <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
        </c:when>
        <c:when test="${param.calificacion == 4}">
            <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
        </c:when>
        <c:when test="${param.calificacion == 5}">
            <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
        </c:when>
    </c:choose>
</div>
