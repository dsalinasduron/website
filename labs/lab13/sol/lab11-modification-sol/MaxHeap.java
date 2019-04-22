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
	private int currentIndex;
	private static final int DEFAULT_CAPACITY = 10;
	private int capacity;

	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		this.capacity = capacity;
		elements = (T[]) new Comparable[capacity + 1];
		currentIndex = 0;
	}

	public void add(T item) {
		ensureCapacity();

		++currentIndex;

		int parentIndex = getParentIndex(currentIndex);
		int insertedIndex = currentIndex;

		while ( (parentIndex > 0) && (item.compareTo(elements[parentIndex]) > 0) ) {
			elements[insertedIndex] = elements[parentIndex];
			insertedIndex = parentIndex;
			parentIndex = getParentIndex(parentIndex);
		}

		elements[insertedIndex] = item;
	}

	// returns the index of the parent
	private int getParentIndex(int index) {
		return index / 2;
	}

	// returns the index of the left child
	private int getLeftChildIndex(int index) {
		return index * 2;
	}

	// returns the index of the right child
	private int getRightChildIndex(int index) {
		return (index * 2) + 1;
	}

	public T remove() {
		T root = null;

		if (!isEmpty()) {
			root = elements[1];
			elements[1] = elements[currentIndex];
			currentIndex--;

			reheap();
		}

		return root;
	}

	// rebuilds the heap after a remove
	private void reheap() {
		boolean done = false;

		int leftChild = getLeftChildIndex(1);
		int rightChild;
		int largerIndex;

		int index = 1;
		T rootValue = elements[1];

		while ((!done) && (leftChild <= currentIndex) ) {
			leftChild = getLeftChildIndex(index);
			rightChild = getRightChildIndex(index);

			// assume larger child is on the left
			largerIndex = leftChild;

			// if there is a right child
			if (rightChild <= currentIndex) {
				if (elements[rightChild].compareTo(elements[leftChild]) > 0)
					largerIndex = rightChild;
			}

			// now compare to the larger of the two children
			if (largerIndex <= currentIndex) {
				if (rootValue.compareTo(elements[largerIndex]) < 0) {
					elements[index] = elements[largerIndex];
					index = largerIndex;
				}
				else {
					done = true;
				}
			}
		}

		elements[index] = rootValue;
	}

	public T front() {
		if (!isEmpty())
			return elements[1];
		else
			return null;
	}

	public boolean isEmpty() {
		return (currentIndex == 0);
	}

	public int getSize() {
		return currentIndex;
	}

	private void ensureCapacity() {
		if (currentIndex == capacity) {
			capacity = capacity * 2;
			elements = java.util.Arrays.copyOf(elements, 2 * elements.length);
		}
	}
}
