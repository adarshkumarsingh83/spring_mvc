<%--
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
${message}
<c:if test="${user != null}">
    <table>
        <tr>
            <td>First Name</td>
            <td>&nbsp;</td>
            <td><c:out value="${user.firstName}"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>&nbsp;</td>
            <td><c:out value="${user.lastName}"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td>&nbsp;</td>
            <td><c:out value="${user.email}"/></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td>&nbsp;</td>
            <td><c:out value="${user.telephone}"/></td>
        </tr>
    </table>


</c:if>
</body>
</html>