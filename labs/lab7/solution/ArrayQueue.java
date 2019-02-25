import java.util.Arrays;

@SuppressWarnings("unchecked")

public class ArrayQueue<T> implements Queue<T> {
	private final static int DEFAULT_CAPACITY = 6;
	private final static int MULTIPLIER = 2;
	
	private T[] elements;
	private int front, rear, numberOfElements;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
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
		T element = null;
		
		if (!isEmpty()) {
			element = elements[front];
			
			if (front == (elements.length -1))
				front = 0;
			else
				front++;
			
			numberOfElements--;
		}
		
		return element;
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
		if (size() == elements.length) {
			System.out.println("resizing array");
			T[] newArray = (T[])new Object[(numberOfElements + 1) * MULTIPLIER];
			
			// now copy array from old queue to the new array
			int f = front;
			for (int i = 0; i < numberOfElements; i++) {
				newArray[i] = elements[f];
				
				if (f == elements.length - 1)
					f = 0;
				else
					f++;
			}
			
			elements = newArray;
			
			// reset front and rear
			front = 0;
			rear = numberOfElements;
		}
	}

}
