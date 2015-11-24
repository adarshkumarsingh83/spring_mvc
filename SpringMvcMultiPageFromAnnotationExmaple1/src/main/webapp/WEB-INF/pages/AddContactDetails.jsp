<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/errors.css" rel="stylesheet" type="text/css">
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="errors">
    <c:if test="${not empty skipMsg}">
        ${skipMsg}
    </c:if>
</div>
<form:form method="post" action="register.do" name="user" commandName="user">
    <form:errors cssClass="error"/>
    <table>
        <tr>
            <td><form:label path="mobile">
                <spring:message code="form.mobile"/>
            </form:label></td>
            <td><form:input path="mobile"/></td>
            <td><form:errors path="mobile" cssClass="errors"/></td>
        </tr>

        <tr>
            <td><form:label path="email">
                <spring:message code="form.email"/>
            </form:label></td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="errors"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="hidden" name="_page" value="2"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="action" value="Store"/>
                <input type="submit" name="action" value="previous"/>
                    <c:if test="${empty displayButton}">
                        <input type="submit" name="action" value="skip"/>
                    </c:if>
                <input type="submit" name="action" value="Cancel"/>
            </td>
        </tr>
    </table>

</form:form>
