import java.util.Arrays;

@SuppressWarnings("unchecked")

public class ArrayQueue<T> implements Queue<T> {
	private final static int DEFAULT_CAPACITY = 25;
	private final static int MULTIPLIER = 2;
	
	private T[] elements;
	private int front, rear, numberOfElements;
	
	public ArrayQueue(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("Capacity must be >= 0");

		elements = (T[]) new Object[capacity];
		
		front = 0; 
		rear = 0;
		numberOfElements = 0;
	}

	@Override
	public void add(T item) {
		ensureCapacity();
		
		elements[rear] = item;
		
		if (rear == (elements.length - 1))
			rear = 0;
		else
			rear++;
		
		numberOfElements++;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (numberOfElements == 0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return numberOfElements;
	}
	
	/**
	 * If the queue is full, double the size of the array
	 */
	private void ensureCapacity() {
		if (numberOfElements == elements.length - 1) {
			elements = Arrays.copyOf(elements, MULTIPLIER * elements.length);
		}
	}

}
