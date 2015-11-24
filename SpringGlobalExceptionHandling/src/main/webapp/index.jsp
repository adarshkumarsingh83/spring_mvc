<%--
  * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Spring Global Exception Handler Example</h2>

<c:if test="${not empty msg}">
    <h4>${msg}</h4>
</c:if>

</body>
</html>
