package searchBookSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DAOList {

	Connection con = null;

	public int connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/madangdb";
			String id = "madang";
			String password = "madang";
			con = DriverManager.getConnection(url, id, password);
			return 1;
		} catch (ClassNotFoundException | SQLException e) {
			return 0;
		}
	} // constructor

	public int close() {
		try {
			con.close();
			return 1;
		} catch (SQLException e) {
			return 0;
		}
	} // close

	public Vector<Vector<String>> readAll() {

		Vector<Vector<String>> bookList = null;

		try {
			String sql = "select bookid, bookname, publisher, price from book";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			bookList = new Vector<Vector<String>>();
			while(rs.next()) {
				Vector<String> obj = new Vector<String>();
				obj.add( rs.getString("bookid") );
				obj.add( rs.getString("bookname") );
				obj.add( rs.getString("publisher") );
				obj.add( rs.getString("price") );
				bookList.add(obj);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			return null;
		}

		return bookList;
	} // readAll

	public int insertOne(String bookname, String publisher, String price) {
		int resultCnt = 0;

		String sql = "insert into book (bookname, publisher, price) values(?, ?, ?)";

		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, bookname);
			psmt.setString(2, publisher);
			psmt.setString(3, price);
			resultCnt = psmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
			return -1;
		}
		return resultCnt;
	}

	public int updateOne(String bookid, String bookname, String publisher, String price) {
		int resultCnt = 0;

		String sql = "update book set bookname = ?, publisher = ?, price = ? where bookid = ?";

		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, bookname);
			psmt.setString(2, publisher);
			psmt.setString(3, price);
			psmt.setString(4, bookid);
			resultCnt = psmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
			return -1;
		}
		return resultCnt;
	}

	public int deleteOne(String bookid) {
		int resultCnt = 0;

		String sql = "delete from book where bookid = ?";

		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, bookid);
			resultCnt = psmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
			return -1;
		}
		return resultCnt;
	}

} // class