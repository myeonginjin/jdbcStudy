package jdbcStudy.mini1.gen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC4ResultSet {

	public static void main(String[] args) {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/urecadb";
			String user = "ureca";
			String password = "ureca";
			con = DriverManager.getConnection(url, user, password);

			String sql = "select empno, ename, job, sal, dname"
					+ " from emp e, dept d"
					+ " where e.deptno = d.deptno";
			Statement stmt = con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("rs.isBeforeFirst() : " + rs.isBeforeFirst());
			System.out.println("rs.isAfterLast() : " + rs.isAfterLast());
			rs.afterLast();
			System.out.println("===> rs.afterLast() 수행");
			System.out.println("rs.isBeforeFirst() : " + rs.isBeforeFirst());
			System.out.println("rs.isAfterLast() : " + rs.isAfterLast());
			System.out.println();

			rs.beforeFirst();
			System.out.println("===> rs.beforeFirst() 수행");
			rs.next();
			System.out.println("===> rs.next() 수행");
			System.out.println(rs.getString(1) +" : "+ rs.getString(2));
			rs.next();
			System.out.println("===> rs.next() 수행");
			System.out.println(rs.getString(1) +" : "+ rs.getString(2));
			rs.previous();
			System.out.println("===> rs.previous() 수행");
			System.out.println(rs.getString(1) +" : "+ rs.getString(2));
			rs.last();
			System.out.println("===> rs.last() 수행");
			System.out.println(rs.getString(1) +" : "+ rs.getString(2));
			System.out.println("rs.isLast() : " + rs.isLast());
			rs.first();
			System.out.println("===> rs.first() 수행");
			System.out.println(rs.getString(1) +" : "+ rs.getString(2));
			System.out.println("rs.isFirst() : " + rs.isFirst());
			rs.absolute(3);
			System.out.println("===> rs.absolute(3) 수행");
			System.out.println(rs.getString(1) +" : "+ rs.getString(2));

			rs.close();
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
		} // finally
	} // main

} // class



