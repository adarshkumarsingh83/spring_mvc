<%--
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <style type="text/css">
        .validationError {
            color: #ff0000;
            font-size: smaller;
            padding: 0, 0, 05px;
        }
    </style>
</head>
<body>
<form:form method="post" commandName="user" modelAttribute="user" action="addContact.do">
    <fieldset style="margin:5px 5px 5px 5px;  width: 95%; ">
        <legend><strong style="color:black;">User Registration Form</strong></legend>
        <table>
            <tr>
                <td><form:label path="firstName">
                    <spring:message code="label.firstName"/>
                </form:label></td>
                <td>&nbsp;</td>
                <td><form:input path="firstName"/></td>
                <td><form:errors path="firstName" cssClass="validationError"/></td>
            </tr>
            <tr>
                <td>
                    <form:label path="lastName">
                        <spring:message code="label.lastName"/>
                    </form:label>
                </td>
                <td>&nbsp;</td>
                <td><form:input path="lastName"/></td>
                <td><form:errors path="lastName" cssClass="validationError"/></td>
            </tr>
            <tr>
                <td>
                    <form:label path="email">
                        <spring:message code="label.email"/>
                    </form:label>
                </td>
                <td>&nbsp;</td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssClass="validationError"/></td>
            </tr>
            <tr>
                <td>
                    <form:label path="telephone">
                        <spring:message code="label.telephone"/>
                    </form:label>
                </td>
                <td>&nbsp;</td>
                <td><form:input path="telephone"/></td>
                <td><form:errors path="telephone" cssClass="validationError"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    &nbsp;
                </td>
                <td colspan="2">
                    <input type="submit" value="<spring:message code="label.register"/>"/>
                    &nbsp;
                    <input type="reset" value="<spring:message code="label.cancel"/>"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
