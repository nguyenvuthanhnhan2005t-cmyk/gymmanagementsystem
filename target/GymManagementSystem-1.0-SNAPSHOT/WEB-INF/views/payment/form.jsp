<%-- 
    Document   : form
    Created on : Jun 14, 2026, 8:27:47 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container mt-4">

    <div class="row justify-content-center">

        <div class="col-md-8">

            <div class="card shadow">

                <div class="card-header bg-success text-white">

                    <h3 class="mb-0">
                        💳 Payment Form
                    </h3>

                </div>

                <div class="card-body">

                    <form:form
                        modelAttribute="payment"
                        method="post"
                        action="${payment.paymentID == 0 ?
                                  pageContext.request.contextPath.concat('/payment/save')
                                  :
                                  pageContext.request.contextPath.concat('/payment/update')}">

                        <form:hidden path="paymentID"/>

                        <!-- Member ID -->

                        <div class="mb-3">

                            <label class="form-label">
                                Member ID
                            </label>

                            <form:input
                                path="memberID"
                                type="number"
                                class="form-control"/>

                        </div>

                        <!-- Amount -->

                        <div class="mb-3">

                            <label class="form-label">
                                Amount (VNĐ)
                            </label>

                            <form:input
                                path="amount"
                                type="number"
                                class="form-control"/>

                        </div>

                        <!-- Payment Date -->

                        <div class="mb-3">

                            <label class="form-label">
                                Payment Date
                            </label>

                            <form:input
                                path="paymentDate"
                                type="date"
                                class="form-control"/>

                        </div>

                        <!-- Payment Method -->

                        <div class="mb-3">

                            <label class="form-label">
                                Payment Method
                            </label>

                            <form:select
                                path="paymentMethod"
                                class="form-select">

                                <form:option value="Cash">
                                    Cash
                                </form:option>

                                <form:option value="Bank Transfer">
                                    Bank Transfer
                                </form:option>

                                <form:option value="Credit Card">
                                    Credit Card
                                </form:option>

                            </form:select>

                        </div>

                        <!-- Status -->

                        <div class="mb-3">

                            <label class="form-label">
                                Status
                            </label>

                            <form:select
                                path="status"
                                class="form-select">

                                <form:option value="Paid">
                                    Paid
                                </form:option>

                                <form:option value="Pending">
                                    Pending
                                </form:option>

                                <form:option value="Failed">
                                    Failed
                                </form:option>

                            </form:select>

                        </div>

                        <div class="d-flex justify-content-between">

                            <a href="${pageContext.request.contextPath}/payment"
                               class="btn btn-secondary">

                                ← Back

                            </a>

                            <button type="submit"
                                    class="btn btn-success">

                                💾 Save Payment

                            </button>

                        </div>

                    </form:form>

                </div>

            </div>

        </div>

    </div>

</div>