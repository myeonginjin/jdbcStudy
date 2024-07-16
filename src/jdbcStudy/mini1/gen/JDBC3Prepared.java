package jdbcStudy.mini1.gen;

import java.sql.*;
import java.util.Scanner;

import javax.security.sasl.SaslException;

public class JDBC3Prepared {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inData = "";
		inData = scan.nextLine();
		
		Connection con = null;
		
		try {
			
		String sql = "select empno, ename, job, sal, dname"
				+ " from emp e, dept d"
				+ " where e.deptno = d.deptno"
				+ " and ename = ?";
		
		
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/urecadb";
			String user = "ureca";
			String password = "ureca";
			con = DriverManager.getConnection(url, user, password);
			
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, inData); //"1:첫번째 물음표의 의미"
			ResultSet rs = psmt.executeQuery();
			
			rs.next(); // 이걸 해주지 않으면 Before start of result set가 발생. 왜? 커서는 첫번째 행이 아닌 그 이전을 가르키고 있음. 한칸 이동해야 객체를 가르키기 시작함
			//아님 아래와 같이 작성
//			while(rs.next()) {
//				System.out.print(rs.getInt("empno") + "\t");
//				System.out.print(rs.getString("ename") + "\t");
//				System.out.print(rs.getString("job") + "\t");
//				System.out.print(rs.getInt("sal") + "\t");
//				System.out.println(rs.getString("dname"));
//			}
			
			System.out.print(rs.getInt("empno") + "\t");
			System.out.print(rs.getString("ename") + "\t");
			System.out.print(rs.getString("job") + "\t");
			System.out.print(rs.getInt("sal") + "\t");
			System.out.println(rs.getString("dname"));
			
			rs.close();
			psmt.close();
			
			
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
