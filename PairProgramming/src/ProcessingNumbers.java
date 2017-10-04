import java.util.Scanner;
/**
 * @author Eric Xiao
 * @date 10/4/2017
 * @description
 * This program accepts a sequence of numbers from
 * the user and outputs the smallest number, the
 * largest number, the sum of all even numbers, and
 * the largest even number.
 */
public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("How many numbers? ");
		/* numOfNums is used to determined how
		 * many times the for loop must loop.
		 */
		int numOfNums = userInput.nextInt();
		
		/* Accepts the first number the user inputs
		 * and initializes min and max as that
		 * value so it can be used in the for loop.
		 */
		System.out.print("Please enter a number: ");
		int firstInput = userInput.nextInt();
		int min = firstInput;
		int max = firstInput;
		int evenSum = 0;
		int evenMax = 1;
		int input;
		
		for(int i = 1; i < numOfNums; i++) {
			System.out.print("Please enter a number: ");
			input = userInput.nextInt();
			
			/* If the input is less than the current
			 * min, replace min with input.
			 */
			if(input < min) {
				min = input;
			}
			/* If the input is greater than the current
			 * max, replace max with input.
			 */
			if(input > max) {
				max = input;
			}
			/* If the number is even, add it to evenSum.
			 * Also if evenMax has not changed yet (i.e.
			 * for loop has not encountered an even
			 * number yet) replace evenMax with input.
			 * Otherwise (i.e. evenMax has changed and
			 * therefore the for loop has encountered an
			 * even number before the current input) if
			 * input is greater than evenMax, replace
			 * evenMax with input.
			 */
			if(input % 2 == 0) {
				evenSum += input;
				if(evenMax == 1) {
					evenMax = input;
				} else if(input > evenMax) {
					evenMax = input;
				}
			}
		}
		/* Output min and max, and output evenMax and evenSum
		 * only if evenMax is still 1 (i.e. the user has not
		 * typed any even numbers, therefore evenMax has
		 * not changed).
		 */
		System.out.println("The smallest number you typed is: " + min);
		System.out.println("The largest number you typed is: " + max);
		if(evenMax == 1) {
			System.out.println("You did not input any even numbers...");
		} else {
			System.out.println("The sum of all the even numbers you typed is: " + evenSum);
			System.out.println("The largest even number you typed is: " + evenMax);
		}
	}
}
