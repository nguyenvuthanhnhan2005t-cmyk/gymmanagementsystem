<%-- 
    Document   : list
    Created on : Jun 14, 2026, 3:38:19 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2 class="fw-bold text-primary">
            🏋 Trainer Management
        </h2>

        <a href="${pageContext.request.contextPath}/trainers/add"
           class="btn btn-success">

            ➕ Add Trainer

        </a>

    </div>

    <div class="row mb-3">

        <div class="col-md-6">

            <form action="${pageContext.request.contextPath}/trainers/search"
                  method="get"
                  class="d-flex">

                <input
                    type="text"
                    name="keyword"
                    class="form-control me-2"
                    placeholder="Search by Name, Email or Phone..."
                    value="${keyword}">

                <button
                    type="submit"
                    class="btn btn-primary">

                    🔍 Search

                </button>

                <a href="${pageContext.request.contextPath}/trainers"
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

                        <th>Full Name</th>

                        <th>Phone</th>

                        <th>Email</th>

                        <th>Gender</th>

                        <th>Specialty</th>

                        <th>Experience</th>

                        <th>Salary</th>

                        <th>Status</th>

                        <th width="180">
                            Action
                        </th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${trainers}" var="t">

                        <tr>

                            <td>${t.trainerID}</td>

                            <td>${t.fullName}</td>

                            <td>${t.phone}</td>

                            <td>${t.email}</td>

                            <td>${t.gender}</td>

                            <td>${t.specialty}</td>

                            <td>
                                ${t.experienceYears} years
                            </td>

                            <td>
                                <fmt:formatNumber
                                    value="${t.salary}"
                                    pattern="#,###"/> VNĐ
                            </td>

                            <td>

                                <c:choose>

                                    <c:when test="${t.status == 'Active'}">

                                        <span class="badge bg-success">
                                            Active
                                        </span>

                                    </c:when>

                                    <c:otherwise>

                                        <span class="badge bg-danger">
                                            Inactive
                                        </span>

                                    </c:otherwise>

                                </c:choose>

                            </td>

                            <td>

                                <a href="${pageContext.request.contextPath}/trainers/edit/${t.trainerID}"
                                   class="btn btn-warning btn-sm">

                                    Edit

                                </a>

                                <a href="${pageContext.request.contextPath}/trainers/delete/${t.trainerID}"
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('Delete this trainer?')">

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
