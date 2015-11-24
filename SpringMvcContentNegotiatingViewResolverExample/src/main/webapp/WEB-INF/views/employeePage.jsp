<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee JSP View</title>
</head>
<body>
	<table border="1">
		<tr>
		<td>EmpId</td>
		<td>EmpName</td>
		<td>EmpEmail</td>
		<td>EmpProject</td>
		</tr>
        <c:forEach var="employee" items="${employeeStore.employeeList}">
        <tr>
            <td>${employee.empId}</td>
            <td>${employee.empName}</td>
            <td>${employee.empEmail}</td>
            <td>
                <c:forEach var="item" items="${employee.empProject}">
                    <c:out value="${item}"/>&nbsp;
                </c:forEach>
            </td>
        </tr>
        </c:forEach>

	</table>
</body>
</html>