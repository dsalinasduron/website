import static org.junit.Assert.*;

import org.junit.Test;


public class TestMaxHeap {

	@Test
	public void testAdd() {
		HeapInterface<Integer> heap = new MaxHeap<Integer>();

		heap.add(1);
		heap.add(9);
		heap.add(3);
		heap.add(11);
		heap.add(5);
		heap.add(13);
		heap.add(7);

		assertEquals(7, heap.getSize());
		assertFalse(heap.isEmpty());

		assertEquals(new Integer(13), heap.front());	
	}
	
	@Test
	public void testStressfulAdd() {
		HeapInterface<Integer> heap = new MaxHeap<Integer>();
		
		for (int i = 0; i < 100; i++) {
			heap.add(i);
		}
		
		assertEquals(100, heap.getSize());
		assertFalse(heap.isEmpty());
		assertEquals(new Integer(99), heap.front());
	}

	@Test
	public void testRemove() {
		HeapInterface<Integer> heap; 
		
		// removal of a heap of size 1
		heap = new MaxHeap<Integer>();
		
		heap.add(1);
		assertEquals(new Integer(1), heap.front());
		assertEquals(new Integer(1), heap.remove());
		assertTrue(heap.isEmpty());
		assertEquals(0, heap.getSize());
		
		// removal of a heap of size 2
		heap = new MaxHeap<Integer>();
		
		heap.add(1);
		heap.add(2);
		assertEquals(new Integer(2), heap.front());
		assertEquals(new Integer(2), heap.remove());
		assertEquals(new Integer(1), heap.front());
		assertEquals(new Integer(1), heap.remove());
		assertTrue(heap.isEmpty());
		assertEquals(0, heap.getSize());
		
		// removal of a heap of size 3
		heap = new MaxHeap<Integer>();
		
		heap.add(1);
		heap.add(2);
		heap.add(3);
		assertEquals(new Integer(3), heap.front());
		assertEquals(new Integer(3), heap.remove());
		assertEquals(new Integer(2), heap.front());
		assertEquals(new Integer(2), heap.remove());
		assertEquals(new Integer(1), heap.front());
		assertEquals(new Integer(1), heap.remove());
		assertTrue(heap.isEmpty());
		assertEquals(0, heap.getSize());

		// removal of a randomly constructed heap
		heap = new MaxHeap<Integer>();
		
		heap.add(1);
		heap.add(9);
		heap.add(3);
		heap.add(11);
		heap.add(5);
		heap.add(13);
		heap.add(7);

		assertEquals(7, heap.getSize());
		assertFalse(heap.isEmpty());

		assertEquals(new Integer(13), heap.front());
		assertEquals(new Integer(13), heap.remove());
		
		assertEquals(new Integer(11), heap.front());
		assertEquals(new Integer(11), heap.remove());
		
		assertEquals(new Integer(9), heap.front());
		assertEquals(new Integer(9), heap.remove());
		
		assertEquals(new Integer(7), heap.front());
		assertEquals(new Integer(7), heap.remove());
		
		assertEquals(new Integer(5), heap.front());
		assertEquals(new Integer(5), heap.remove());
		
		assertEquals(new Integer(3), heap.front());
		assertEquals(new Integer(3), heap.remove());
		
		assertEquals(new Integer(1), heap.front());
		assertEquals(new Integer(1), heap.remove());

		assertEquals(0, heap.getSize());
		assertTrue(heap.isEmpty());
	}

}
