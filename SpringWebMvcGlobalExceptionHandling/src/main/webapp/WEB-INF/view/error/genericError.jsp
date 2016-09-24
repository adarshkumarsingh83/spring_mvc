<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="static/js/jquery.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">
        <div class="jumbotron" style="text-align: center">
            <div class="alert alert-danger">
                <c:if test="${not empty errCode}">
                    <h1>${errCode} : System Errors</h1>
                </c:if>

                <c:if test="${empty errCode}">
                    <h1>System Errors</h1>
                </c:if>

                <c:if test="${not empty errMsg}">
                    <h4>${errMsg}</h4>
                </c:if>

            </div>
        </div>
    </div>
	
</body>
</html>