<%-- 
    Document   : list
    Created on : Jun 28, 2026, 10:11:29 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h2>🏋️ Choose Your Membership Plan</h2>

<!-- SEARCH -->
<form action="${pageContext.request.contextPath}/packages/search"
      method="get"
      class="d-flex mb-3">

    <input type="text"
           name="keyword"
           class="form-control me-2"
           placeholder="Search package..."
           value="${keyword}">

    <button class="btn btn-primary">Search</button>

    <a href="${pageContext.request.contextPath}/packages"
       class="btn btn-secondary ms-2">
        Reset
    </a>
</form>

<div class="row">

    <c:forEach items="${packages}" var="p">

        <div class="col-md-4 mb-3">

            <div class="card shadow">

                <div class="card-body">

                    <h4>${p.packageName}</h4>

                    <p>${p.description}</p>

                    <p><b>Duration:</b> ${p.durationMonths} months</p>

                    <h5 class="text-success">
                        <fmt:formatNumber value="${p.price}" pattern="#,###"/> VNĐ
                    </h5>

                    <a href="${pageContext.request.contextPath}/packages/view/${p.packageId}"
                       class="btn btn-success">
                        Register
                    </a>

                </div>

            </div>

        </div>

    </c:forEach>

</div>
