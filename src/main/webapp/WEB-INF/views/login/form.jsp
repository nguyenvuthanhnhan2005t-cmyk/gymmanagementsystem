<%-- 
    Document   : form
    Created on : Jun 29, 2026, 6:12:05 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">

        <title>Login</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet">

        <style>

            body{

                margin:0;

                height:100vh;

                display:flex;

                justify-content:center;

                align-items:center;

                background:linear-gradient(
                    135deg,
                    #0f172a,
                    #1e293b
                    );

                font-family:Arial, Helvetica, sans-serif;

            }

            .login-card{

                width:420px;

                background:white;

                border-radius:20px;

                padding:35px;

                box-shadow:0 0 35px rgba(0,0,0,.35);

            }

            .logo{

                font-size:34px;

                font-weight:bold;

                color:#00bcd4;

            }

            .subtitle{

                color:gray;

                margin-bottom:25px;

            }

            .form-control{

                border-radius:10px;

                height:45px;

            }

            .btn-login{

                width:100%;

                height:45px;

                border:none;

                border-radius:10px;

                background:#00bcd4;

                color:white;

                font-size:18px;

                font-weight:bold;

                transition:.3s;

            }

            .btn-login:hover{

                background:#0097a7;

            }

            .error{

                color:red;

                text-align:center;

                margin-bottom:15px;

                font-weight:bold;

            }

        </style>

    </head>

    <body>

        <div class="login-card">

            <div class="text-center">

                <div class="logo">

                    🏋 GYM MANAGEMENT

                </div>

                <div class="subtitle">

                    Fitness Center Management System

                </div>

            </div>

            <c:if test="${not empty error}">

                <div class="error">

                    ${error}

                </div>

            </c:if>

            <form
                action="${pageContext.request.contextPath}/login"
                method="post">

                <div class="mb-3">

                    <label>

                        Username

                    </label>

                    <input
                        type="text"
                        name="username"
                        class="form-control"
                        required>

                </div>

                <div class="mb-3">

                    <label>

                        Password

                    </label>

                    <input
                        id="password"
                        type="password"
                        name="password"
                        class="form-control"
                        required>

                </div>

                <div class="form-check mb-3">

                    <input
                        class="form-check-input"
                        type="checkbox"
                        id="showPassword">

                    <label
                        class="form-check-label"
                        for="showPassword">

                        Show Password

                    </label>

                </div>

                <button
                    class="btn-login">

                    LOGIN

                </button>

            </form>

        </div>

        <script>

            document
                    .getElementById("showPassword")
                    .addEventListener("change", function () {

                        let password =
                                document.getElementById("password");

                        if (this.checked) {

                            password.type = "text";

                        } else {

                            password.type = "password";

                        }

                    });

        </script>

    </body>

</html>
