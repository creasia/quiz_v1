<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	var number =0; //���� ���ڸ� ǥ��
	count = 10;
	function timer(){
		var text = document.getElementById("count");
		text.innerHTML= count;
		count--;
		if(count < 0){
			clearInterval(tid);
			if(number >=0){
			location.href="/GuiltyPleasure/quiz?cmd=QUIZ_GET&number="+number;
		//	number--;
			}else if(number <0){
				alert("���� ��")
			}
		}
	}
	window.onload = function(){
		tid = setInterval('timer()', 1000);
	}
	

</script>
</head>
<body>
	<h1>�̱� �÷��� ����</h1>

	<div style="float: left; width: 60%">
		ù��° ����
		<div style="width: 60%; height: 300px">
			���� ������ ������ �� ${quiz}
			<c:import url="/Quiz/SingleQuiz.jsp">
				<c:param name="quizQ" value="����1"></c:param>
			</c:import>
		</div>
		<div style="width: 60%; height: 100px">
			���� ���Ⱑ ������ ��
			<c:import url="/Quiz/SingleAnswer.jsp">
				<c:param name="quizA" value="���� 1"></c:param>
				<c:param name="quizList" value="�����Ʈ"></c:param>
			</c:import>
		<div id="count" style="float: left; width: 50%">
		</div>
		<div style="float: right; width: 50%">
			<input type="button" value="�����ϱ�"/>
		</div>
		</div>
	</div>

	<div style="border: 2px solid; float: right; width: 30%; height: 300px">
		�ι�° �����Դϴ�.
		<c:if test="${combo ne null}">
			�޺��� ����մϴ�.
		</c:if>
	</div>
</body>
</html>