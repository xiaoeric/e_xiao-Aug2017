/**
 * @author Eric Xiao
 * @date 2/21/2018
 * @period 2
 */
public class Sphere extends ThreeDShape {
	private double radius;
	
	public Sphere(double r){
		radius = r;
	}

	@Override
	public double calcVolume() {
		return (4 * Math.PI / 3) * Math.pow(radius, 3);
	}

	@Override
	public double calcSA() {
		return (4 * Math.PI) * Math.pow(radius, 2);
	}

}
