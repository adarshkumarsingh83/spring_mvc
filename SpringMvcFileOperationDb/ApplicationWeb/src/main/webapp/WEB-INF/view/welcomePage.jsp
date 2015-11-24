<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%--
    @author Adarsh
    @author $LastChangedBy: adarsh $
   @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<CENTER>

    <authz:authorize ifAnyGranted="ROLE_USER,ROLE_SUPERADMIN,ROLE_ADMIN">
        <BR/> <BR/> <BR/>

        <H1> CLICK FOR GETTING THE FILE OPERATION PAGE </H1>
        <BR/>

        <H3><a href="fileOperation.do">FILE OPERATION PAGE </a></H3>
    </authz:authorize>

    <authz:authorize ifNotGranted="ROLE_USER,ROLE_SUPERADMIN,ROLE_ADMIN">
        <BR/>
            YOU ARE NOT ALLOWED TO VIEW THIS PAGE
        <BR/>
    </authz:authorize>

</CENTER>
</body>
</html>