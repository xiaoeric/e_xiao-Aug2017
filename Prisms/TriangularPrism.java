/* Write this concrete (non-abstract) class called TriangularPrism.  
 * It has 3 private fields (sideA, sideB, and sideC).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 * 
 * Math Note:
 * Perimeter refers to the perimeter of the base - the sum of all the sides.
 * To find the area of a triangle given 3 side lengths, look up Heron's formula.  
 * It uses half the perimeter.  (Why might you want to use 0.5 instead of 1/2?)
 */

/**
 * @author Eric Xiao
 * @date 2/21/2018
 * @period 2
 */
public class TriangularPrism extends Prism
{
	private double sideA;
	private double sideB;
	private double sideC;

	public TriangularPrism(double A, double B, double C, double height) {
		super(height);
		sideA = A;
		sideB = B;
		sideC = C;
	}

	@Override
	public double calcAreaOfBase() {
		double semi = calcPerimeter() / 2.0;
		return Math.sqrt((semi) * (semi - sideA) * (semi - sideB) * (semi - sideC));
	}

	@Override
	public double calcPerimeter() {
		return sideA + sideB + sideC;
	}
}
