import static org.junit.Assert.*;

import org.junit.Test;


public class TestRectangle {

	@Test
	public void testEquals() {
		Rectangle r1 = new Rectangle(5,10);
		Rectangle r2 = new Rectangle(5,10);
		Rectangle r3 = new Rectangle(5,15);
		Rectangle r4 = new Rectangle(15,10);
		
		assertEquals(r1,r2);
		assertFalse(r1.equals(r3));
		assertFalse(r1.equals(r4));
	}
	
	@Test
	public void testArea() {
		Rectangle r1 = new Rectangle(5,10);
		assertEquals(50,r1.area(),0.001);
	}
	
	@Test
	public void testPerimeter() {
		Rectangle r1 = new Rectangle(5,10);
		assertEquals(30,r1.perimeter(),0.001);
	}

}
