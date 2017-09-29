/*Eric Xiao
 * September 6, 2017
 * Our self written math library
 * It contains a series of methods to do basic math functions.
 */
public class Calculate {
	//square() multiplies an input by itself.
	public static int square(int input) {
		return input*input;
	}
	//cube() multiplies an input by itself twice.
	public static int cube(int input) {
		return input*input*input;
	}
	//average() adds the two inputs and divides by 2.
	public static double average(double input1, double input2) {
		return (input1 + input2)/2;
	}
	//average() adds the three inputs and divides by 3.
	public static double average(double input1, double input2, double input3) {
		return (input1 + input2 + input3)/3;
	}
	//toDegrees() converts an input in radians to degrees.
	public static double toDegrees(double input) {
		return input / 3.141589 * 180;
	}
	//toRadians() converts an input in degrees to radians.
	public static double toRadians(double input) {
		return input / 180 * 3.14159;
	}
	/* discriminant() finds the discriminant of a quadratic function
	 * ax^2 + bx + c using a, b, and c as inputs.
	 */
	public static double discriminant(double a, double b, double c) {
		return b * b - 4 * a * c;
	}
	//toImproperFrac() converts a mixed number to an improper fraction.
	public static String toImproperFrac(int wholeNum, int numerator, int denominator) {
		return (wholeNum * denominator + numerator) + "/" + denominator;
	}
	//toMixedNum() converts an improper fraction to a mixed number.
	public static String toMixedNum(int numerator, int denominator) {
		return (numerator / denominator) + "_" + numerator % denominator + "/" + denominator;
	}
	/* foil() outputs the expanded version of a quadratic function given the alternate form
	 * (coeff1x + num1)(coeff2x + num2).
	 */
	public static String foil(int coeff1, int num1, int coeff2, int num2, String variable) {
		String firstTerm = (coeff1 * coeff2) + variable + "^2";
		String secondTerm;
		/* This if statement is used to check whether or not the second term of
		 * the standard form quadratic function is negative, and whether we need
		 * to use "+" or "-" (or "" if the second term is 0x).
		 */
		if(num1 * coeff2 + num2 * coeff1 < 0) {
			secondTerm = " - " + -(num1 * coeff2 + num2 * coeff1) + variable;
		} else if(num1 * coeff2 + num2 * coeff1 > 0) {
			secondTerm = " + " + (num1 * coeff2 + num2 * coeff1) + variable;
		} else {
			secondTerm = "";
		}
		String thirdTerm;
		/* This if statement is used to check whether or not the third term of
		 * the standard form quadratic function is negative, and whether we need
		 * to use "+" or "-" (or "" if the third term is 0).
		 */
		if(num1 * num2 < 0) {
			thirdTerm = " - " + -(num1 * num2);
		} else if(num1 * num2 > 0){
			thirdTerm = " + " + (num1 * num2);
		} else {
			thirdTerm = "";
		}
		return firstTerm + secondTerm + thirdTerm;
	}
	//isDivisibleBy() checks to see if a dividend is divisible by a divisor.
	public static boolean isDivisibleBy(int dividend, int divisor) {
		/* An IllegalArgumentException will be thrown when the divisor
		 * is 0 because you cannot divide by 0.
		 */
		if(divisor == 0) {
			throw new IllegalArgumentException();
		}
		if(dividend % divisor == 0) {
			return true;
		} else {
			return false;
		}
	}
	//absValue() multiplies an input by -1 if it is less than 0.
	public static double absValue(double input) {
		if(input < 0) {
			return -input;
		} else {
			return input;
		}
	}
	//max() evaluates which of the two inputs is greater.
	public static double max(double input1, double input2) {
		if(input1 > input2) {
			return input1;
		} else {
			return input2;
		}
	}
	//max() evaluates which of the three inputs is greatest.
	public static double max(double input1, double input2, double input3) {
		if(input1 > input2 && input1 > input3) {
			return input1;
		} else if(input2 > input3) {
			return input2;
		} else {
			return input3;
		}
	}
	//min() evaluates which of the two inputs is smaller.
	public static int min(int input1, int input2) {
		if(input1 < input2) {
			return input1;
		} else {
			return input2;
		}
	}
	//round2() rounds an input to two decimal places.
	public static double round2(double input) {
		/* The if statement checks whether the digit
		 * right after the hundredths place is less
		 * than 5.
		 */
		if(input * 1000 % 10 < 5) {
			/* This expression truncates the digits after the
			 * hundredths place to round it down.
			 */
			return ((input * 1000) - (input * 1000 % 10))/1000;
		} else {
			/* This expression adds a number to the input to 
			 * round it up and eliminate digits after the hundredths
			 * place.
			 */
			return ((input * 1000) + (10 - (input * 1000 % 10)))/1000;
		}
	}
	//exponent() multiplies an input a certain amount of times by itself.
	public static double exponent(double base, int exponent) {
		/* An IllegalArgumentException will be thrown when the exponent
		 * is less than 0 because this method does not support
		 * negative exponents.
		 */
		if(exponent < 0) {
			throw new IllegalArgumentException();
		}
		/* A variable is declared to store the result
		 * of each iteration of the for loop without
		 * changing the value of base.
		 */
		double result = 1;
		for(int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	/* factorial() multiplies an input by every integer
	 * less than the input and greater than 0.
	 */
	public static int factorial(int input) {
		/* An IllegalArgumentException will be
		 * thrown when the input is less than 0
		 * because this method does not support
		 * negative inputs.
		 */
		if(input < 0) {
			throw new IllegalArgumentException();
		}
		/* A variable is declared to store the result
		 * of each iteration of the for loop without
		 * changing the value of input.
		 */
		int result = input;
		for(int i = 1; i < input; i++) {
			result *= input - i;
		}
		return result;
	}
	//isPrime() checks whether or not the input is prime.
	public static boolean isPrime(int input) {
		//0 and 1 are not prime numbers.
		if(input < 2) {
			return false;
		//2 is a prime number.
		} else if(input == 2) {
			return true;
		/* The for loop calls isDivisibleBy()
		 * for every integer less than input
		 * starting at 2.
		 */
		} else {
			for(int i = 2; i < input; i++) {
				if(isDivisibleBy(input, i)) {
					return false;
				}
			}
			/* If an input is not divisible by
			 * any integer less than itself and
			 * greater than 1, it must be a
			 * prime number.
			 */
			return true;
		}
	}
	//gcf() evaluates the greatest common factor of two numbers.
	public static int gcf(int num1, int num2) {
		/* i is declared before the for loop because
		 * it must be returned after the loop.
		 */
		int i;
		/* i can be initialized as either of
		 * the two inputs because any number
		 * greater than the smaller of the two
		 * is inherently invalid. The for loop
		 * continues while one of the numbers
		 * is not divisible by i.
		 */
		for(i = num2; !(isDivisibleBy(num2, i) && isDivisibleBy(num1, i)); i--) {}
		return i;
	}
	//sqrt() uses Newton's formula to approximate the square root.
	public static double sqrt(double input) {
		/* An IllegalArgumentException will be
		 * thrown when the input is less than 0
		 * because you cannot square root
		 * negative numbers.
		 */
		if(input < 0) {
			throw new IllegalArgumentException();
		}
		/* The approximation is defined as half
		 * of the input arbitrarily.
		 */
		double approx = input/2;
		/* A variable is declared to store the result
		 * of each iteration of the while loop without
		 * changing the value of input.
		 */
		double result = 0;
		if(input != 0) {
			/* The while loop continues until the result
			 * and the next result are identical to
			 * the computer.
			 */
			while(result != (input/approx + approx)/2) {
				result = (input/approx + approx)/2;
				approx = result;
			}
		}
		return round2(result);
	}
	/* quadForm() uses the coefficients of the standard form
	 * of a quadratic function to calculate its roots.
	 */
	public static String quadForm(int a, int b, int c) {
		/* The quadratic function has no
		 * roots when the discriminant
		 * is negative.
		 */
		if(discriminant(a, b, c) < 0) {
			return "no real roots";
		} else {
			/* Variables are declared to store the values of the calculated
			 * roots when you add or subtract the square root of the
			 * discriminant.
			 */
			double plusResult = (-b + sqrt(discriminant(a, b, c)))/(2 * a);
			double minusResult = (-b - sqrt(discriminant(a, b, c)))/(2 * a);
			
			/* If the two results are not equal
			 * then the quadratic function has two
			 * unique roots.
			 */
			if(plusResult != minusResult) {
				/* max() is called to evaluate which of the two roots is
				 * greater, and to return a different order based
				 * on the result.
				 */
				if(max(plusResult, minusResult) == plusResult) {
					return round2(minusResult) + " and " + round2(plusResult);
				} else {
					return round2(plusResult) + " and " + round2(minusResult);
				}
			/* Otherwise the quadratic function only
			 * has one unique root. plusResult was
			 * chosen arbitrarily for this.
			 */
			} else {
				return round2(plusResult) + "";
			}
		}
	}
}