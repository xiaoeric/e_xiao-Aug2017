/* Write this concrete (non-abstract) class called Cylinder that extends Prism.  
 * It has a private field (radius) and inherits its height from its superclass, Prism 
 *    (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

/**
 * @author Eric Xiao
 * @date 2/21/2018
 * @period 2
 */
public class Cylinder extends Prism
{
	private double radius;
	
	public Cylinder(double radius, double height) {
		super(height);
		this.radius = radius;
	}

	@Override
	public double calcAreaOfBase() {
		return Math.pow(radius, 2) * Math.PI;
	}

	@Override
	public double calcPerimeter() {
		return radius * 2 * Math.PI;
	}
}
