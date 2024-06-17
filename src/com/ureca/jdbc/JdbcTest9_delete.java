package com.ureca.jdbc;

import java.sql.*;

public class JdbcTest9_delete {
	public static void main(String[] args) throws Exception {
		
		String sql = "delete from book where num=?";
		
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1,"104");
			int r = ps.executeUpdate();
			
			System.out.println("삭제완료: "+r);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
