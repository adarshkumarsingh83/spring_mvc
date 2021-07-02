<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="static/js/jquery.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</head>
<body>
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
    <P>  The time on the server is ${serverTime}. </P>
</div>
</body>
</html>
