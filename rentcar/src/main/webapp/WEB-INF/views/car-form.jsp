<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Car Form</title>
</head>
<body>
    <h2>Car Form</h2>
    <form:form method="POST" action="/cars/new" enctype="multipart/form-data" modelAttribute="car">
        <table>
            <tr>
                <td><form:label path="model">Model:</form:label></td>
                <td><form:input path="model" /></td>
                <td><form:errors path="model" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="model_year">Model Year:</form:label></td>
                <td><form:input path="model_year" /></td>
                <td><form:errors path="model_year" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="price">Price:</form:label></td>
                <td><form:input path="price" /></td>
                <td><form:errors path="price" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="file">Image:</form:label></td>
                <td><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>