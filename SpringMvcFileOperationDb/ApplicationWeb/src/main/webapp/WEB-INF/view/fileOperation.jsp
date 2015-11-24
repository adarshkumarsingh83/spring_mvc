<%--
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 00000 $, $Date:: 12/12/12 12:12 AM#$
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Upload and Download files using Spring</title>
    <script type="text/javascript">
        function verifyEmpty() {
            var fileValue = document.getElementById("uploadFile").value;
            alert(fileValue.trim().length)
            if (fileValue == '' || fileValue.trim().length == 0) {
                document.getElementById("uploadFile").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<BR/>
<BR/>

<h2>ADD FILE TO DATABASE</h2>
<c:if test="${param.error!=null}">
    <c:choose>
        <c:when test="${param.error == 'FAILS'}">
            <div style="padding: 5,5,5,5 ; border:red 5px; color: RED;">
                FILE OPERATION FAILS
            </div>
        </c:when>
        <c:when test="${param.error == 'EMPTY'}">
            <div style="padding: 5,5,5,5 ; border: 5px; color: RED;">
                FILE IS NOT SELECTED
            </div>
        </c:when>
        <c:when test="${param.error == 'SUCCESSFUL'}">
            <div style="padding: 5,5,5,5 ; border: 5px; color: GREEN;">
                FILE OPERATION SUCCESSFUL
            </div>
        </c:when>
    </c:choose>
</c:if>
<authz:authorize ifAnyGranted="ROLE_USER,ROLE_SUPERADMIN,ROLE_ADMIN">
    <fieldset style="margin:5px 5px 3px 5px;  width:85%;  background-color:rgba(220, 218, 245, 0.41);">
        <legend><strong style="color:black;">File Upload Window</strong></legend>
        <form action="upload.do" method="post" enctype="multipart/form-data" onsubmit="return verifyEmpty();">
            <table width="100%" border="1" cellspacing="0">
                <tr>
                    <td width="35%"><strong>File to upload</strong></td>
                    <td width="65%"><input type="file" name="uploadFile"/></td>
                </tr>
                <tr>
                    <td><strong>Notes</strong></td>
                    <td><input type="text" name="notes" width="60"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="submit" value="Upload File"/></td>
                </tr>
            </table>
        </form>
    </fieldset>
</authz:authorize>
<BR/>
<BR/>
<BR/>
<BR/>
<authz:authorize ifAnyGranted="ROLE_USER,ROLE_SUPERADMIN,ROLE_ADMIN">
    <fieldset style="margin:5px 5px 3px 5px;  width:85%;  background-color:rgba(220, 218, 245, 0.41);">
        <legend><strong style="color:black;">List of Uploaded File</strong></legend>
        <table width="100%" border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th width="4%">No</th>
                <th width="30%">Filename</th>
                <th width="30%">Notes</th>
                <th width="16%">Type</th>
                <th width="20%">&nbsp;</th>
            </tr>
            <c:choose>
                <c:when test="${files != null}">
                    <c:forEach var="file" items="${files}" varStatus="counter">
                        <tr>
                            <td>${counter.index + 1}</td>
                            <td>${file.filename}</td>
                            <td>${file.notes}</td>
                            <td>${file.type}</td>
                            <td>
                                <div align="center"><a href="download.do?id=${file.id}">Download</a>
                                    /<a href="delete.do?id=${file.id}">Delete</a></div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
        </table>
    </fieldset>
</authz:authorize>
</body>
</html>