package com.ureca.jdbc;

import java.sql.*;

public class JdbcTest4_delete {
	public static void main(String[] args) throws Exception {
		
		
		//이거 순서 외우기 시험 나올수도 있음
		// 이 아래 방법은 옛날 방식
		
		//Class.forName("com.mysql.cj.jadc.Driver");
		
		String sql = "delete from book where num=?";
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
		PreparedStatement ps = con.prepareStatement(sql);
		
		//Statement st = con.createStatement();
		
		ps.setString(1,"수필");
		int r = ps.executeUpdate();
		
		System.out.println("삭제완료: "+r);
		
		// 어? 인터페이스는 객체 못 만드는데? 펙토리메소드 패턴을 통해 예를들어 getConnection를 통해 해당 인터페이스를 상속받는 클래스를 반환받아오는거임
		//근데 엡셋 펙토리 패턴이랑 구분 잘지어야돼 엡셋 펙토리 패턴과 펙토리 메소드가 어떻게 쓰이는지 !!!
		System.out.println(con.getClass().getName());
		System.out.println(ps.getClass().getName());
		//System.out.println(rs.getClass().getName());
		
		//rs.close();
		ps.close();
		con.close();
	}

}
