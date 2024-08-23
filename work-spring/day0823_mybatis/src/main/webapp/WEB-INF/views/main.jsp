<%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-20
  Time: 오전 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인화면</title>
</head>
<body>
<%@ include file="common/header.jsp"%>
<h2>백엔드 데브코스 MVC 게시판에 오신걸 환영합니다</h2>
<a href="<%=request.getContextPath()%>/board/write">[글쓰기 하러가기]</a>
<a href="<%=request.getContextPath()%>/board/list">[게시판 목록으로]</a>
</body>
</html>
