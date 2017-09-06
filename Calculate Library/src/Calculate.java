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
		return (coeff1 * coeff2) + variable + "^2" + " + " + (num1 * coeff2 + num2 * coeff1) + variable + " + " + (num1 * num2);
	}
}
