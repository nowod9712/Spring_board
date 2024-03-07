<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
<table>
	<tr>
		<th>id</th>
		<td>${board.id}</td>
	</tr>
	<tr>
		<th>writer</th>
		<td>${board.boardWriter}</td>
	</tr>
	<tr>
		<th>date</th>
		<td>${board.boardCreatedTime}</td>
	</tr>
	<tr>
		<th>hits</th>
		<td>${board.boardHits}</td>
	</tr>
	<tr>
		<th>title</th>
		<td>${board.boardTitle}</td>
	</tr>
	<tr>
		<th>contents</th>
		<td>${board.boardContents}</td>
	</tr>
</table>
<button onclick="listFn()">목록</button>
<button onclick="updateFn()">수정</button>
<button onclick="deleteFn()">삭제</button>
</body>
<script>
	const listFn = () => {
		const page = '${page}';
		location.href ="/board/paging?page=" + page;
	}
	
	const updateFn = () => {
		const id = '${board.id}';
		location.href ="/board/update?id=" + id;
		//현재 페이지의 URL을 "/board/update?id="에 동적으로 변하는 id 값이 추가된 URL로 변경하여 해당 URL로 이동시킨다.
		// 이를 통해 사용자는 현재 페이지를 "/board/update"로 이동하되, 추가적으로 id 값을 전달 가능하다. 
	}
	
	const deleteFn = () => {
		const id = '${board.id}'; 
		location.href ="/board/delete?id=" + id;
		//현재 페이지의 URL을 "/board/update?id="에 동적으로 변하는 id 값이 추가된 URL로 변경하여 해당 URL로 이동시킨다
		//사용자는 현재 페이지를 "/board/delete"로 이동하되, 추가적으로 id 값을 전달 가능하다.
	}

</script>
</html>
