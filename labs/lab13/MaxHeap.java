/**
 * MaxHeap.java
 * 
 * Implementation of the HeapInterface as a maximum heap (max heap)
 * 
 * @author [YOUR NAME GOES HERE]
 *
 * @param <T>
 */
public class MaxHeap <T extends Comparable<? super T>> implements HeapInterface<T> {
	private T[] elements;
	private static final int DEFAULT_CAPACITY = 10;

	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		elements = (T[]) new Comparable[capacity + 1];
	}

	public void add(T item) {
		
	}

	public T remove() {
		return null;
	}


	public T front() {
		return null;
	}

	public boolean isEmpty() {
		return false;
	}

	public int getSize() {
		return -1;
	}

	private void ensureCapacity() {
		// The following is a starting point
		elements = java.util.Arrays.copyOf(elements, 2 * elements.length);
	}
}
