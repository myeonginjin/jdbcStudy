package jdbcStudy.mini1.gen;

import java.sql.*;


public class JDBC2CRUD {
	
	public static void main(String[] args) {
		Connection con = null; // 파이널 블록에서 접근할 수 있도록 여기서 선언
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/urecadb";
			String user = "ureca";
			String password = "ureca";
			
			con = DriverManager.getConnection(url,user, password);
			String createTableSql = "create table board_test ("
					+ "bno int primary key auto_increment"
					+ ", bsubject varchar(150)"
					+ ", bwriter varchar(60)"
					+ ", bcontents varchar(300)"
					+ ", bdate datetime"
					+ ")";
			
			String insSql = "insert into board_test"
					+ " (bsubject, bwriter, bcontents, bdate)"
					+ " values ('주제1','노강','열심히...',now())";
			
			String upSql = "update board_test set bwriter='노강사'"
					+ "where bno = 1";
			
			String delSql = "delete from board_test where bno = 1";
			
			Statement stmt = con.createStatement();
			int resultCnt = 0;
			//resultCnt = stmt.executeUpdate(createTableSql);
			resultCnt = stmt.executeUpdate(delSql);
			System.out.println("결과 건수 : " + resultCnt + "건");
			

						
			
			stmt.close();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //main

} //class
