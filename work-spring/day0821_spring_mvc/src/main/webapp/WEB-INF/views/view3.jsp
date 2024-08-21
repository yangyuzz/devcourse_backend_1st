<%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-21
  Time: 오후 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  나도 age를 혹시 받아볼 수 있나? <br>
<%=request.getParameter("age")%>
</body>
</html>
