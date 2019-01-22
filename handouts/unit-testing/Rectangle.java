/**
 * Rectangle.java
 *
 * An object representation of a rectangle.
 *
 * @author Greg Gagne
 */

public class Rectangle
{
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width= width;
    }

    /**
     * Returns the area of a rectangle
     */
    public double area() {
        return 0;
    }

    /**
     * Returns the permimeter of a rectangle
     */
    public double perimeter() {
        return 0;
    }

    /**
     * Overrides java.lang.Object equals()
     */
    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other == this)
            return true;
        
        if (other instanceof Rectangle) {
            Rectangle candidate = (Rectangle)other;

            return ( (this.length == candidate.length) && (this.width == candidate.width) );
        }

        return false;
    }
}
