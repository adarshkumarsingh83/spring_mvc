<%--
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>

    <style>
        body {
            font-family: sans-serif, Arial;
        }
    </style>
</head>
<body>

<div id="header">
    <tiles:insertAttribute name="header"/>
</div>

<div id="menu">
    <tiles:insertAttribute name="option"/>
</div>

<div id="content">
    <div id="leftContent">
        <tiles:insertAttribute name="menu"/>
    </div>
    <div id="rightContent">
        <tiles:insertAttribute name="body"/>
    </div>
</div>

<div id="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</table>
</body>
</html>
