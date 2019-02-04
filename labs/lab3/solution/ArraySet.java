/**
 * An array-based set
 * @author Greg Gagne
 *
 */
public class ArraySet implements Set{
	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	private int capacity = 0;
	private int numberOfElements = 0;
	private Object[] elements;
	
	public ArraySet() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArraySet(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		
		this.capacity = capacity;
		elements = new Object[capacity];
	}

	public void add(Object element) {
        if (!contains(element)) {
		    ensureCapacity();
		    elements[numberOfElements] = element;
		    numberOfElements++;
        }
	}

	public void addAll(Object[] elements) {
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);	
		}

	}

	public boolean contains(Object element) {
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

	public void remove(Object element) {
		int index = indexOf(element);
		
		if (index > -1) {
			numberOfElements--;
			elements[index] = elements[numberOfElements];
		}

		return;
	}

    public Set union(Set anotherSet) {
        Set newSet = new ArraySet();
        
        newSet = anotherSet.difference(this);
        
        for (int i = 0; i < numberOfElements; i++)
        	newSet.add(elements[i]);
        
        return newSet;
        
    }

    public Set intersection(Set anotherSet) {
        Set newSet = new ArraySet();
        
        // simply check if an item in this set occurs in anotherSet
        // if it does, then add it to newSet
        for (int i = 0; i < numberOfElements; i++) {
        	if (anotherSet.contains(elements[i]))
        		newSet.add(elements[i]);
        }
        
        return newSet;
    }

    public Set difference(Set anotherSet) {
        Set newSet = new ArraySet();
        
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
			Object[] newArray = new Object[(numberOfElements+1) * CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,numberOfElements);
			elements = newArray;
		}
	}

}
