<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
${sessionScope.quizlist};
</script>
</head>
<body>
	<h2>${sessionScope.quizlist[0].getQ_question()};</h2>
</body>
</html>