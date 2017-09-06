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
	}
}
