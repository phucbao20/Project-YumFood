<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./UploadFile" method="post" enctype="multipart/form-data">
		<input name="fullname" type="text" placeholder="Fullname"> <br> <br>
		<input type="file" name="photo"> <br> <br>
		<button>submit</button>
	</form>
</body>
</html>