<%@ page import="com.grepp.boot.model.dto.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
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
    <title>게시판목록</title>
</head>
<body>
<%@ include file="common/header.jsp"%>
<a href="<%=request.getContextPath()%>/board/write">[글쓰기 하러가기]</a><br>
<table border="1">
    <%
        Map<String, Object> pageData = (Map<String, Object>) request.getAttribute("pageData");
        List<BoardDTO> bList = (List<BoardDTO>)pageData.get("bList");
        for(BoardDTO b: bList){
    %>
    <tr>
        <td><%=b.getNo()%></td>
        <td><a href="<%=request.getContextPath()%>/board/read?no=<%=b.getNo()%>"><%=b.getTitle()%></a></td>
        <td><%=b.getWriter()%></td>
        <td><%=b.getRegDate()%></td>
        <td><%=b.getReadCount()%></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="5">
            <%
                int nowPage = (int) pageData.get("page");
                int startPage =  (int)  pageData.get("startPage");
                int endPage = (int)  pageData.get("endPage");
                int totalPage =  (int) pageData.get("totalPageCount");

                if(1<startPage){
            %>
            <a href="<%=request.getContextPath()%>/board/list?page=<%=startPage-1%>">[이전]</a>
            <%
                }

                for(int p=startPage; p<=endPage; p++){
            %>
            <a href="<%=request.getContextPath()%>/board/list?page=<%=p%>"> <%=p%>페이지 </a>
            <%
                }
                if(endPage < totalPage){
                    %>
            <a href="<%=request.getContextPath()%>/board/list?page=<%=endPage+1%>">[다음]</a>
                    <%
                }
            %>
        </td>
    </tr>
</table>

</body>
</html>
