package NazimExams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements BookDb {
	
	static String url = "jdbc:mysql://localhost/cdactraining";
	static String username = "root";
	static String password = "";
	
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		if(con==null) {
			CommonFunctions.outputData("Connection Failed");
		}
		return con;
	}

	@Override
	public void showData() {
//		List<Book> stud = new ArrayList<Book>();
		try {
			Connection con = getConnection();
			String query = "Select * from bookTable";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				CommonFunctions.outputData(res.getString("title").toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return stud;
	}

	@Override
	public void insertData(Book s1) {
		try {
			Connection con = getConnection();
			String query ="insert into booktable(Id,title,author,price) values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, s1.bookId);
			stmt.setString(2, s1.bookTitle);;
			stmt.setString(3, s1.bookAuthor);
			stmt.setString(4, s1.bookPrice);
			int rowAffected = stmt.executeUpdate();
			if(rowAffected==1) {
				CommonFunctions.outputData("Insertion successfull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void findByAuthor(String author) throws BookNotFoundException {
		try {
			Connection con = getConnection();
			String query ="Select * from bookTable where author='" + author+ "'";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				CommonFunctions.outputData("Title: "+res.getString("title").toString()+ ", Author:"+res.getString("author").toString());
			}
			if (!res.next()) {
				throw new BookNotFoundException("No Book available with this Author name:");
			}
		} catch (SQLException e) {

			throw new BookNotFoundException("No book Availbe of this Author:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findByTitle(String title) throws BookNotFoundException {
		try {
			Connection con = getConnection();
			String query ="Select * from bookTable where title='" + title + "'";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				CommonFunctions.outputData( "Title: "+res.getString("title").toString()+ ", Author:"+res.getString("author").toString()  );
			}
			if (!res.next()) {
				throw new BookNotFoundException("No Book available with this title:");
			}
		} catch (SQLException e) {

			throw new BookNotFoundException("OOps! something wrong happend:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
