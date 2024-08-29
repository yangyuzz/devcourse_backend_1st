<%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-20
  Time: 오전 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    alert('<%=request.getAttribute("msg")%>');
    location.href = '<%=request.getAttribute("path")%>'; // 주소표시줄에 넣어서 이동시킬 경로
</script>

</body>
</html>
