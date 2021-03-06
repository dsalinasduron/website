/**
 * Implementation of the List interface.
 * 
 * This implementation involves a single-linked list.
 * 
 * @author Greg Gagne - February 2017
 *
 */
public class LinkedList implements List {
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
		private Object data;
		private Node next;

		private Node(Object data) {
			this(data,null);
		}

		private Node (Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// Methods

	@Override
	public void add(Object item) {
		/**
		 * This adds an element to the head of the list

		Node newNode = new Node(item);

        newNode.next = head;
        head = newNode;
        ++numberOfElements;
		 */

		Node newNode = new Node(item);
		Node current = head;

		if (!isEmpty()) {
			while (current.next != null) {
				current = current.next;
			}

			// current now references the last item in the list
			current.next = newNode;
		}
		else {
			// first element being added to the list
			head = newNode;
		}

		newNode.next = null;
		++numberOfElements;
	}

	@Override
	public boolean add(Object item, int index) {
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
	public boolean contains(Object item) {
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
	public Object get(int index) {
		Object element = null;

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
	public boolean remove(Object item) {
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
	public Object remove(int index) {
		Object rv = null;

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
	public int getFrequency(Object item) {
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
