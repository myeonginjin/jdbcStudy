package jdbcStudy.mini1.book;

import java.util.Vector;

public class Book extends Vector {
	private String bookid;
	private String bookname;
	private String publisher;
	private String price;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		//System.out.println(publisher);
		this.publisher = publisher;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
		
	}
	@Override
	public String toString() {
	    return "Book{" +
	            "bookid='" + bookid + '\'' +
	            ", bookname='" + bookname + '\'' +
	            ", publisher='" + publisher + '\'' +
	            ", price='" + price + '\'' +
	            '}';
	}
}
