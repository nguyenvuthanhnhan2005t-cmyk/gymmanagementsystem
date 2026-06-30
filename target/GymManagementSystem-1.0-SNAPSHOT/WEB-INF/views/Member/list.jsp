<%-- 
    Document   : list
    Created on : Jun 10, 2026, 11:41:16 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">

    <h2>Member Management</h2>

    <hr>

    <a href="${pageContext.request.contextPath}/members/add"
       class="btn btn-success">
        Add Member
    </a>

    <br><br>

    <div class="row mb-3">

        <div class="col-md-6">

            <form action="${pageContext.request.contextPath}/members/search"
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

                <a href="${pageContext.request.contextPath}/members"
                   class="btn btn-secondary ms-2">

                    Reset

                </a>

            </form>

        </div>

    </div>

    <table class="table table-bordered table-striped">

        <thead>

            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Birth Date</th>
                <th>Membership Type</th>
                <th>Status</th>
                <th>Action</th>
            </tr>

        </thead>

        <tbody>

            <c:forEach items="${members}" var="m">

                <tr>

                    <td>${m.memberID}</td>

                    <td>${m.fullName}</td>

                    <td>${m.phone}</td>

                    <td>${m.email}</td>

                    <td>${m.gender}</td>

                    <td>${m.birthDate}</td>

                    <td>${m.membershipType}</td>

                    <td>${m.status}</td>

                    <td>

                        <a href="${pageContext.request.contextPath}/members/edit/${m.memberID}"
                           class="btn btn-warning btn-sm text-dark fw-bold">

                            Edit

                        </a>

                        <a href="${pageContext.request.contextPath}/members/delete/${m.memberID}"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Delete this member?')">

                            Delete

                        </a>


                    </td>

                </tr>

            </c:forEach>

        </tbody>

    </table>

</div>
