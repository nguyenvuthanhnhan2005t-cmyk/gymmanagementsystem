<%-- 
    Document   : form
    Created on : Jun 10, 2026, 11:41:31 AM
    Author     : ADMIN
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>Member Form</h2>

<c:url var="actionUrl" value="/members/add"/>

<c:if test="${member.memberID > 0}">
    <c:url var="actionUrl" value="/members/edit"/>
</c:if>

<form:form
    modelAttribute="member"
    method="post"
    action="${actionUrl}">

    <form:hidden path="memberID"/>

    <table>

        <tr>
            <td>Full Name</td>
            <td>
                <form:input path="fullName"/>
            </td>
        </tr>

        <tr>
            <td>Phone</td>
            <td>
                <form:input path="phone"/>
            </td>
        </tr>

        <tr>
            <td>Email</td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>

        <tr>
            <td>Gender</td>
            <td>
                <form:select path="gender">
                    <form:option value="Male">Male</form:option>
                    <form:option value="Female">Female</form:option>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Birth Date</td>
            <td>
                <form:input path="birthDate" type="date"/>
            </td>
        </tr>

        <tr>
            <td>Membership Type</td>
            <td>
                <form:select path="membershipType">

                    <form:option value="Basic">
                        Basic
                    </form:option>

                    <form:option value="VIP">
                        VIP
                    </form:option>

                    <form:option value="Student">
                        Student
                    </form:option>

                </form:select>
            </td>
        </tr>

        <tr>
            <td>Status</td>
            <td>

                <form:select path="status">

                    <form:option value="Active">
                        Active
                    </form:option>

                    <form:option value="Expired">
                        Expired
                    </form:option>

                </form:select>

            </td>
        </tr>

        <tr>
            <td colspan="2">

                <button type="submit">
                    Save
                </button>

            </td>
        </tr>

    </table>

</form:form>
