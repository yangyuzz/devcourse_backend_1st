<%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-14
  Time: 오후 4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/user" method="post">
        ID : <input type="text" name="userid"/><br>
        PW : <input type="password" name="userpw"/><br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
