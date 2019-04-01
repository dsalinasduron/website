/**
 *
 * Created by alex on 9/7/16.
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Ship extends Polygon {

    public Ship(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }

    // ADDED BY ALEX
    
    public void move() {
        
        position.x += 5;

 if(position.x > Asteroids.SCREEN_WIDTH) {
            position.x -= Asteroids.SCREEN_WIDTH;
        } else if(position.x < 0) {
            position.x += Asteroids.SCREEN_WIDTH;
        }
        if(position.y > Asteroids.SCREEN_HEIGHT) {
            position.y -= Asteroids.SCREEN_HEIGHT;
        } else if(position.y < 0) {
            position.y += Asteroids.SCREEN_HEIGHT;
        }
       
        
    }

    // ADDED BY ALEX
    // Create paint method to paint a ship
    public void paint(Graphics brush, Color color) {
        Point[] points = getPoints();
        int[] xPoints = new int[points.length];
        int[] yPoints = new int[points.length];
        int nPoints = points.length;
        for(int i = 0; i < nPoints; ++i) {
            xPoints[i] = (int) points[i].x;
            yPoints[i] = (int) points[i].y;
        }
        brush.setColor(color);
        brush.fillPolygon(xPoints, yPoints, nPoints);
    }
}
