/*
 * @Destin West
 * @Max Harper
 * @August 31st
 * 
 * This class creates an object with three points, representing dimensions
 */
public class ThreeDimensionalPoint {
	private double x, y, z;

	public ThreeDimensionalPoint() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}
	public ThreeDimensionalPoint(double x,double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	//shifts 'x' right or left the desired 'amount'
	public double shiftX(double amount) {
		this.x = x + amount;
		return x;
	}
	//shifts 'y' right or left the desired 'amount'
	public double shiftY(double amount) {
		this.y = y + amount;
		return y;
	}
	//shifts 'z' right or left the desired 'amount'
	public double shiftZ(double amount) {
		this.z = z + amount;
		return z;
	}
	//rotates 'y' and 'z' while 'x' remains stationary
	public void rotateX(double theta) {
		//this.x = x;
		this.y = (y * Math.cos(theta)) - (z * Math.sin(theta));
		this.z = (y * Math.sin(theta)) + (z * Math.cos(theta));
	}
	//rotates 'x' and 'z' while 'y' remains stationary
	public void rotateY(double theta) {
		//this.y = y;
		this.x = (x * Math.cos(theta)) + (z * Math.sin(theta));
		this.z = ((-x) * Math.sin(theta)) + (z * Math.cos(theta));
	}
	//rotates 'x' and 'y' while 'z' remains stationary
	public void rotateZ(double theta) {
		//this.z = z;
		this.x = (x * Math.cos(theta)) - (y * Math.sin(theta));
		this.y = (x * Math.sin(theta)) + (y * Math.cos(theta));

	}
}
