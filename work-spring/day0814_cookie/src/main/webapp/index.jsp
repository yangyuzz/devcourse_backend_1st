<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <a href="<%=request.getContextPath()%>/makeCookie">[쿠키 발급받으러 가기]</a>
    <a href="<%=request.getContextPath()%>/checkCookie">[쿠키 확인]</a>
    <%
        String loginId = (String)session.getAttribute("loginId");
        if(loginId == null){ // 로그인 안된 사용자는 로그인 링크 그대로 보여주고.
    %>
    <a href="<%=request.getContextPath()%>/user?action=login">[로그인 하러가기]</a>
<%
        }else{ // 이미 로그인 내역이 있네?!
%>
    로그인된 사용자이군요! <b> <%=loginId%> 님 반갑습니다!
    <a href="<%=request.getContextPath()%>/user?action=logout">[logout]</a>
<%
        }
%>
</body>
</html>