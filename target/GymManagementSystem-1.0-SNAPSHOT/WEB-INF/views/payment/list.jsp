<%-- 
    Document   : list
    Created on : Jun 14, 2026, 8:27:37 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2 class="fw-bold text-success">
            💳 Payment Management
        </h2>

        <a href="${pageContext.request.contextPath}/payment/add"
           class="btn btn-success">

            ➕ Add Payment

        </a>

    </div>

    <div class="row mb-3">

        <div class="col-md-6">

            <form action="${pageContext.request.contextPath}/payment/search"
                  method="get"
                  class="d-flex">

                <input
                    type="text"
                    name="keyword"
                    class="form-control me-2"
                    placeholder="Search by Member ID, Payment Method or Status..."
                    value="${keyword}">

                <button
                    type="submit"
                    class="btn btn-primary">

                    🔍 Search

                </button>

                <a href="${pageContext.request.contextPath}/payment"
                   class="btn btn-secondary ms-2">

                    Reset

                </a>

            </form>

        </div>

    </div>

    <div class="card shadow">

        <div class="card-body">

            <table class="table table-bordered table-hover">

                <thead class="table-success">

                    <tr>

                        <th>ID</th>

                        <th>Member ID</th>

                        <th>Amount</th>

                        <th>Payment Date</th>

                        <th>Method</th>

                        <th>Status</th>

                        <th width="180">
                            Action
                        </th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${payments}" var="p">

                        <tr>

                            <td>
                                ${p.paymentID}
                            </td>

                            <td>
                                ${p.memberID}
                            </td>

                            <td class="text-success fw-bold">

                                <fmt:formatNumber
                                    value="${p.amount}"
                                    pattern="#,###"/>

                                VNĐ
                            </td>

                            <td>
                                ${p.paymentDate}
                            </td>

                            <td>
                                ${p.paymentMethod}
                            </td>

                            <td>

                                <c:choose>

                                    <c:when test="${p.status == 'Paid'}">

                                        <span class="badge bg-success">
                                            Paid
                                        </span>

                                    </c:when>

                                    <c:when test="${p.status == 'Pending'}">

                                        <span class="badge bg-warning text-dark">
                                            Pending
                                        </span>

                                    </c:when>

                                    <c:otherwise>

                                        <span class="badge bg-danger">
                                            Failed
                                        </span>

                                    </c:otherwise>

                                </c:choose>

                            </td>

                            <td>

                                <a href="${pageContext.request.contextPath}/payment/edit/${p.paymentID}"
                                   class="btn btn-warning btn-sm">

                                    Edit

                                </a>

                                <a href="${pageContext.request.contextPath}/payment/delete/${p.paymentID}"
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('Delete this payment?')">

                                    Delete

                                </a>

                            </td>

                        </tr>

                    </c:forEach>

                </tbody>

            </table>

        </div>

    </div>

</div>
