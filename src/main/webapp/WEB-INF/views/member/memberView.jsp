<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My Page</h1>
	
	<p><img src="../resources/upload/${member.fname}"></p>
	<p>ID : ${member.id}</p>
	<p>Name : ${member.name}</p>
	<p>Age : ${member.age}</p>
	
	<a href="./memberUpdate">Update</a>
	<a href="./memberDelete">Delete</a>

</body>
</html>