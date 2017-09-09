<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 02-03-2017
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <div class="list lista-a">                        
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="profile">
                <div class="row shop-list lista-b">                            
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
      <jsp:include page="/WEB-INF/jsp/utils/modal.jsp">     
        <jsp:param name="btnAceptar" value="Aceptar"/>
        <jsp:param name="btnCancelar" value="Cancelar"/>
    </jsp:include>
    <script type="text/javascript" src="<c:url value="/resources/js/beneficio/paginadorBeneficio.js"/>?v=<%=Calendar.getInstance().getTimeInMillis()%>"></script>
        <script type="text/javascript">
            $(function () {     
                PaginadorBeneficio.cargaBeneficios();
            });
        </script>
</div>
<!-- shop-content end -->
