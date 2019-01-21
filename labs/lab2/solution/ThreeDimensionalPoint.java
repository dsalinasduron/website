/**
 * A class that represents a three dimensional point.
 *
 * @author greg
 *
 */
public class ThreeDimensionalPoint {
	private double x;
	private double y;
	private double z;
	
	public ThreeDimensionalPoint() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public ThreeDimensionalPoint(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

    /**
     * Appropriate getter methods.
     */	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}

    /**
     * Methods that shift either the x, y, or z coordinate
     */	
	public double shiftX(double amount) {
		this.x += amount;
		
		return this.x;
	}
	
	public double shiftY(double amount) {
		this.y += amount;
		
		return this.y;
	}
	
	public double shiftZ(double amount) {
		this.z += amount;
		
		return this.z;
	}

    /** 
     * Rotations around the three axis. 
     * Note: theta is specified in radians.
     */	
	public void rotateX(double theta) {
		double yPrime = y * Math.cos(theta) - z * Math.sin(theta);
		z = y * Math.sin(theta) + z * Math.cos(theta);
        y = yPrime;
	}
	
	public void rotateY(double theta) {
		double xPrime = x * Math.cos(theta) + z * Math.sin(theta);
		z = -x * Math.sin(theta) + z * Math.cos(theta);
        x = xPrime;
	}
	
	public void rotateZ(double theta) {
		double xPrime = x * Math.cos(theta) - y * Math.sin(theta);
		y = x * Math.sin(theta) + y * Math.cos(theta);
        x = xPrime;
	}
	
	public String toString() {
		return "x = " + x + " y = " + y + " z = " + z;
	}
}
