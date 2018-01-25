<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
<script type="text/javascript">
	var message = '${message}';
	if(message !=''){
		alert(message);
	}

</script>	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:if test="${empty member}">
<a href="./member/memberJoin">Join</a>
<a href="./member/memberLogin">Login</a>
</c:if>
<c:if test="${not empty member}">
<a href="./member/memberView">MyPage</a>
<a href="./member/memberLogOut">LogOut</a>
</c:if>

<a href="./notice/noticeList">Notice</a>
<a href="./qna/qnaList">Qna</a>
</body>
</html>
