/**
 * Unit tests to test implementation of Stack interface.
 */
import static org.junit.Assert.*;

import org.junit.Test;


public class TestStack {

	@Test
	public void testArrayStack() {
		
		Stack<String> s = new ArrayStack<String>();
		
		assertTrue(s.isEmpty());
		assertNull(s.peek());
		assertNull(s.pop());
		
		s.push("apple");
		s.push("banana");
		s.push("cherry");
		
		assertFalse(s.isEmpty());
		
		assertEquals("cherry", s.peek());
		assertEquals("cherry", s.pop());
		assertEquals("banana", s.peek());
		assertEquals("banana", s.pop());
		assertEquals("apple", s.peek());
		assertEquals("apple", s.pop());
		
		assertTrue(s.isEmpty());
		assertNull(s.pop());

		s.push("donut");

		assertFalse(s.isEmpty());

		assertEquals("donut", s.pop());
		
		// This should trigger re-siing the stack
		Stack<String> s2 = new ArrayStack<String>(3);
		
		s2.push("apple");
		s2.push("banana");
		s2.push("cherry");
		
		// following push requires resizing the stack
		s2.push("donut");
		s2.push("eggplant");
		s2.push("figs");
		
		assertEquals(6,s2.size());
		
		assertEquals("figs",s2.pop());
		assertEquals("eggplant",s2.pop());
		assertEquals("donut",s2.pop());
		assertEquals("cherry",s2.pop());
		assertEquals("banana",s2.pop());
		assertEquals("apple",s2.pop());
		
		assertEquals(0,s2.size());
		assertTrue(s2.isEmpty());
	}
	
	@Test
	public void testListStack() {
		
		Stack<String> s = new ListStack<String>();
		
		assertTrue(s.isEmpty());
		assertNull(s.peek());
		assertNull(s.pop());
		
		s.push("apple");
		s.push("banana");
		s.push("cherry");
		
		assertFalse(s.isEmpty());
		
		assertEquals("cherry", s.peek());
		assertEquals("cherry", s.pop());
		assertEquals("banana", s.peek());
		assertEquals("banana", s.pop());
		assertEquals("apple", s.peek());
		assertEquals("apple", s.pop());
		
		assertTrue(s.isEmpty());
		assertNull(s.pop());

		s.push("donut");

		assertFalse(s.isEmpty());

		assertEquals("donut", s.pop());
	}

}
