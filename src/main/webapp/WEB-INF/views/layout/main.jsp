<%-- 
    Document   : main
    Created on : Jun 10, 2026, 11:40:56 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Gym Management System</title>

<style>

body{

    background:
        linear-gradient(
            135deg,
            #0f172a,
            #1e293b
        );

    min-height:100vh;

    margin:0;
}

.main-content{

    padding:30px;
}

.content-card{

    background:white;

    border-radius:20px;

    padding:25px;

    box-shadow:
        0 0 25px rgba(0,0,0,.25);
}

</style>

</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4 main-content">

    <div class="content-card">

        <jsp:include page="${body}"/>

    </div>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
