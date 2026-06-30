<%-- 
    Document   : list
    Created on : Jun 13, 2026, 8:59:41 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2 class="fw-bold">
            📅 Attendance Management
        </h2>

        <a href="${pageContext.request.contextPath}/attendance/add"
           class="btn btn-success">

            ➕ Add Attendance

        </a>

    </div>

    <div class="row mb-3">

        <div class="col-md-6">

            <form action="${pageContext.request.contextPath}/attendance/search"
                  method="get"
                  class="d-flex">

                <input
                    type="text"
                    name="keyword"
                    class="form-control me-2"
                    placeholder="Search by Member ID, Date or Note..."
                    value="${keyword}">

                <button
                    type="submit"
                    class="btn btn-primary">

                    🔍 Search

                </button>

                <a href="${pageContext.request.contextPath}/attendance"
                   class="btn btn-secondary ms-2">

                    Reset

                </a>

            </form>

        </div>

    </div>

    <div class="card shadow">

        <div class="card-body">

            <table class="table table-hover table-bordered">

                <thead class="table-dark">

                    <tr>

                        <th>ID</th>

                        <th>Member ID</th>

                        <th>Date</th>

                        <th>Check In</th>

                        <th>Check Out</th>

                        <th>Note</th>

                        <th width="180">
                            Action
                        </th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${attendanceList}" var="a">

                        <tr>

                            <td>
                                ${a.attendanceID}
                            </td>

                            <td>
                                ${a.memberID}
                            </td>

                            <td>
                                ${a.attendanceDate}
                            </td>

                            <td>
                                ${a.checkInTime}
                            </td>

                            <td>
                                ${a.checkOutTime}
                            </td>

                            <td>
                                ${a.note}
                            </td>

                            <td>

                                <a href="${pageContext.request.contextPath}/attendance/edit/${a.attendanceID}"
                                   class="btn btn-warning btn-sm">

                                    Edit

                                </a>

                                <a href="${pageContext.request.contextPath}/attendance/delete/${a.attendanceID}"
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('Delete this record?')">

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