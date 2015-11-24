<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/errors.css" rel="stylesheet" type="text/css">
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<br>
<form:form method="post" action="register.do" name="user" commandName="user">

    <table>
        <tr>
            <td><form:label path="password">
                <spring:message code="form.user.pwd"/>
            </form:label></td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password" cssClass="errors"/></td>
        </tr>
        <tr>
            <td><form:label path="reTypePassword">
                <spring:message code="form.user.retype.pwd"/>
            </form:label></td>
            <td><form:password path="reTypePassword"/></td>
            <td><form:errors path="reTypePassword" cssClass="errors"/></td>
        </tr>
        <tr>
            <td><form:label path="dob">
                <spring:message code="form.dob"/>
            </form:label></td>
            <td><form:input path="dob"/></td>
            <td><form:errors path="dob" cssClass="errors"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="hidden" name="_page" value="1"/></td>
        </tr>
        <tr>
            <td colspan="3">
            <input type="submit" name="action" value="Next" />
            <input type="submit" name="action" value="previous"/>
            <input type="submit" name="action" value="skip"/>
            <input type="submit" name="action" value="Cancel" />
            </td>
        </tr>
    </table>
</form:form>
