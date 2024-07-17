package jdbcStudy.mini1.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.security.sasl.SaslException;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;

public class DAOList {

	/*
	 * JDBC 5단계
	 * 1 - 드라이버 (DB제조사가 제공하는 자바용 클라이언트 프로그램-mysql-connector-j-8.3.0.jar) 로딩
	 * 2 - 연결 확립 (connection)
	 * 3 - 질의 생성 (statement)
	 * 4 - 결과 확인 (CUD - 건수 확인, R - resultset)
	 * 5 - 연결 해제 (close)
	 */
	public Vector<Book> readAll() {

		Connection con = null;
		Vector<Book> bookList = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계.

			String url = "jdbc:mysql://127.0.0.1:3306/madangdb";
			String id = "madang"; // db 접속 아이디
			String password = "madang"; // db 접속 패스워드
			con = DriverManager.getConnection(url, id, password); // 2단계.
			
			String sql = "select bookid, bookname, publisher, price from book";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			bookList = new Vector<>();
			
			while(rs.next()) {
			Book obj = new Book();
			obj.setBookid(rs.getString("bookid"));
			obj.setBookname(rs.getString("bookname"));
			obj.setPublisher(rs.getString("publisher"));
			obj.setPrice(rs.getString("price"));
			//System.out.println(rs.getString("bookid"));
			bookList.add(obj);
			}
			//System.out.println(bookList);
			rs.close();
			stmt.close();
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return bookList;
	} // selectAll

} // class











