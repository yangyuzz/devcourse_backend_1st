<%@ page import="com.grepp.model.BoardDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-13
  Time: 오후 5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 목록</title>
</head>
<body>
<table border="1">
<%
    List<BoardDTO> bList = (List<BoardDTO>) request.getAttribute("bList");
    for(BoardDTO b: bList){
%>
        <tr>
            <td><%=b.getNo()%></td>
            <td><%=b.getTitle()%></td>
            <td><%=b.getWriter()%></td>
            <td><%=b.getRegDate()%></td>
            <td><%=b.getReadCount()%></td>
        </tr>
<%
    }
%>
</table>
</body>
</html>
