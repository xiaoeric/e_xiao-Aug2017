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
			System.out.println("Welcome to the Quadratic Describer");
			System.out.println("Provide values for coefficients a, b, and c");
			System.out.print("a: ");
			double a = userInput.nextDouble();
			System.out.print("b: ");
			double b = userInput.nextDouble();
			System.out.print("c: ");
			double c = userInput.nextDouble();
			System.out.println();
			System.out.println("Description of the graph of:");
			System.out.println("y = " + a + " x^2 + " + b + " x + " + c);
			System.out.println();
			//Passes variables to quadrDescriber and prints the String returned
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println();
			/* Prompts the user whether or not they want to continue
			 * and stores the user input as a String.
			 */
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			willContinue = userInput.next();
		} while(!(willContinue.charAt(0) == 'q'));
	}
}
