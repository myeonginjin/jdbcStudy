package searchBookSystem;

public class Book {
	int id;
	String name;
	String publisher;
	int price;
	
	public Book (int i, String n, String pu, int pr) {
		this.id = i;
		this.name = n;
		this.publisher = pu;
		this.price = pr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return name;
	}
	
}
