package com.ureca.jdbc;

import java.sql.*;

public class JdbcTest6_auto {
	public static void main(String[] args) throws Exception {
		
		
//		try {
//		Class.forName("com.mysql.cj.jadc.Driver");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
	
	
	String sql = "select * from book where num=?";
	
	
	try (Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
		PreparedStatement ps = con.prepareStatement(sql)){
		ps.setString(1, "103");
		
		try(ResultSet rs = ps.executeQuery()) {
			if(rs.next()) {
				System.out.println(rs.getString("num") + " " + rs.getString(2) + " " + rs.getInt("price"));
			}
		}
	}catch (SQLException e) {
		// TODO: handle exception
		}
	}
	
		
}
