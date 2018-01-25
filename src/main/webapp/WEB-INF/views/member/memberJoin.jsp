<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var check=true;
		$("#id").keyup(function() {
			var data = $(this).val();
			$.post("memberIdCheck",{id:data},function(result){
				if(result.trim()==0){
					$("#result").html("이미 있는 ID");
				}else {
					$("#result").html("사용 가능 ID");
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>Member Join</h1>
	<form action="./memberJoin" method="post" enctype="multipart/form-data">
		<p>ID : <input type="text" name="id" id="id">
			<div id="result"></div>
		</p>
		<p>PW : <input type="password" name="pw"></p>
		<p>Name : <input type="text" name="name"></p>
		<p>Email : <input type="text" name="email"></p>
		<p>Phone : <input type="text" name="phone"></p>
		<p>Age : <input type="text" name="age"> </p>
		<p>Job : <input type="text" name="job"> </p>
		<p>Photo : <input type="file" name="file"></p>
		
		<button>Join</button>
	
	
	</form>
	


</body>
</html>