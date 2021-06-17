<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2021
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
    <h1>Setting</h1>
    <form:form modelAttribute="letter" method="post" action="/update">
        <table>
            <tr>
                <td>Language:</td>
                <td><form:select path="language" items="${listLanguage}"/></td>
            </tr>
            <tr>
                <td>Page Size:</td>
                <td><span>Show</span><form:select path="pagesize" items="${listPageSize}"/><span>Email per page</span></td>
            </tr>
            <tr>
                <td>Spam filter:</td>
                <td><form:checkbox path="filter"/><span>Enable spams filter</span></td>
            </tr>
            <tr>
                <td>Signature:</td>
                <td><form:textarea path="signature" cssStyle="width: 300px" rows="3" cols="20"/></td>
            </tr>
            <tr>
                <td><button type="submit">Update</button></td>
                <td><button type="button">Cancel</button></td>
            </tr>

        </table>
    </form:form>
</body>
</html>
