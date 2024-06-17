package com.ureca.jdbc;

import java.sql.*;

public class JdbcTest {
	public static void main(String[] args) throws Exception{
		
		//이거 순서 외우기 시험 나올수도 있음
		// 이 아래 방법은 옛날 방식

		//Class.forName("com.mysql.cj.jadc.Driver");

		String sql = "select * from book";
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		while(rs.next()) {
			System.out.println(rs.getString("num")+" "+rs.getString(2)+" "+rs.getInt("price"));
		}

		rs.close();
		st.close();
		con.close();
		
		


		
	}

}




