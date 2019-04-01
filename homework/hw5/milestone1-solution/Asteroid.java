/**
 * Asteroid.java
 * 
 * Simple representation of an Asteroid object.
 */
import java.awt.Color;
import java.awt.Graphics;

public class Asteroid extends Polygon {

	public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
	}

	@Override
	public void paint(Graphics brush, Color color) {
		Point[] pts = getPoints();
		int xPts[] = new int[pts.length];
		int yPts[] = new int[pts.length];
		
		// populate the x and y coordinates of th given point
		for (int i = 0; i < pts.length; i++) {
			xPts[i] = (int)pts[i].x;
			yPts[i] = (int)pts[i].y;
		}
		
		brush.drawPolygon(xPts, yPts, pts.length);
	}

	@Override
	public void move() {
		// moves the specified asteroid arbitrarily by units along x axis. 
		position.x += 5;
	}

}
