package NazimExams;

import java.util.List;

public interface BookDb {
	public void showData();
	public void insertData(Book s1);
	public void findByAuthor(String author) throws BookNotFoundException;
	public void findByTitle(String title) throws BookNotFoundException;
}
