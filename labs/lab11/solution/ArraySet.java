import java.util.Iterator;

/**
 * An array-based set.
 *
 * This is a solution to Lab #3.
 *
 * @author Greg Gagne
 *
 */

//This suppresses warnings we may get
@SuppressWarnings("unchecked")

public class ArraySet<T> implements Set<T> {
	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	
	private int capacity = 0;			// the capacity of the set
	private int numberOfElements = 0;	// the number of elements in the set
	private T[] elements;			// array of elements in the set
	
	public ArraySet() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArraySet(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		
		this.capacity = capacity;
		elements = (T[])new Object[capacity];
	}

	public void add(T element) {
        if (!contains(element)) {
		    ensureCapacity();
		    elements[numberOfElements] = element;
		    numberOfElements++;
        }
	}

	public void addAll(T[] elements) {
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);	
		}

	}

	public boolean contains(T element) {
		if (indexOf(element) > -1)
			return true;
		else
			return false;
	}

	public int getSize() {
		return numberOfElements;
	}

	public int getCapacity() {
		return capacity;
	}

	public void remove(T element) {
		int index = indexOf(element);
		
		if (index > -1) {
			numberOfElements--;
			elements[index] = elements[numberOfElements];
		}

		return;
	}

    public Set<T> union(Set<T> anotherSet) {
        Set<T> newSet = new ArraySet<T>();
        
		// first get what is in anotherSet and not in this
        newSet = anotherSet.difference(this);
        
		// now add this to the newSet
        for (int i = 0; i < numberOfElements; i++)
        	newSet.add(elements[i]);
        
        return newSet;
        
    }

    public Set<T> intersection(Set<T> anotherSet) {
        Set<T> newSet = new ArraySet<T>();
        
        // simply check if an item in this set occurs in anotherSet
        // if it does, then add it to newSet
        for (int i = 0; i < numberOfElements; i++) {
        	if (anotherSet.contains(elements[i]))
        		newSet.add(elements[i]);
        }
        
        return newSet;
    }

    public Set<T> difference(Set<T> anotherSet) {
        Set<T> newSet = new ArraySet<T>();
        
        // simply check if an item in this set does not occur in anotherSet
        // if not, then add it to newSet
        for (int i = 0; i < numberOfElements; i++) {
        	if (!anotherSet.contains(elements[i]))
        		newSet.add(elements[i]);
        }
        
        return newSet;
    }
	
	/**
	 * Returns the index of a specified element, 
	 * or -1 if the element is not present in the array.
	 */
	private int indexOf(Object element) {
		int index = -1;
		for (int i = 0; i < numberOfElements; i++) {
			if (elements[i].equals(element)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * This ensures the array has sufficient capacity to store an additional element.
	 */
	private void ensureCapacity() {
		if (numberOfElements == capacity) {
			T[] newArray = (T[])new Object[(numberOfElements+1) * CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,numberOfElements);
			elements = newArray;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ArraySetIterator();
	}
	
	/**
	 * Inner class that generates an iteration of the bag.
	 */
	private class ArraySetIterator implements Iterator<T>
	{
		private int index = 0;
		
		/**
		 * Determines if there are more elements
		 * in the iteration.
		 * 
		 * @return true if there are more elements, false otherwise.
		 */
		public boolean hasNext() {
			if (index < numberOfElements)
				return true;
			else
				return false;
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @throws java.util.NoSuchElementException if there are no more elements in the iteration.
		 */
		public T next() {
			if (hasNext()) {
				T nextItem = elements[index];
				index++;
				
				return nextItem;
			}
			else
				throw new java.util.NoSuchElementException("No items remaining in the iteration.");
			
		}

		/**
		 * The remove() operation is not supported.
		 * @throws UnsupportedOperationException if involed.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}
