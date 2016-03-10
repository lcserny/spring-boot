<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" action="/second/register" commandName="user">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname</form:label></td>
            <td><form:input path="surname" /></td>
            <td><form:errors path="surname"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>

</form:form>
<c:if test="${success}">
    <div>Welcome!</div>
</c:if>
</body>
</html>