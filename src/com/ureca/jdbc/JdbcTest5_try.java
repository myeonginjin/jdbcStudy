package com.ureca.jdbc;

import java.sql.*;

public class JdbcTest5_try {
	public static void main(String[] args) throws Exception {
		
		
//		try {
//		Class.forName("com.mysql.cj.jadc.Driver");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
	
	
	String sql = "select * from book where num=?";
	PreparedStatement ps = null;
	Connection con=null;
	ResultSet rs=null;
	
	try {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
		ps = con.prepareStatement(sql);
		
		ps.setString(1,"104");
		rs = ps.executeQuery();
		
		if(rs.next()) {
			System.out.println();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		
		//아래 긴 문장들을 이 한 줄만으로 요약할 수 있음
		//util.close(rs,ps,con);
		
		try {
			if (rs!=null) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (ps!=null) ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	

}
