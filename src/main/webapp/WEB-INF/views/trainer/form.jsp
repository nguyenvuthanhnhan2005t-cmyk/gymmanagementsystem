<%-- 
    Document   : form
    Created on : Jun 14, 2026, 3:38:29 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container mt-4">

    <div class="row justify-content-center">

        <div class="col-md-8">

            <div class="card shadow">

                <div class="card-header bg-primary text-white">

                    <h3 class="mb-0">
                        🏋 Trainer Form
                    </h3>

                </div>

                <div class="card-body">

                    <form:form
                        modelAttribute="trainer"
                        method="post"
                        action="${trainer.trainerID == 0 ?
                                  pageContext.request.contextPath.concat('/trainers/save')
                                  :
                                  pageContext.request.contextPath.concat('/trainers/update')}">

                        <form:hidden path="trainerID"/>

                        <!-- Full Name -->

                        <div class="mb-3">

                            <label class="form-label">
                                Full Name
                            </label>

                            <form:input
                                path="fullName"
                                class="form-control"/>

                        </div>

                        <!-- Phone -->

                        <div class="mb-3">

                            <label class="form-label">
                                Phone
                            </label>

                            <form:input
                                path="phone"
                                class="form-control"/>

                        </div>

                        <!-- Email -->

                        <div class="mb-3">

                            <label class="form-label">
                                Email
                            </label>

                            <form:input
                                path="email"
                                class="form-control"/>

                        </div>

                        <!-- Gender -->

                        <div class="mb-3">

                            <label class="form-label">
                                Gender
                            </label>

                            <form:select
                                path="gender"
                                class="form-select">

                                <form:option value="Male">
                                    Male
                                </form:option>

                                <form:option value="Female">
                                    Female
                                </form:option>

                            </form:select>

                        </div>

                        <!-- Specialty -->

                        <div class="mb-3">

                            <label class="form-label">
                                Specialty
                            </label>

                            <form:input
                                path="specialty"
                                class="form-control"/>

                        </div>

                        <!-- Experience -->

                        <div class="mb-3">

                            <label class="form-label">
                                Experience Years
                            </label>

                            <form:input
                                path="experienceYears"
                                type="number"
                                class="form-control"/>

                        </div>

                        <!-- Salary -->

                        <div class="mb-3">

                            <label class="form-label">
                                Salary
                            </label>

                            <form:input
                                path="salary"
                                type="number"
                                class="form-control"/>

                        </div>

                        <!-- Status -->

                        <div class="mb-3">

                            <label class="form-label">
                                Status
                            </label>

                            <form:select
                                path="status"
                                class="form-select">

                                <form:option value="Active">
                                    Active
                                </form:option>

                                <form:option value="Inactive">
                                    Inactive
                                </form:option>

                            </form:select>

                        </div>

                        <div class="d-flex justify-content-between">

                            <a href="${pageContext.request.contextPath}/trainers"
                               class="btn btn-secondary">

                                ← Back

                            </a>

                            <button type="submit"
                                    class="btn btn-primary">

                                💾 Save Trainer

                            </button>

                        </div>

                    </form:form>

                </div>

            </div>

        </div>

    </div>

</div>
