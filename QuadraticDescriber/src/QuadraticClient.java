import java.util.Scanner;

/*Eric Xiao
 * September 22, 2017
 * Contains a main method and handles interactions with the user.
 * 
 * Pseudocode:
 * Create Scanner object
 * Prompt user for a
 * Accept user input for a, store as variable
 * Prompt user for b
 * Accept user input for b, store as variable
 * Prompt user for c
 * Accept user input for c, store as variable
 * Add a line for A E S T H E T I C S
 * Send a, b, and c to quadrDescriber and print the returned String
 * Prompts the user if they want to continue or not
 * Exits program if "quit", otherwise continue
 */
public class QuadraticClient {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String willContinue = "";
		do {
			System.out.println("Given the quadratic equation: ax^2 + bx + c,");
			System.out.print("Please enter a value for a: ");
			int a = userInput.nextInt();
			System.out.print("Please enter a value for b: ");
			int b = userInput.nextInt();
			System.out.print("Please enter a value for c: ");
			int c = userInput.nextInt();
			System.out.println();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println();
			System.out.println("Do you want to continue? Type \"quit\" to exit.");
			willContinue = userInput.next();
		} while(!willContinue.equals("quit"));
	}
}
