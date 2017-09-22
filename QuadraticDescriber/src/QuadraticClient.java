import java.util.Scanner;

/*Eric Xiao
 * September 22, 2017
 * Contains a main method and handles interactions with the user.
 */
public class QuadraticClient {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Given the quadratic equation: ax^2 + bx + c,");
		System.out.print("Please enter a value for a:");
		int a = userInput.nextInt();
		System.out.print("/nPlease enter a value for b:");
		int b = userInput.nextInt();
		System.out.print("/nPlease enter a value for c:");
		int c = userInput.nextInt();
		System.out.println();
		Quadratic.quadrDescriber(a, b, c);
	}

}
