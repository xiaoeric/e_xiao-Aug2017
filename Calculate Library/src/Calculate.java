/*Eric Xiao
 * September 6, 2017
 * Our self written math library
 * It contains a series of methods to do basic math functions.
 */
public class Calculate {
	public static int square(int input) {
		return input*input;
	}
	public static int cube(int input) {
		return input*input*input;
	}
	public static double average(double input1, double input2) {
		return (input1 + input2)/2;
	}
	public static double average(double input1, double input2, double input3) {
		return (input1 + input2 + input3)/3;
	}
	public static double toDegrees(double input) {
		return input / 3.141589 * 180;
	}
	public static double toRadians(double input) {
		return input / 180 * 3.14159;
	}
	public static double discriminant(double a, double b, double c) {
		return b * b - 4 * a * c;
	}
	public static String toImproperFrac(int wholeNum, int numerator, int denominator) {
		return (wholeNum * denominator + numerator) + "/" + denominator;
	}
	public static String toMixedNum(int numerator, int denominator) {
		return (numerator / denominator) + "_" + numerator % denominator + "/" + denominator;
	}
	public static String foil(int coeff1, int num1, int coeff2, int num2, String variable) {
		String firstTerm = (coeff1 * coeff2) + variable + "^2";
		String secondTerm;
		if(num1 * coeff2 + num2 * coeff1 < 0) {
			secondTerm = " - " + -(num1 * coeff2 + num2 * coeff1) + variable;
		} else if(num1 * coeff2 + num2 * coeff1 > 0) {
			secondTerm = " + " + (num1 * coeff2 + num2 * coeff1) + variable;
		} else {
			secondTerm = "";
		}
		String thirdTerm;
		if(num1 * num2 < 0) {
			thirdTerm = " - " + -(num1 * num2);
		} else if(num1 * num2 > 0){
			thirdTerm = " + " + (num1 * num2);
		} else {
			thirdTerm = "";
		}
		return firstTerm + secondTerm + thirdTerm;
	}
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if(divisor == 0) {
			throw new ArithmeticException();
		}
		if(dividend % divisor == 0) {
			return true;
		} else {
			return false;
		}
	}
	public static double absValue(double input) {
		if(input < 0) {
			return -input;
		} else {
			return input;
		}
	}
	public static double max(double input1, double input2) {
		if(input1 > input2) {
			return input1;
		} else {
			return input2;
		}
	}
	public static double max(double input1, double input2, double input3) {
		if(input1 > input2 && input1 > input3) {
			return input1;
		} else if(input2 > input3) {
			return input2;
		} else {
			return input3;
		}
	}
	public static int min(int input1, int input2) {
		if(input1 < input2) {
			return input1;
		} else {
			return input2;
		}
	}
	public static double round2(double input) {
		if(input * 1000 % 10 < 5) {
			return ((input * 1000) - (input * 1000 % 10))/1000;
		} else {
			return ((input * 1000) + (10 - (input * 1000 % 10)))/1000;
		}
	}
	public static double exponent(double base, int exponent) {
		if(exponent < 0) {
			throw new ArithmeticException();
		}
		double result = 1;
		for(int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	public static int factorial(int input) {
		if(input < 0) {
			throw new ArithmeticException();
		}
		int result = input;
		for(int i = 1; i < input; i++) {
			result *= input - i;
		}
		return result;
	}
	public static boolean isPrime(int input) {
		if(input < 2) {
			return false;
		} else if(input == 2) {
			return true;
		} else {
			for(int i = 2; i < input; i++) {
				if(isDivisibleBy(input, i)) {
					return false;
				}
			}
			return true;
		}
	}
	public static int gcf(int num1, int num2) {
		int i;
		for(i = num2; !(isDivisibleBy(num2, i) && isDivisibleBy(num1, i)); i--) {}
		return i;
	}
	public static double sqrt(double input) {
		if(input < 0) {
			throw new ArithmeticException();
		}
		double approx = input/2;
		double result = 0;
		while(result != (input/approx + approx)/2) {
			result = (input/approx + approx)/2;
			approx = result;
		}
		return round2(result);
	}
	public static String quadForm(int a, int b, int c) {
		if(discriminant(a, b, c) < 0) {
			return "no real roots";
		} else {
			double plusResult = (-b + sqrt(discriminant(a, b, c)))/2;
			double minusResult = (-b - sqrt(discriminant(a, b, c)))/2;
			
			if(plusResult != minusResult) {
				if(max(plusResult, minusResult) == plusResult) {
					return round2(minusResult) + " and " + round2(plusResult);
				} else {
					return round2(plusResult) + " and " + round2(minusResult);
				}
			} else {
				return round2(plusResult) + "";
			}
		}
	}
}