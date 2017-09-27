/*Eric Xiao
 * September 22, 2017
 * Responsible for calculations used to describe a quadratic function.
 * 
 * Pseudocode:
 * quadrDescriber outputs String and accepts 3 doubles (a, b, c)
 * Declare 3 Strings to store three describing sentences
 * if coefficient of x^2 (a) is positive it points up otherwise points down
 * vertex X coordinate calculated using -b/(2a)
 * vertex Y coordinate calculated using vertex X and putting that back into the function
 * use modified quadForm() to find x intercepts as a String
 * quadForm uses discriminant(), sqrt(), round2(), and max()
 * y intercept is always c in standard form because x = 0
 * return all of the line Strings combined
 */
public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {
		String line1, line2, line3;
		if(a > 0) {
			line1 = "The parabola opens upward.\n";
		} else {
			line1 = "The parabola opens downward.\n";
		}
		
		double vertexX = -b / (2 * a);
		double vertexY = a * vertexX * vertexX + b * vertexX + c;
		line2 = "The parabola has a vertex at (" + vertexX + ", " + vertexY + ").\n";
		
		String interceptX = quadForm(a, b, c);
		double interceptY = c;
		line3 = "The parabola has " + interceptX + " and a y-intercept at (0, " + interceptY + ").";
		return line1 + line2 + line3;
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
