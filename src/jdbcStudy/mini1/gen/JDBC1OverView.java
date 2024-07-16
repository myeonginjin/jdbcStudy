package jdbcStudy.mini1.gen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1OverView {
	
	/*
	 * JDBC 5단계
	 * 1 - 드라이버 로딩 (DB제조사가 제공하는 자바용 클라이언트 프로그램 현재는 mysql-connector-j-8.4.0.jar) 로딩
	 * 2 - 연결 확립 (connection)
	 * 3 - 질의 생성 (statement)
	 * 4 - 결과 확인 (CUD - 건수 확인, R - resultset) 
	 * 5 - 연결 해제 (close)
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); //1 단계
		
		String url = "jdbc:mysql://127.0.0.1:3306/urecadb";
		String id = "ureca";
		String password = "ureca";
		
		Connection con = DriverManager.getConnection(url, id, password); //2단계
		
		String sql = "select e.ename, e.job, e.sal, e.deptno, d.dname"
				+ " from emp e, dept d"
				+ " where e.deptno = d.deptno";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) { //4단계
			System.out.print( rs.getString("ename") + "\t");
			System.out.print( rs.getString("job") + "\t");
			System.out.print( rs.getString("sal") + "\t");
			System.out.print( rs.getString("deptno") + "\t");
			System.out.println( rs.getString("dname") + "\t");
		} // while
		
		rs.close(); //5단계
		stmt.close();
		con.close();
		
	} // main 

} // class
