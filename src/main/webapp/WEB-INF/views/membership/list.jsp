<%-- 
    Document   : list
    Created on : Jun 10, 2026, 2:28:35?PM
    Author     : ADMIN
--%>
<%@page contentType="text/html"
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
           prefix="fmt"%>

<h2>Membership List</h2>

<a href="${pageContext.request.contextPath}/memberships/add"
   class="btn btn-success mb-3">
    Add Membership
</a>

<form action="${pageContext.request.contextPath}/memberships/search"
      method="get"
      class="mb-3 d-flex">

    <input type="text"
           name="keyword"
           class="form-control me-2"
           placeholder="Search by Member ID, Package Name, Status..."
           value="${keyword}">

    <button type="submit"
            class="btn btn-primary me-2">
        🔍 Search
    </button>

    <a href="${pageContext.request.contextPath}/memberships"
       class="btn btn-secondary">
        Reset
    </a>

</form>

<table class="table table-bordered">

    <tr>
        <th>ID</th>
        <th>Member ID</th>
        <th>Package</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Price</th>
        <th>Status</th>
    </tr>

    <c:forEach items="${memberships}" var="m">

        <tr>

            <td>${m.membershipID}</td>
            <td>${m.memberID}</td>
            <td>${m.packageName}</td>
            <td>${m.startDate}</td>
            <td>${m.endDate}</td>
            <td class="text-success ">

                <fmt:formatNumber
                    value="${m.price}"
                    pattern="#,###"/>

                VNĐ

            </td>
            <td>${m.status}</td>

        </tr>

    </c:forEach>

</table>