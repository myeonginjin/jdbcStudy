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
	}

	public int close() {
		try {
			con.close();
			return 1;
		} catch (SQLException e) {
			return 0;
		}
	}

	public Vector<Vector<String>> readAll() {
		Vector<Vector<String>> bookList = null;
		try {
			String sql = "select bookid, bookname, publisher, price from book";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			bookList = new Vector<>();
			while (rs.next()) {
				Vector<String> obj = new Vector<>();
				obj.add(rs.getString("bookid"));
				obj.add(rs.getString("bookname"));
				obj.add(rs.getString("publisher"));
				obj.add(rs.getString("price"));
				bookList.add(obj);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			return null;
		}
		return bookList;
	}

	public Vector<Vector<String>> searchBooks(String name, String publisher, String minPrice, String maxPrice) {
		Vector<Vector<String>> bookList = new Vector<>();

		try {
			StringBuilder sql = new StringBuilder("select bookid, bookname, publisher, price from book where 1=1");
			if (!name.isEmpty()) {
				sql.append(" and bookname like ?");
			}
			if (!publisher.isEmpty()) {
				sql.append(" and publisher like ?");
			}
			if (!minPrice.isEmpty()) {
				sql.append(" and price >= ?");
			}
			if (!maxPrice.isEmpty()) {
				sql.append(" and price <= ?");
			}

			PreparedStatement psmt = con.prepareStatement(sql.toString());

			int paramIndex = 1;
			if (!name.isEmpty()) {
				psmt.setString(paramIndex++, "%" + name + "%");
			}
			if (!publisher.isEmpty()) {
				psmt.setString(paramIndex++, "%" + publisher + "%");
			}
			if (!minPrice.isEmpty()) {
				psmt.setInt(paramIndex++, Integer.parseInt(minPrice));
			}
			if (!maxPrice.isEmpty()) {
				psmt.setInt(paramIndex++, Integer.parseInt(maxPrice));
			}

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				Vector<String> obj = new Vector<>();
				obj.add(rs.getString("bookid"));
				obj.add(rs.getString("bookname"));
				obj.add(rs.getString("publisher"));
				obj.add(rs.getString("price"));
				bookList.add(obj);
			}

			rs.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return bookList;
	}
}
