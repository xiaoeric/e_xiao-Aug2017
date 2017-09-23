/*Eric Xiao
 * September 22, 2017
 * Responsible for calculations used to describe a quadratic function.
 */
public class Quadratic {
	public static void quadrDescriber(double a, double b, double c) {
		if(a > 0) {
			System.out.println("The parabola opens upward.");
		} else {
			System.out.println("The parabola opens downward.");
		}
		
		double vertexX = -b / (2 * a);
		double vertexY = a * vertexX * vertexX + b * vertexX + c;
		System.out.println("The parabola has a vertex at (" + vertexX + ", " + vertexY + ").");
		
		String interceptX = quadForm(a, b, c);
		double interceptY = c;
		System.out.println("The parabola has " + interceptX + " and a y-intercept at (0, " + interceptY + ").");
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
