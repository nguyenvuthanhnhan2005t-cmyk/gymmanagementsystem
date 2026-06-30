<%-- 
    Document   : list
    Created on : Jun 13, 2026, 10:35:21 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2 class="fw-bold">
            🏋 Equipment Management
        </h2>

        <a href="${pageContext.request.contextPath}/equipment/add"
           class="btn btn-success">

            ➕ Add Equipment

        </a>

    </div>

    <div class="row mb-3">

        <div class="col-md-6">

            <form action="${pageContext.request.contextPath}/equipment/search"
                  method="get"
                  class="d-flex">

                <input
                    type="text"
                    name="keyword"
                    class="form-control me-2"
                    placeholder="Search by Equipment Name, Category, Status or Location..."
                    value="${keyword}">

                <button
                    type="submit"
                    class="btn btn-primary">

                    🔍 Search

                </button>

                <a href="${pageContext.request.contextPath}/equipment"
                   class="btn btn-secondary ms-2">

                    Reset

                </a>

            </form>

        </div>

    </div>

    <div class="card shadow">

        <div class="card-body">

            <table class="table table-bordered table-hover">

                <thead class="table-dark">

                    <tr>

                        <th>ID</th>

                        <th>Name</th>

                        <th>Category</th>

                        <th>Quantity</th>

                        <th>Purchase Date</th>

                        <th>Status</th>

                        <th>Location</th>

                        <th width="180">
                            Action
                        </th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${equipments}" var="e">

                        <tr>

                            <td>
                                ${e.equipmentID}
                            </td>

                            <td>
                                ${e.equipmentName}
                            </td>

                            <td>
                                ${e.category}
                            </td>

                            <td>
                                ${e.quantity}
                            </td>

                            <td>
                                ${e.purchaseDate}
                            </td>

                            <td>
                                ${e.status}
                            </td>

                            <td>
                                ${e.location}
                            </td>

                            <td>

                                <a href="${pageContext.request.contextPath}/equipment/edit/${e.equipmentID}"
                                   class="btn btn-warning btn-sm">

                                    Edit

                                </a>

                                <a href="${pageContext.request.contextPath}/equipment/delete/${e.equipmentID}"
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('Delete this equipment?')">

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
