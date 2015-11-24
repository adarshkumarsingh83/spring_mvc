<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<body>
<h2>Spring MVC file upload example</h2>

<form:form method="POST" commandName="fileUploadForm" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:errors path="*" cssClass="errorblock" element="div"/></td>
            <td>Please select a file to upload :</td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="upload"/></td>
            <td><form:errors path="file" cssClass="error"/></td>
        </tr>

    </table>
</form:form>

</body>
</html>