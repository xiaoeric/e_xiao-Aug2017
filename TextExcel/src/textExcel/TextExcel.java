package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{
	public static void main(String[] args)
	{
		Spreadsheet spreadsheet = new Spreadsheet();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		while(true){
			input = scanner.nextLine();
			if(input.equals("quit")) break;
			System.out.println(spreadsheet.processCommand(input));
		}
	}
}
