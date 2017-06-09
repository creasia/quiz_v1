package controller.command;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Command;
import dao.quizmodule.db.DBconnect;
import dbcp.DBConnectionMgr;
import dto.Quiz;

public class QuizgetCommand implements Command{

	Connection con = null;
	ArrayList list = null;
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 퀴즈를 가져오는 클래스
		HttpSession session = req.getSession();
		list = (ArrayList) session.getAttribute("quizlist");
		DBconnect db = new DBconnect();
		con = db.getCon();
		if(list==null){
			list = new ArrayList<>();
		}
		try {
			list = getQuiz();
			for (int i = 0; i < list.size(); i++) {
				Quiz d = (Quiz) list.get(i);
				System.out.println("리스트 출력 "+i+"번째 : "+ d.toString() );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("리스트만들기 실패"+e);
		}
		session.setAttribute("quizlist", list);
		return "/Quiz/SinglePlay.jsp";
	}
	
//	public Object processCommand(HttpServletRequest req, HttpServletResponse resp, int i)
//			throws ServletException, IOException {
//		// TODO 퀴즈를 가져오는 클래스
//		return "/Quiz/SinglePlay.jsp";
//	}
	
	private ArrayList getQuiz(){
		PreparedStatement pre=null;
		ResultSet rs = null;
		Quiz q;
		String sql = "select * from(select * from quiz order by dbms_random.value) where rownum <6";
		try {
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				q = new Quiz();
				q.setQ_answer(rs.getString("Q_ANSWER"));
				q.setQ_question(rs.getString("Q_QUESTION"));
				q.setQ_wa_a(rs.getString("Q_WA_A"));
				q.setQ_wa_b(rs.getString("Q_WA_B"));
				q.setQ_wa_c(rs.getString("Q_WA_C"));
				list.add(q);
			}
		} catch (SQLException e) {
			System.out.println("getquiz : "+ e);
		}
		return list;
	}

}
