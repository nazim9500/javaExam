package NazimExams;

enum Choices{
	show,add,fauthor,ftitle;
}

public class BookStore {

	public static void main(String[] args) {
		String menu=menuFileReading();
		boolean condition = true;
		do {
			CommonFunctions.outputData(menu);
			String choice = CommonFunctions.inputData();
			condition = processMenu(choice);
		} while (condition);
	}

	private static String menuFileReading() {
		String filepath = "D:\\JavaNazim\\Java Programs\\Exams\\src\\NazimExams\\menu.txt";
		String menu = CommonFunctions.readMenu(filepath);
		return menu;
	}

	private static boolean processMenu(String choice) {
		BookRepository br = new BookRepository();
		Choices ch=Choices.valueOf(choice.toLowerCase());
		switch (ch) {
		case show:
			br.showData();
			return true;
		case add:
			Book e1=userInputs();
			br.insertData(e1);
			return true;
		case fauthor:
			try {
				FindByAuthorHelper(br);
			} catch (BookNotFoundException e) {
				System.out.println(e);
			}
			return true;
		case ftitle:
			try {
				findByTitleHelper(br);
			} catch (BookNotFoundException e) {
				System.out.println(e);
			}
			return true;
		default:
			System.exit(0);
		}
		return false;
	}

	private static void findByTitleHelper(BookRepository br) throws BookNotFoundException {
		CommonFunctions.outputData("Enter Title");
		String title =CommonFunctions.inputData();
		br.findByTitle(title);
	}

	private static void FindByAuthorHelper(BookRepository br) throws BookNotFoundException {
		CommonFunctions.outputData("Enter Author Name");
		String author =CommonFunctions.inputData();
		br.findByAuthor(author);
	}

	private static Book userInputs() {
		CommonFunctions.outputData("Enter Id");
		int id =Integer.parseInt(CommonFunctions.inputData());

		CommonFunctions.outputData("Enter Title");
		String title =CommonFunctions.inputData();

		CommonFunctions.outputData("Enter Author Name");
		String author =CommonFunctions.inputData();

		CommonFunctions.outputData("Enter Price");
		String price =CommonFunctions.inputData();

		return new Book(id , title, author, price);
	}

}
