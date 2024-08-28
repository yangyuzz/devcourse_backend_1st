<%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-20
  Time: 오후 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 화면</title>
</head>
<body>
<h2>로그인 화면입니다.</h2>
<form action="<%=request.getContextPath()%>/member/login" method="post">
    <table>
        <tr>
            <td>ID :</td>
            <td><input type="text" name="userid" value="programmers"/></td>
        </tr>
        <tr>
            <td>PW :</td>
            <td><input type="password" name="userpw" value="1234"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="LOGIN">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
