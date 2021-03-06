/*Eric Xiao
 * September 6, 2017
 * This is the runner for the calculate library. It is used to test the methods in Calculate.
 */
public class DoMath {
	public static void main(String[] args) {
		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(5));
		System.out.println(Calculate.average(5, 8));
		System.out.println(Calculate.average(5, 8, 11));
		System.out.println(Calculate.toDegrees(3.14159));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1, -2, 4));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.foil(2, 3, 6, -7, "n"));
		System.out.println(Calculate.isDivisibleBy(8, 4));
		System.out.println(Calculate.absValue(-10));
		System.out.println(Calculate.max(1, 2));
		System.out.println(Calculate.max(2, 1, 3));
		System.out.println(Calculate.min(1, 2));
		System.out.println(Calculate.round2(0.6789));
		System.out.println(Calculate.exponent(2, 4));
		System.out.println(Calculate.factorial(5));
		System.out.println(Calculate.isPrime(24));
		System.out.println(Calculate.gcf(46, 23));
		System.out.println(Calculate.sqrt(4));
		System.out.println(Calculate.quadForm(1, -4, 4));
	}
}
