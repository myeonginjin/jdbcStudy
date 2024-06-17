package com.ureca.jdbc;

import java.sql.*;

public class JdbcTest7_insert {
	public static void main(String[] args) throws Exception {
		

		
		String sql = "insert into book values (?,?,?)";
		
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1,"104");
			ps.setString(2,"소설");
			ps.setInt(3,4000);
			int r = ps.executeUpdate();
			
			System.out.println("등록완료: "+r);
		} catch (SQLException e ){
			System.out.println(e.getStackTrace());
		}
		
		//Statement st = con.createStatement();

		


	}
	

}
