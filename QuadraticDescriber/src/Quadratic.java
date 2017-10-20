/**
 * Responsible for calculations used to describe a quadratic function.
 * @author Eric Xiao
 * @date September 22, 2017
 * @pseudocode
 * quadrDescriber outputs String and accepts 3 doubles (a, b, c).
 * Declare 3 Strings to store three describing sentences.
 * if coefficient of x^2 (a) is positive it points up otherwise points down.
 * vertex X coordinate calculated using -b/(2a).
 * vertex Y coordinate calculated using vertex X and putting that back into the function.
 * use modified quadForm() to find x intercepts as a String.
 * quadForm uses discriminant(), sqrt(), round2(), and max().
 * y intercept is always c in standard form because x = 0.
 * return all of the line Strings combined.
 */
public class Quadratic {
	/**
	 * Assembles a String to describe the orientation, vertex,
	 * and intercepts of a quadratic function.
	 * @param a Coefficient of x^2 term
	 * @param b Coefficient of x term
	 * @param c Coefficient of x^0 term
	 * @return a String that describes a quadratic function.
	 */
	public static String quadrDescriber(double a, double b, double c) {
		String equation, line1, line2, line3;
		equation = "Description of the graph of:\n"
					+ "y = " + a + "x^2 + " + b + "x + " + c + "\n";
		/* If x^2 term is positive then the quadratic
		 * graph opens upward, otherwise opens
		 * downward. Does not account for a == 0.
		 */
		if(a > 0) {
			line1 = "The parabola opens upward.\n";
		} else {
			line1 = "The parabola opens downward.\n";
		}
		/* Uses -b/2a to find the x-coordinate of the
		 * vertex, then uses the quadratic function
		 * to find the y-coordinate of the vertex.
		 */
		double vertexX = -b / (2 * a);
		double vertexY = a * vertexX * vertexX + b * vertexX + c;
		line2 = "The axis of symmetry is x = " + round2(vertexX) + ".\n"
				+ "The parabola has a vertex at (" + round2(vertexX) + ", " + round2(vertexY) + ").\n";
		/* Calls quadForm() to calculate the roots of
		 * the quadratic function to use as x-intercepts
		 * and finds the y-value of the quadratic function
		 * at x = 0 to use as the y-intercept.
		 */
		String interceptX = quadForm(a, b, c);
		double interceptY = c;
		line3 = "The parabola has " + interceptX + " and a y-intercept at (0, " + interceptY + ").";
		return equation + line1 + line2 + line3;
	}
	public static double discriminant(double a, double b, double c) {
		return b * b - 4 * a * c;
	}
	public static double sqrt(double input) {
		if(input < 0) {
			throw new IllegalArgumentException();
		}
		double approx = input/2;
		double result = 0;
		if(input != 0) {
			while(result != (input/approx + approx)/2) {
				result = (input/approx + approx)/2;
				approx = result;
			}
		}
		return round2(result);
	}
	public static double round2(double input) {
		if(input * 1000 % 10 < 5) {
			return ((input * 1000) - (input * 1000 % 10))/1000;
		} else {
			return ((input * 1000) + (10 - (input * 1000 % 10)))/1000;
		}
	}
	public static double max(double input1, double input2) {
		if(input1 > input2) {
			return input1;
		} else {
			return input2;
		}
	}
	/**
	 * quadForm from Calculate Library has been modified to
	 * return a String
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static String quadForm(double a, double b, double c) {
		if(discriminant(a, b, c) < 0) {
			return "no x-intercepts";
		} else {
			double plusResult = (-b + sqrt(discriminant(a, b, c)))/(2 * a);
			double minusResult = (-b - sqrt(discriminant(a, b, c)))/(2 * a);
			
			if(plusResult != minusResult) {
				if(max(plusResult, minusResult) == plusResult) {
					return "x-intercepts at (" + round2(minusResult) + ", 0) and (" + round2(plusResult) + ", 0)";
				} else {
					return "x-intercepts at (" + round2(plusResult) + ", 0) and (" + round2(minusResult) + ", 0)";
				}
			} else {
				return "an x-intercept at (" + round2(plusResult) + ", 0)";
			}
		}
	}
	
}
