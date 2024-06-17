package com.ureca.jdbc;

import java.sql.*;

public class JdbcTest8_update {
	public static void main(String[] args) throws Exception {
		
		

		
		String sql = "update book set title=?, price=? where num=?";
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1,"수필");
			ps.setInt(2,4444);
			ps.setString(3,"104");
			int r = ps.executeUpdate();
			
			System.out.println("수정완료: "+r);
		} catch (SQLException e ){
			System.out.println(e.getStackTrace());
		}

		
	}

}
