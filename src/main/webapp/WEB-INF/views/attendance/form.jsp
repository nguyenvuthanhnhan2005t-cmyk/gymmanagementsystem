<%-- 
    Document   : form
    Created on : Jun 13, 2026, 9:20:42 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h3 class="mb-0">

                Attendance Form

            </h3>

        </div>

        <div class="card-body">

            <form:form
                    modelAttribute="attendance"
                    method="post"
                    action="${attendance.attendanceID == 0 ?
                              pageContext.request.contextPath.concat('/attendance/add')
                              :
                              pageContext.request.contextPath.concat('/attendance/edit')}">

                <form:hidden path="attendanceID"/>

                <div class="mb-3">

                    <label class="form-label">

                        Member ID

                    </label>

                    <form:input
                            path="memberID"
                            class="form-control"/>

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Attendance Date

                    </label>

                    <form:input
                            path="attendanceDate"
                            type="date"
                            class="form-control"/>

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Check In Time

                    </label>

                    <form:input
                            path="checkInTime"
                            type="datetime-local"
                            class="form-control"/>

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Check Out Time

                    </label>

                    <form:input
                            path="checkOutTime"
                            type="datetime-local"
                            class="form-control"/>

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Note

                    </label>

                    <form:textarea
                            path="note"
                            rows="3"
                            class="form-control"/>

                </div>

                <button
                        type="submit"
                        class="btn btn-success">

                    Save

                </button>

                <a href="${pageContext.request.contextPath}/attendance"
                   class="btn btn-secondary">

                    Back

                </a>

            </form:form>

        </div>

    </div>

</div>
