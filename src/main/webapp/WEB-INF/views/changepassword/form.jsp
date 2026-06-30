<%-- 
    Document   : form
    Created on : Jun 29, 2026, 7:03:45 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>🔑 Change Password</h2>

<hr>

<!-- Success -->

<c:if test="${success!=null}">

    <div class="alert alert-success">

        ${success}

    </div>

</c:if>

<!-- Error -->

<c:if test="${error!=null}">

    <div class="alert alert-danger">

        ${error}

    </div>

</c:if>

<form
    action="${pageContext.request.contextPath}/change-password"
    method="post">

    <div class="mb-3">

        <label>

            Old Password

        </label>

        <input
            type="password"
            name="oldPassword"
            class="form-control"
            required>

    </div>

    <div class="mb-3">

        <label>

            New Password

        </label>

        <input
            type="password"
            name="newPassword"
            class="form-control"
            required>

    </div>

    <div class="mb-3">

        <label>

            Confirm Password

        </label>

        <input
            type="password"
            name="confirmPassword"
            class="form-control"
            required>

    </div>

    <button
        class="btn btn-primary">

        Change Password

    </button>

</form>