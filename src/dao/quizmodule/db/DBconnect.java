package dao.quizmodule.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcp.DBConnectionMgr;
import dto.Quiz;

public class DBconnect {
	Connection con;
	DBConnectionMgr pool;
	PreparedStatement pre =null;
	ResultSet rs = null;
	
	public DBconnect() {
		pool = DBConnectionMgr.getInstance();
		try {
			con = pool.getConnection();
			System.out.println("db연결");
		} catch (Exception e) {
			System.out.println("db연결 실패 : "+e);
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
}
