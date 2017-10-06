import java.util.Scanner;
/**
 * Contains a main method and handles interactions with the user.
 * @author Eric Xiao
 * @date September 22, 2017
 * @pseudocode
 * Create Scanner object.
 * Prompt user for a.
 * Accept user input for a, store as variable.
 * Prompt user for b.
 * Accept user input for b, store as variable.
 * Prompt user for c.
 * Accept user input for c, store as variable.
 * Add a line for A E S T H E T I C S.
 * Send a, b, and c to quadrDescriber and print the returned String.
 * Prompts the user if they want to continue or not.
 * Exits program if starts with 'q', otherwise continue.
 */
public class QuadraticClient {
	public static void main(String[] args) {
		//Creates Scanner object to accept user input.
		Scanner userInput = new Scanner(System.in);
		/* Declares and initializes a String to contain
		 * user input when prompted to continue or not.
		 */
		String willContinue = "";
		/* do-while block executes the statements once
		 * and repeats while the user does not input a
		 * String that begins with 'q'.
		 */
		do {
			/* Prompts the user for a, b, and c, and stores
			 * the user input into variables.
			 */
			System.out.println("Given the quadratic equation: ax^2 + bx + c,");
			System.out.print("Please enter a value for a: ");
			double a = userInput.nextDouble();
			System.out.print("Please enter a value for b: ");
			double b = userInput.nextDouble();
			System.out.print("Please enter a value for c: ");
			double c = userInput.nextDouble();
			System.out.println();
			//Passes variables to quadrDescriber and prints the String returned
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println();
			/* Prompts the user whether or not they want to continue
			 * and stores the user input as a String.
			 */
			System.out.println("Do you want to continue? Type \"quit\" to exit.");
			willContinue = userInput.next();
		} while(!(willContinue.charAt(0) == 'q'));
	}
}
