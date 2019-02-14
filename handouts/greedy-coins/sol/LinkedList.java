/**
 * Implementation of the List interface.
 * 
 * This implementation involves a single-linked list.
 * 
 * @author Greg Gagne - February 2017
 *
 */
public class LinkedList<T> implements List<T> {
	// reference to the head of the linked list
	private Node head;

	// number of elements in the list
	private int numberOfElements;

	public LinkedList() {
		head = null;
	}

	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next;

		private Node(T data) {
			this(data,null);
		}

		private Node (T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// Methods

	@Override
	public void add(T item) {
		
		Node newNode = new Node(item);
		Node current = head;

		if (isEmpty()) {
			// special case - first element being added to the list
			head = newNode;
		}
		else {
			while (current.next != null) {
				current = current.next;
			}

			// current now references the last item in the list
			current.next = newNode;
		}

		newNode.next = null;
		++numberOfElements;
	}

	@Override
	public boolean add(T item, int index) {
		boolean rv = true;
		
		
		if (index > numberOfElements) {
			rv = false;
		}
		else if (index == 0) {
			// special case - first element
			Node newNode = new Node(item);
			newNode.next = head;
			head = newNode;
		}
		else {
			// navigate to the correct location
			Node newNode = new Node(item);
			int currentIndex = 0;
			Node current = head;
			
			while (currentIndex < (index - 1)) {
				current = current.next;
				currentIndex++;
			}
			
			// current references where we want to insert the node
			newNode.next = current.next;
			current.next = newNode;
		}
		
		numberOfElements++;
		
		return rv;
	}

	@Override
	public boolean contains(T item) {
		Node current = head;
		boolean found = false;

		while (current != null && !found) {
			if (current.data.equals(item)) {
				found = true;
			}

			current = current.next;
		}

		return found;

	}

	@Override
	public T get(int index) {
		T element = null;

		if (index < numberOfElements) {
			int position = 0;
			Node current = head;

			while (position < index) {
				current = current.next;
				position++;
			}

			element = current.data; 
		}

		return element;
	}

	@Override
	public boolean remove(T item) {
		boolean rv = false;

		if (isEmpty()) {
			rv = false;
		}
		else if (head.data.equals(item)) {
			rv = true;
			head = head.next;
			numberOfElements--;
		}
		else if (getLength() > 1) {
			Node current = head;

			while ( current.next != null && !(current.next).data.equals(item) ) {
				current = current.next;
			}

			if (current.next != null) {
				// current references the node we want to remove
				rv = true;
				current.next = current.next.next;
				numberOfElements--;
			}
		}

		return rv;
	}

	@Override
	public T remove(int index) {
		T rv = null;

		if (isEmpty() || index >= numberOfElements) {
			rv = null;
		}
		else if (index == 0) {
			// special case - first element in the list
			rv = head.data;
			head = head.next;
			numberOfElements--;
		}
		else {
			int currentIndex = 0;
			Node current = head;

			while (currentIndex < (index - 1)) {
				current = current.next;
				currentIndex++;
			}

			// current references the node we want to remove
			rv = current.next.data;
			current.next = current.next.next;
			numberOfElements--;
		}

		return rv;
	}

	@Override
	public int getLength() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	@Override
	public int getFrequency(T item) {
		int rv = 0;
		
		Node current = head;
		
		while (current != null) {
			if (current.data.equals(item)) {
				++rv;
			}
			
			current = current.next;
		}
		
		return rv;
	}

	@Override
	public void clear() {
		head = null;
	}

}
