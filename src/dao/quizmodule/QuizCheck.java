package dao.quizmodule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/check")
public class QuizCheck extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ư�� �������� ������ Ȯ���Ͽ� �ٽ� singleplayȭ�鿡 �ѷ��ش�.
		//���⼭�� �����Ͻ� �޺��� ���������� ���� �������Ѵ�.
	}
	
}
