/**
 *
 * Representation of what the ship shoots
 */
import java.awt.*;

public class Bullet extends Circle {
    private static final int RADIUS = 5;
    private double rotation;

    public Bullet(Point center, double rotation) {
        super(center, RADIUS);
        this.rotation = rotation;
    }

    public void move() {
        center.x += 4 * Math.cos(Math.toRadians(rotation));
        center.y += 4 * Math.sin(Math.toRadians(rotation));
    }

    public void paint(Graphics brush, Color color) {
        brush.setColor(color);
        brush.fillOval((int) center.x, (int) center.y, RADIUS, RADIUS);
    }

    public boolean outOfBounds() {
        return ( center.x < 0 || center.x > Asteroids.SCREEN_WIDTH ||  center.y < 0 || center.y > Asteroids.SCREEN_HEIGHT);
    }
}
