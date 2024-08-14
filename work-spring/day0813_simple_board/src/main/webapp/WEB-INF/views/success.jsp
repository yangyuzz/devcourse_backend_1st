<%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-14
  Time: 오전 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
글 쓰기 완료입니다.<br>
<a href="<%=request.getContextPath()%>/board.do?action=list">[목록으로]</a>

<script>
    alert('글 작성이 완료되었습니다.');
    location.href="<%=request.getContextPath()%>/board.do?action=list";
</script>
</body>
</html>
