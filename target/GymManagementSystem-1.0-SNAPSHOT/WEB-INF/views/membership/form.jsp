<%-- 
    Document   : form
    Created on : Jun 10, 2026, 2:28:53?PM
    Author     : ADMIN
--%>

<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="form"%>

<h2>Add Membership</h2>

<form:form modelAttribute="membership"
           method="post">

    Member ID:
    <form:input path="memberID"
                cssClass="form-control"/>
    <br>

    Package:
    <form:select path="packageName"
                 cssClass="form-control">

        <form:option value="Basic"/>
        <form:option value="VIP"/>
        <form:option value="Student"/>

    </form:select>
    <br>

    Start Date:
    <form:input path="startDate"
                type="date"
                cssClass="form-control"/>
    <br>

    End Date:
    <form:input path="endDate"
                type="date"
                cssClass="form-control"/>
    <br>

    Price:
    <form:input path="price"
                cssClass="form-control"/>
    <br>

    <button class="btn btn-primary">
        Save
    </button>

</form:form>
