<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update.jsp</title>
</head>
<body>
<form action="/board/update" method="post" name="updateForm">
    <input type="hidden" name="id" value="${board.id}" readonly><br><br>
    <input type="text" name="boardWriter" value="${board.boardWriter}" readonly><br><br>
    <input type="text" name="boardPassword" id="boardPassword" placeholder="비밀번호"><br><br>
    <input type="text" name="boardTitle" value="${board.boardTitle}"><br><br>
    <textarea name="boardContents" cols="30" rows="10">${board.boardContents}</textarea><br><br>
    <input type="button" value="수정" onclick="updateReqFn()">
</form>

</body>
<script>
    const updateReqFn = () => {
        const passInput = document.getElementById("boardPassword").value;
        const passDB = '${board.boardPassword}';
        if (passInput == passDB) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다!!");
        }
    }
</script>
</html>