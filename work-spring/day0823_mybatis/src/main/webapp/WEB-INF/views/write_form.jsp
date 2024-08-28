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
    <title>글 작성화면</title>
</head>
<body>
<%@ include file="common/header.jsp"%>
<br>
<form action="<%=request.getContextPath()%>/board/write" method="post" enctype="multipart/form-data">
    제목 : <input type="text" name="title"><br>
    내용 : <textarea name="content"></textarea><br>

    <button id="btnAddFile">파일추가</button>
    <div id="divFiles"></div>
    <input type="submit" value="작성완료">
</form>

<script>
    document.getElementById('btnAddFile').onclick = function() {
        let div = document.createElement('div');
        let input = document.createElement('input'); //<input type="file" name="uploadFile"/>
        input.setAttribute('type', 'file');
        input.setAttribute('name', 'uploadFile');

        let btnDelete = document.createElement('button');
        btnDelete.appendChild(document.createTextNode('삭제'));
        btnDelete.onclick = function(){
            // div.remove();
            this.parentElement.remove(); // this는 삭제버튼. 부모는 div태그 찾아서 삭제하는 형태
        }

        div.appendChild(input); // <div> <input type="file" name="uploadFile"/> </div>
        div.appendChild(btnDelete);
        document.getElementById('divFiles').appendChild(div);
        return false; // form이 갑자기 파일추가 버튼 눌렀다고 submit 하는 상황을 막아주는
    }
</script>
</body>
</html>
