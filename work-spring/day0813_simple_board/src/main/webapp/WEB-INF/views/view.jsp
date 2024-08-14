<%@ page import="com.grepp.model.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-14
  Time: 오전 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 상세화면</title>
</head>
<body>
    <%
        BoardDTO bbb = (BoardDTO) request.getAttribute("bbb");
    %>
    <table border="1">
        <tr>
            <td>글번호 : </td>
            <td><%=bbb.getNo()%></td>
        </tr>
        <tr>
            <td>제목 : </td>
            <td><%=bbb.getTitle()%></td>
        </tr>
        <tr>
            <td>작성자 : </td>
            <td><%=bbb.getWriter()%></td>
        </tr>
        <tr>
            <td>작성일시 : </td>
            <td><%=bbb.getRegDate()%></td>
        </tr>
        <tr>
            <td>조회수 : </td>
            <td><%=bbb.getReadCount()%></td>
        </tr>
        <tr>
            <td>내용 : </td>
            <td><%=bbb.getContent()%></td>
        </tr>
    </table>
    <a href="#">[수정하기]</a>
    <a href="<%=request.getContextPath()%>/board.do?action=list">[게시판 목록으로]</a>
</body>
</html>
