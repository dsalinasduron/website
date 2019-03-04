/**
 * A JPanel for drawing a circle.
 */
 
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class CirclePanel extends JPanel
{
    /**
     * invoked when the application first starts
     */
    public void paintComponent( Graphics g )
    {
      drawCircles(g, 50, 10, 240, 320, 110, 8);
    }

    /**
     * This method draws a circle by drawing an oval.
     *
     * @param x - the x coordinate of the upper lefth and corner of the oval
     * @param y - the y coordinate of the upper lefth and corner of the oval
     * @param width - the width of the oval
     * @param height - the height of the oval
     * @param radius - the radius of the circle
     * @param colorLevel - the color to be drawn
     */
    private void drawCircles( Graphics g, int x, int y, int width, int height, int radius, int colorLevel)
    {
        if( radius < 0)
            return;


        // sets the color of the circles
        // this technique will work with the recursive solution
        switch(colorLevel) {
          case 8:
            g.setColor(Color.red);
            break;
          case 4:        
            g.setColor(Color.blue);
            break;        
          case 2:
            g.setColor(Color.black);
            break;        
          case 1:
            g.setColor(Color.yellow);
            break;
        }
        
        if (colorLevel == 1)
          colorLevel = 8;
        else
          colorLevel /= 2;
        
        // iterative solution
        
        do {
            g.drawOval(width/2 - radius, height/2 - radius,  2*radius, 2*radius);

            radius -= 20;
        }
        while (radius > 0);
        
         
        // recursive solution
         // g.drawOval(width/2 - radius, height/2 - radius,  2*radius, 2*radius);
         // drawCircles(g, width/2 - radius, height/2 - radius,  width, height, radius-20, colorLevel);
        
    }
}
