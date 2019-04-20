package NazimExams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CommonFunctions {
	public static String readMenu(String path) {
		String finalContent = "";
		try {
			FileReader filePath = new FileReader(path);
			BufferedReader bf = new BufferedReader(filePath);
			String line = "";
			while ((line = bf.readLine()) != null) {
				finalContent += line + "\n";
			}
			filePath.close();
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return finalContent;
	}

	public static String inputData() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	public static void outputData(String str) {
		System.out.println(str);
	}
}
