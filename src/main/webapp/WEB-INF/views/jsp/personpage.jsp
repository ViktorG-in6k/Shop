<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Persons</h1>

<table style="border: 1px solid; width: 500px; text-align:center">
    <thead style="background:#fcf">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Money</th>
        <th colspan="3"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${persons}" var="person">
        <c:url var="editUrl" value="/krams/main/persons/edit?id=${person.id}" />
        <c:url var="deleteUrl" value="/krams/main/persons/delete?id=${person.id}" />
        <tr>
            <td><c:out value="${person.firstName}" /></td>
            <td><c:out value="${person.lastName}" /></td>
            <td><c:out value="${person.money}" /></td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
            <td><a href="${addUrl}">Add</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${empty persons}">
    There are currently no persons in the list. <a href="${addUrl}">Add</a> a person.
</c:if>

</body>
</html>


editpage.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Edit Person</h1>
<c:url var="saveUrl" value="/krams/main/persons/edit?id=${personAttribute.id}" />
<form:form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id:</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="firstName">First Name:</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>

        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>

        <tr>
            <td><form:label path="money">Money</form:label></td>
            <td><form:input path="money"/></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>