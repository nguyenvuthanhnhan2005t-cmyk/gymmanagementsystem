<%-- 
    Document   : header
    Created on : Jun 10, 2026, 11:40:31 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

    .navbar-gym{
        background:linear-gradient(90deg,#0f172a,#111827,#1e293b);
        border-bottom:3px solid #00e5ff;
        box-shadow:0 0 20px rgba(0,229,255,.35);
        padding:12px 20px;
    }

    .logo-gym{
        color:#00e5ff!important;
        font-size:28px;
        font-weight:900;
        letter-spacing:2px;
        text-transform:uppercase;
        text-decoration:none;
    }

    .logo-gym:hover{
        color:white!important;
    }

    .nav-link{
        color:white!important;
        font-weight:600;
        margin-left:10px;
        transition:.3s;
    }

    .nav-link:hover{
        color:#00e5ff!important;
        transform:translateY(-2px);
    }

    .btn-login{

        background:#00e5ff;
        color:black!important;
        font-weight:bold;
        border-radius:25px;
        padding:8px 18px;
        margin-left:10px;
    }

    .btn-login:hover{

        background:white;
    }

    .system-title{

        color:#94a3b8;
        font-size:12px;
        margin-top:-4px;
    }

    .user-info{

        color:#00e5ff!important;
        font-weight:bold;
    }

    .logout{

        color:#ff6b6b!important;
    }

    .change{

        color:#ffd43b!important;
    }

</style>

<nav class="navbar navbar-expand-lg navbar-gym">

    <div class="container-fluid">

        <a class="navbar-brand logo-gym"
           href="${pageContext.request.contextPath}/">

            🏋 GYM MANAGEMENT

            <div class="system-title">

                Fitness Center Management System

            </div>

        </a>

        <button class="navbar-toggler bg-light"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#gymMenu">

            <span class="navbar-toggler-icon"></span>

        </button>

        <div class="collapse navbar-collapse"
             id="gymMenu">

            <ul class="navbar-nav ms-auto">

                <!-- HOME -->

                <c:if test="${not empty sessionScope.user}">

                    <li class="nav-item">

                        <a class="nav-link"
                           href="${pageContext.request.contextPath}/">

                            🏠 Home

                        </a>

                    </li>

                </c:if>

                <!-- MEMBER -->

                <c:if test="${not empty sessionScope.user}">

                    <li class="nav-item">

                        <a class="nav-link"
                           href="${pageContext.request.contextPath}/members">

                            👥 Members

                        </a>

                    </li>

                </c:if>

                <!-- TRAINER -->

                <c:if test="${sessionScope.user.role=='ADMIN'}">

                    <li class="nav-item">

                        <a class="nav-link"
                           href="${pageContext.request.contextPath}/trainers">

                            🏆 Trainers

                        </a>

                    </li>

                </c:if>

                <!-- EQUIPMENT -->

                <c:if test="${sessionScope.user.role=='ADMIN' || sessionScope.user.role=='STAFF'}">

                    <li class="nav-item">

                        <a class="nav-link"
                           href="${pageContext.request.contextPath}/equipment">

                            🏋 Equipment

                        </a>

                    </li>

                </c:if>

                <!-- ATTENDANCE -->

                <c:if test="${not empty sessionScope.user}">

                    <li class="nav-item">

                        <a class="nav-link"
                           href="${pageContext.request.contextPath}/attendance">

                            📅 Attendance

                        </a>

                    </li>

                </c:if>

                <!-- MEMBERSHIP -->

                <c:if test="${sessionScope.user.role!='TRAINER'}">

                    <li class="nav-item">

                        <a class="nav-link"
                           href="${pageContext.request.contextPath}/memberships">

                            📋 Membership

                        </a>

                    </li>

                </c:if>

                <!-- PAYMENT -->

                <c:if test="${sessionScope.user.role=='ADMIN' || sessionScope.user.role=='STAFF'}">

                    <li class="nav-item">

                        <a class="nav-link"
                           href="${pageContext.request.contextPath}/payment">

                            💳 Payment

                        </a>

                    </li>

                </c:if>

                <!-- PACKAGE -->

                <c:if test="${not empty sessionScope.user}">

                    <li class="nav-item">

                        <a class="nav-link"
                           href="${pageContext.request.contextPath}/packages">

                            📦 Package

                        </a>

                    </li>

                </c:if>

                <!-- LOGIN -->

                <c:if test="${empty sessionScope.user}">

                    <li class="nav-item">

                        <a class="btn btn-login"
                           href="${pageContext.request.contextPath}/login">

                            Login

                        </a>

                    </li>

                </c:if>

                <!-- USER -->

                <c:if test="${not empty sessionScope.user}">

                    <li class="nav-item">

                        <span class="nav-link user-info">

                            👤 ${sessionScope.user.fullName}
                            (${sessionScope.user.role})

                        </span>

                    </li>

                    <li class="nav-item">

                        <a class="nav-link change"
                           href="${pageContext.request.contextPath}/change-password">

                            🔑 Change Password

                        </a>

                    </li>

                    <li class="nav-item">

                        <a class="nav-link logout"
                           href="${pageContext.request.contextPath}/logout">

                            🚪 Logout

                        </a>

                    </li>

                </c:if>

            </ul>

        </div>

    </div>

</nav>