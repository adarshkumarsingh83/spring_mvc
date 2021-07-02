<%--
  * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="static/js/jquery.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Spring Global Exception Handler Example</h2>


<div class="container">
    <div class="jumbotron" style="text-align: center">
        <div class="alert alert-info">
            <h4>
                <c:if test="${not empty msg}">
                    <h4>${msg}</h4>
                </c:if>
            </h4>
        </div>
    </div>
</div>

</body>
</html>
