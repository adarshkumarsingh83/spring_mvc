<%--
    @author Adarsh
    @author $LastChangedBy: adarsh $
   @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@page session="true" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <script type="text/javascript">
        function verifyEmpty() {
            var userName = document.getElementById("j_username").value;
            if (userName == '' || userName.trim().length == 0) {
                document.getElementById("userName").focus();
                return false;
            }
            var userPwd = document.getElementById("j_password").value;
            if (userPwd == '' || userPwd.trim().length == 0) {
                document.getElementById("userPwd").focus();
                return false;
            }
            return true;
        }
    </script>
    <style type="text/css">
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<h3>Server Login Page</h3>

<c:if test="${!empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">
    <div class="errorblock" align="left">
        <c:out value="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION}"/>
    </div>
</c:if>

<div align="left">
    <form action="<c:url value="/j_security_check"/>" method="post" onsubmit="return verifyEmpty();">
        <fieldset style="margin:5px 5px 5px 5px;  width: 320px;  background-color:rgba(215,202,134,0.70);">
            <legend><strong style="color:black;">Login Window</strong></legend>
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type='text' id="j_username" name='j_username' value=''>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' id="j_password" name='j_password'/>
                    </td>
                </tr>
                <tr>
                    <td><input name="submit" type="submit"
                               value="submit"/>
                    </td>
                    &nbsp;
                    <td><input name="reset" type="reset"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>