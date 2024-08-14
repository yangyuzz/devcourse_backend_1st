<%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-14
  Time: 오후 4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
</head>
<body>
    <script>
        alert('<%=request.getAttribute("msg")%>');
        alert('<%=request.getAttribute("path")%>');
        if('<%=request.getAttribute("path")%>'){ // 값이 뭐라도 있는 경우
            location.href = "<%=request.getAttribute("path")%>";
        }else{// context path 없앤 경우 /도 안나타나서..ㅠㅠ
            location.href="/";
        }


    </script>
</body>
</html>
