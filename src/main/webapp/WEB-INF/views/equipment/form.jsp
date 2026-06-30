<%-- 
    Document   : form
    Created on : Jun 13, 2026, 10:35:30 PM
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

                        🏋 Equipment Form

                    </h3>

                </div>

                <div class="card-body">

                    <form:form
                        modelAttribute="equipment"
                        method="post"
                        action="${equipment.equipmentID == 0 ?
                                  pageContext.request.contextPath.concat('/equipment/save')
                                  :
                                  pageContext.request.contextPath.concat('/equipment/update')}">

                        <form:hidden path="equipmentID"/>

                        <!-- Equipment Name -->

                        <div class="mb-3">

                            <label class="form-label">

                                Equipment Name

                            </label>

                            <form:input
                                path="equipmentName"
                                class="form-control"
                                required="true"/>

                        </div>

                        <!-- Category -->

                        <div class="mb-3">

                            <label class="form-label">

                                Category

                            </label>

                            <form:select
                                path="category"
                                class="form-select">

                                <form:option value="Cardio">
                                    Cardio
                                </form:option>

                                <form:option value="Strength">
                                    Strength
                                </form:option>

                                <form:option value="Free Weight">
                                    Free Weight
                                </form:option>

                            </form:select>

                        </div>

                        <!-- Quantity -->

                        <div class="mb-3">

                            <label class="form-label">

                                Quantity

                            </label>

                            <form:input
                                path="quantity"
                                type="number"
                                class="form-control"/>

                        </div>

                        <!-- Purchase Date -->

                        <div class="mb-3">

                            <label class="form-label">

                                Purchase Date

                            </label>

                            <form:input
                                path="purchaseDate"
                                type="date"
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

                                <form:option value="Available">
                                    Available
                                </form:option>

                                <form:option value="Maintenance">
                                    Maintenance
                                </form:option>

                                <form:option value="Broken">
                                    Broken
                                </form:option>

                            </form:select>

                        </div>

                        <!-- Location -->

                        <div class="mb-3">

                            <label class="form-label">

                                Location

                            </label>

                            <form:input
                                path="location"
                                class="form-control"
                                placeholder="Example: Zone A"/>

                        </div>

                        <div class="d-flex justify-content-between">

                            <a href="${pageContext.request.contextPath}/equipment"
                               class="btn btn-secondary">

                                ← Back

                            </a>

                            <button type="submit"
                                    class="btn btn-success">

                                💾 Save

                            </button>

                        </div>

                    </form:form>

                </div>

            </div>

        </div>

    </div>

</div>
