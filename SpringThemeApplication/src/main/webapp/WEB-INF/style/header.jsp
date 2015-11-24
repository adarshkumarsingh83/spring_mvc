<%--
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
    <h3>
        <c:if test="${page =='registrationForm'}">
            <spring:message code="label.title.registration"/>
        </c:if>
        <c:if test="${page =='registrationStatus'}">
            <spring:message code="label.title.registration.success"/>
        </c:if>

    </h3>
</center>





