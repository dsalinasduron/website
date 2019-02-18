/**
 * Stack.java
 *
 * Interface specifying standard stack operations.
 *
 * @author Greg Gagne - September  2016
 */

public interface Stack<T>
{
	/**
	 * Pushes item onto stack top
	 */
	public void push(T item);

	/**
	 * Removes and returns the item at the top of the stack
	 *
	 * If the stack is empty, returns null
	 */
	public T pop();

	/**
	 * Returns (but does not remove) the item at the top of the stack
	 *
	 * If the stack is empty, returns null
	 */
	public T peek();

	/**
	 * Returns true if the stack is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in the stack
	 */
	public int size();
}
