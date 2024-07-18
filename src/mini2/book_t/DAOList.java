package mini2.book_t;

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

/*
DROP TABLE if exists Orders;
DROP TABLE if exists Book;
DROP TABLE if exists Customer;
DROP TABLE if exists Imported_Book;

CREATE TABLE Book (
  bookid		INTEGER PRIMARY KEY auto_increment,
  bookname	VARCHAR(40),
  publisher	VARCHAR(40),
  price		INTEGER
);

CREATE TABLE  Customer (
  custid		INTEGER PRIMARY KEY auto_increment,
  name		VARCHAR(40),
  address		VARCHAR(50),
  phone		VARCHAR(20)
);


CREATE TABLE Orders (
  orderid INTEGER PRIMARY KEY auto_increment,
  custid  INTEGER,
  bookid  INTEGER,
  saleprice INTEGER,
  orderdate DATE,
  FOREIGN KEY (custid) REFERENCES Customer(custid),
  FOREIGN KEY (bookid) REFERENCES Book(bookid)
);


INSERT INTO Book VALUES(1, '축구의 역사', '굿스포츠', 7000);
INSERT INTO Book VALUES(2, '축구 아는 여자', '나무수', 13000);
INSERT INTO Book VALUES(3, '축구의 이해', '대한미디어', 22000);
INSERT INTO Book VALUES(4, '골프 바이블', '대한미디어', 35000);
INSERT INTO Book VALUES(5, '피겨 교본', '굿스포츠', 8000);
INSERT INTO Book VALUES(6, '배구 단계별기술', '굿스포츠', 6000);
INSERT INTO Book VALUES(7, '야구의 추억', '이상미디어', 20000);
INSERT INTO Book VALUES(8, '야구를 부탁해', '이상미디어', 13000);
INSERT INTO Book VALUES(9, '올림픽 이야기', '삼성당', 7500);
INSERT INTO Book VALUES(10, 'Olympic Champions', 'Pearson', 13000);

INSERT INTO Customer VALUES (1, '박지성', '영국 맨체스타', '000-5000-0001');
INSERT INTO Customer VALUES (2, '김연아', '대한민국 서울', '000-6000-0001'); 
INSERT INTO Customer VALUES (3, '김연경', '대한민국 경기도', '000-7000-0001');
INSERT INTO Customer VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001');
INSERT INTO Customer VALUES (5, '박세리', '대한민국 대전',  NULL);

INSERT INTO Orders VALUES (1, 1, 1, 6000, STR_TO_DATE('2024-07-01','%Y-%m-%d'));
INSERT INTO Orders VALUES (2, 1, 3, 21000, STR_TO_DATE('2024-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (3, 2, 5, 8000, STR_TO_DATE('2024-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (4, 3, 6, 6000, STR_TO_DATE('2024-07-04','%Y-%m-%d'));
INSERT INTO Orders VALUES (5, 4, 7, 20000, STR_TO_DATE('2024-07-05','%Y-%m-%d'));
INSERT INTO Orders VALUES (6, 1, 2, 12000, STR_TO_DATE('2024-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (7, 4, 8, 13000, STR_TO_DATE( '2024-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (8, 3, 10, 12000, STR_TO_DATE('2024-07-08','%Y-%m-%d'));
INSERT INTO Orders VALUES (9, 2, 10, 7000, STR_TO_DATE('2024-07-09','%Y-%m-%d'));
INSERT INTO Orders VALUES (10, 3, 8, 13000, STR_TO_DATE('2024-07-10','%Y-%m-%d'));

-- 여기는 3장에서 사용되는 Imported_book 테이블
CREATE TABLE Imported_Book (
  bookid		INTEGER,
  bookname	VARCHAR(40),
  publisher	VARCHAR(40),
  price		INTEGER
);
INSERT INTO Imported_Book VALUES(21, 'Zen Golf', 'Pearson', 12000);
INSERT INTO Imported_Book VALUES(22, 'Soccer Skills', 'Human Kinetics', 15000);
COMMIT;
*/

/* ALTER TABLE book auto_increment = 11; */
/* ALTER TABLE customer auto_increment = 6; */
/* ALTER TABLE orders auto_increment = 11; */
