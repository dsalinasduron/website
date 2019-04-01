
/*
CLASS: AsteroidsGame
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
 */
import java.awt.*;
import java.awt.event.*;

public class Asteroids extends Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	static int counter = 0;
	
	// Asteroid objects
	private Asteroid a1, a2, a3;

	public Asteroids() {
		super("Asteroids!",800,600);
		this.setFocusable(true);
		this.requestFocus();

		// create the Asteroids
		Point[] pts = new Point[4];
		pts[0] = new Point(0,0);
		pts[1] = new Point (50,50);
		pts[2] = new Point(100,100);
		pts[3] = new Point(15,150);

		Point origin = new Point(250,250);

		a1 = new Asteroid(pts, origin, 0.0);
		
		Point[] pts2 = new Point[4];
		pts2[0] = new Point(100,100);
		pts2[1] = new Point(100,200);
		pts2[2] = new Point(200,200);
		pts2[3] = new Point(200,100);

		Point origin2 = new Point(SCREEN_WIDTH-200,SCREEN_HEIGHT-200);

		a2 = new Asteroid(pts2,origin2,0);

		Point[] pts3 = new Point[5];

		pts3[0] = new Point(200,200);
		pts3[1] = new Point(200,300);
		pts3[2] = new Point(250,350);	
		pts3[3] = new Point(175,400);
		pts3[4] = new Point(175,200);

		Point origin3 = new Point(SCREEN_WIDTH/4,SCREEN_HEIGHT/4);

		a3 = new Asteroid(pts3,origin3,0);
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.setColor(Color.white);
		brush.drawString("Counter is " + counter,10,10);

		a1.paint(brush, Color.white);
		a2.paint(brush, Color.white);
		a3.paint(brush, Color.white);
		
		// move one of the Asteroid objects
		a3.move();
	}

	public static void main (String[] args) {
		Asteroids a = new Asteroids();
		a.repaint();
	}
}