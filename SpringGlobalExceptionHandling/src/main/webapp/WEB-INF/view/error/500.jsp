<%--
  * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
                        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Internal System Error Error</title>
    <style type="text/css">
        body {
            font-family: Verdana, Arial, sans-serif;
            font-size: 12px;
        }

        ul {
            line-height: 20px;
        }

        .stacktrace {
            padding-top: 10px;
            font-family: "Courier New", monospace;
            font-size: 14px;
            line-height: 18px;
            display: block;
            list-style: decimal;
            border: 1px solid #CCC;
            background-color: #F1F1F1;
        }

        .oddRow {
            background-color: #FFFFFF;
        }

        .evenRow {
            background-color: #F1F3FF;
        }
    </style>
</head>
<body>
<h3>An System Error occurred</h3>
  <div style="text-align: center;">
    <img alt="We are sorry,  An System Error occurred." src="<c:url value='/images/errors/500.jpg'/>"/>
</div>

<div class="page_announcement">
   An System Error occurred
</div>

</body>
</html>