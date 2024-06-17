package com.ureca.jdbc;

import java.sql.*;

public class JdbcTest3_update {
	public static void main(String[] args) throws Exception {
		
		
		//이거 순서 외우기 시험 나올수도 있음
		// 이 아래 방법은 옛날 방식
		
		//Class.forName("com.mysql.cj.jadc.Driver");
		
		String sql = "update book set title=?, price=? where num=?";
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,"수필");
			ps.setInt(2,4444);
			ps.setString(3,"104");
			int r = ps.executeUpdate();
			
			System.out.println("수정완료: "+r);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

}
