package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Spreadsheet spreadsheet = new Spreadsheet();
		String input;
		
		do {
			input = scanner.nextLine();
			System.out.println(spreadsheet.processCommand(input));
		} while(!input.equals("quit"));
	}
}
