<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    @author Adarsh
    @author $LastChangedBy: adarsh $
   @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<html>
<head>
    <title></title>
</head>
<body>
<CENTER>
    <H1 style="color: red;padding: 5,5,5,5 ;border: black">
        USER NOT AUTHORISED TO VIEW REQUESTED PAGE <c:out value="${msg}"/>
    </H1>
</CENTER>
</body>
</html>