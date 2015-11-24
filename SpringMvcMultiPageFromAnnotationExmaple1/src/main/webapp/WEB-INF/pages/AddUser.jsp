<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html>
</head>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<link href="${pageContext.request.contextPath}/css/errors.css" rel="stylesheet" type="text/css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>
        Please Enter at least one field
    </title>
</head>
<body>
<div class="errors">
    <c:if test="${not empty skipMsg}">
        ${skipMsg}
    </c:if>
</div>
<form:form method="post" action="register.do" name="user" commandName="user" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="name">
                <spring:message code="form.name"/>
            </form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="errors"/></td>
        </tr>
        <tr>
            <td><form:label path="username">
                <spring:message code="form.user.name"/>
            </form:label></td>
            <td><form:input path="username"/></td>
            <td><form:errors path="username" cssClass="errors"/></td>
        </tr>
        <tr>
            <td>
                <spring:message code="label.image"/>
            </td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="hidden" name="_page" value="0"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" name="action" value="Next"/>
                <c:if test="${empty displayButton}">
                    <input type="submit" name="action" value="previous"/>
                </c:if>
                <input type="submit" name="action" value="Skip"/>
                <input type="submit" name="action" value="Cancel"/>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>