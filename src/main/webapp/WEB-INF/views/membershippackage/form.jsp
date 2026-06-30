<%-- 
    Document   : form
    Created on : Jun 28, 2026, 10:11:39 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h2>Package Detail</h2>

<div class="card">

    <div class="card-body">

        <h3>${pkg.packageName}</h3>

        <p>${pkg.description}</p>

        <p><b>Duration:</b> ${pkg.durationMonths} months</p>

        <h4 class="text-success">
            <fmt:formatNumber value="${pkg.price}" pattern="#,###"/> VNĐ
        </h4>

        <button class="btn btn-primary">
            Confirm Register
        </button>

    </div>

</div>
