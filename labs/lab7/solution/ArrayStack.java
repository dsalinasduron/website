/**
 * ArrayStack.java
 * 
 * Array-based implementation of Stack interface
 * 
 * @author Greg Gagne
 */

import java.util.Arrays;

@SuppressWarnings("unchecked")

public class ArrayStack<T> implements Stack<T> {
	private int stackTop;
	private T[] elements;
	
	private final static int DEFAULT_CAPACITY = 25;
	private final static int MULTIPLIER = 2;
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("Capacity must be >= 0");

		elements = (T[]) new Object[capacity];

		stackTop = -1;
	}

	/**
	 * Pushes item onto stack top
	 */
	public void push(T item) {
		ensureCapacity();
		stackTop++;
		
		elements[stackTop] = item;
	}

	/**
	 * Removes and returns the item at the top of the stack
	 *
	 * If the stack is empty, returns null
	 */
	public T pop() {
		T top = null;
		
		if (!isEmpty()) {
			top = elements[stackTop];
			stackTop--;
		}
		
		return top;
	}

	/**
	 * Returns (but does not remove) the item at the top of the stack
	 *
	 * If the stack is empty, returns null
	 */
	public T peek() {
		T top = null;
		
		if (!isEmpty()) {
			top = elements[stackTop];
		}
		
		return top;
	}

	/**
	 * Returns true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (stackTop == -1);
	}

	/**
	 * Returns the number of elements in the stack
	 */
	public int size() {
		return (stackTop + 1);
	}

	/**
	 * If the stack is full, double the size of the array
	 */
	private void ensureCapacity() {
		if (stackTop == elements.length - 1) {
			elements = Arrays.copyOf(elements, MULTIPLIER * elements.length);
		}
	}

}
