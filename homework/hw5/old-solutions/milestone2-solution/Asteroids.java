
/*
CLASS: AsteroidsGame
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Asteroids extends Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

   private static final int SHIP_WIDTH = 40;
    private static final int SHIP_HEIGHT = 25;

	static int counter = 0;
	

	private java.util.List<Asteroid> randomAsteroids = new ArrayList<Asteroid>();

  private Ship ship;

  public Asteroids() {
    super("Asteroids!",SCREEN_WIDTH,SCREEN_HEIGHT);
    this.setFocusable(true);
	this.requestFocus();

  // ADDED BY ALEX:
  randomAsteroids = createRandomAsteroids(10,60,30);

  ship = createShip();

  }
  
   // ADDED BY ALEX: Create an array of random asteroids
    private ArrayList<Asteroid> createRandomAsteroids(int numberOfAsteroids, int maxAsteroidWidth,
                                                      int minAsteroidWidth) {
        ArrayList<Asteroid> asteroids = new ArrayList<>(numberOfAsteroids);
        for(int i = 0; i < numberOfAsteroids; ++i) {
            // Create random asteroids by sampling points on a circle
            // Find the radius first.
            int radius = (int) (Math.random() * maxAsteroidWidth);
            if(radius < minAsteroidWidth) {
                radius += minAsteroidWidth;
            }
            // Find the circles angle
            double angle = (Math.random() * Math.PI * 1.0/2.0);
            if(angle < Math.PI * 1.0/5.0) {
                angle += Math.PI * 1.0/5.0;
            }
            // Sample and store points around that circle
            ArrayList<Point> asteroidSides = new ArrayList<Point>();
            double originalAngle = angle;
            while(angle < 2*Math.PI) {
                double x = Math.cos(angle) * radius;
                double y = Math.sin(angle) * radius;
                asteroidSides.add(new Point(x, y));
                angle += originalAngle;
            }
            // Set everything up to create the asteroid
            Point[] inSides = asteroidSides.toArray(new Point[asteroidSides.size()]);
            Point inPosition = new Point(Math.random() * SCREEN_WIDTH, Math.random() * SCREEN_HEIGHT);
            double inRotation = Math.random() * 360;
            asteroids.add(new Asteroid(inSides, inPosition, inRotation));
        }
        return asteroids;
    }

     // ADDED BY ALEX: Create dimensions of Ship 
    private Ship createShip() {
        // Look of ship
        Point[] shipShape = {
                new Point(0, 0),
                new Point(SHIP_WIDTH/3.5, SHIP_HEIGHT/2),
                new Point(0, SHIP_HEIGHT),
                new Point(SHIP_WIDTH, SHIP_HEIGHT/2)
        };
        // Set ship at the middle of the screen
        Point startingPosition = new Point((width-SHIP_WIDTH)/2, (height-SHIP_HEIGHT)/2);
        int startingRotation = 0; // Start facing to the right
        return new Ship(shipShape, startingPosition, startingRotation);
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

      for (Asteroid asteroid : randomAsteroids) {
        asteroid.paint(brush,Color.white);
        asteroid.move();
        
        }

        ship.paint(brush, Color.magenta);
        ship.move();
  }
  
	public static void main (String[] args) {
   		Asteroids a = new Asteroids();
		a.repaint();
  }
}