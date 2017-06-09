<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>보기가 나오는 곳입니다.</h1>
	<form method="post" action="">
		<input type="button" value="${quizlist[0].getQ_answer()}"/>
		<input type="button" value="${quizlist[0].getQ_wa_a()}"/>
		<input type="button" value="${quizlist[0].getQ_wa_b()}}"/>
		<input type="button" value="${quizlist[0].getQ_wa_c()}"/>
	</form>
</body>
</html>