package NazimExams;

public class Book {
	int bookId;
	String bookTitle;
	String bookAuthor;
	String bookPrice;
	public Book(int id, String title,String author,String price) {
		this.bookId=id;
		this.bookTitle=title;
		this.bookPrice=price;
		this.bookAuthor=author;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s , %s  ",bookTitle,bookAuthor, bookPrice);
	}
}
