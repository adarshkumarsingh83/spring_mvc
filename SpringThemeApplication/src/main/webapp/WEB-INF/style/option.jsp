<%--
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="left">
    <span style="float: left">
    <c:if test="${page =='registrationForm'}">
        <a href="?theme=default"><spring:message code="label.theme.default"/></a>
        |
        <a href="?theme=black"><spring:message code="label.theme.black"/></a>
        |
        <a href="?theme=blue"><spring:message code="label.theme.blue"/></a>
    </c:if>
    <c:if test="${page =='registrationStatus'}">
        <a href="registrationForm.do" accesskey="b">
            <spring:message code="label.theme.back"/>
        </a>
    </c:if>
</span>
</div>

<div class="right">
    <span style="float: right">
        <c:if test="${page =='registrationForm'}">
            <a href="?lang=en"> <spring:message code="label.lang.english"/></a>
            |
            <a href="?lang=de"> <spring:message code="label.lang.dutch"/></a>
        </c:if>
        &nbsp; &nbsp;
    </span>
</div>