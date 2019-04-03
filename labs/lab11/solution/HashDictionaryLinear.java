/**
 * Implementation of DictionaryInterface using Linear Probing
 * 
 * @author Greg Gagne - March 2015
 */

public class HashDictionaryLinear<K, V> implements DictionaryInterface<K, V> {

	// initial size of hash table
	private static int DEFAULT_SIZE = 13; 

	// When capacity exceeds this threshold, a new addition will trigger rehashing
	private static double CAPACITY_THRESHOLD = 0.67;

	// the number of elements in the hash table
	private int numberOfElements;

	// the hash table
	private TableElement<K, V>[] dictionary;

	// the current capacity of the hash table
	// this is a prime number
	private int currentCapacity;

	/**
	 * Inner class representing an element in the hash table
	 * This consists of a [Key:Value] mapping
	 *
	 * @param <K> Key
	 * @param <V> Value
	 */
	@SuppressWarnings("hiding")
	private class TableElement<K, V>
	{
		private K key;
		private V value;

		// flag to indicate if the item has been removed
		private boolean isRemoved;

		private TableElement(K key, V value) {
			this.key = key;
			this.value = value;

			isRemoved = false;
		}

		private K getKey() {
			return key;
		}

		private V getValue() {
			return value;
		}

		private void setKey(K key) {
			this.key = key;
		}

		private void setValue(V value) {
			this.value = value;
		}

		/**
		 * Mark this item as being removed.
		 */
		private void remove() {
			isRemoved = true;
		}

		private boolean isRemoved() {
			return isRemoved;
		}
	}

	public HashDictionaryLinear() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public HashDictionaryLinear(int size) {
		if (size < 0)
			throw new IllegalArgumentException();

		dictionary = (TableElement<K, V>[]) new TableElement[size];
		numberOfElements = 0;
		currentCapacity = size;
	}

	/**
	 * Returns the hash value in the range [0 .. currentCapacity-1]
	 * @param key
	 * @return int
	 */
	private int hashValue(K key) {
		return (Math.abs(key.hashCode()) % currentCapacity);
	}

	/**
	 * This calls the appropriate hashing strategy
	 */
	public V put(K key, V value) {
		return linearProbing(key, value);
	}
	
	/**
	 * Private helper method that returns a reference to a specified key
	 */
	private TableElement<K, V> getReferenceTo(K key) {
		int hash = hashValue(key);
		
		while ( (dictionary[hash] != null) && (!dictionary[hash].isRemoved()) ) {
		//while ( (dictionary[hash] != null) ) {
			if (dictionary[hash].getKey().equals(key) && !dictionary[hash].isRemoved() ) {
				return dictionary[hash];
			}
			hash = (hash + 1) % currentCapacity;
		}
		
		return null;
	}

	
	/**
	 * Private helper method that implements appropriate hashing strategy
	 * @param key
	 * @param value
	 * @return
	 */
	private V linearProbing(K key, V value) {
		TableElement<K,V> element = getReferenceTo(key);
		
		if (element != null) {
			element.setValue(value);
			return value;
		}
		else {
			// re-hash if necessary
			ensureCapacity();

			// create the new element
			element = new TableElement<K,V>(key, value);

			// get the hash value for the specified key
			int hash = hashValue(key);
			
			// use a simple linear probing
			while ( (dictionary[hash] != null) && !dictionary[hash].isRemoved() ) {
				hash = (hash + 1) % currentCapacity;
			}
			
			dictionary[hash] = element;
			++numberOfElements;
			
			return value;
	}
	
	}
	
	
	public V get(K key) {
		TableElement<K,V> element = getReferenceTo(key);
		
		if (element != null)
			return element.getValue();
		else
			return null;
	}

	public boolean contains(K key) {
		
		if  (getReferenceTo(key) != null)
			return true;
		else
			return false;
	}

	public V remove(K key) {
		TableElement<K,V> element = getReferenceTo(key);
		
		if (element != null) {
			element.remove();
			--numberOfElements;
			return element.getValue();
		}
		else {
			return null;
		}
	}

	public int size() {
		return numberOfElements;
	}


	private int getNextPrime(int currentPrime) {
		// first we double the size of the current prime + 1
		currentPrime *= 2;
		currentPrime += 1;

		while (!isPrime(currentPrime))
			currentPrime++;

		return currentPrime;
	}

	private  boolean isPrime(int candidate) {
		boolean isPrime = true;

		// numbers <= 1 or even are not prime
		if ( (candidate <= 1) ) 
			isPrime = false;
		// 2 or 3 are prime
		else if ( (candidate == 2) || (candidate == 3) )
			isPrime = true;
		// even numbers are not prime
		else if ( (candidate % 2) == 0)
			isPrime = false;
		// an odd integer >= 5 is prime if not evenly divisible
		// by every odd integer up to its square root
		// Source: Carrano.
		else {
			for (int i = 3; i <= Math.sqrt(candidate) + 1; i += 2)
				if ( candidate % i == 0) {
					isPrime = false;
					break;
				}
		}

		return isPrime;
	}
	/**
	 * re-hash the elements in the dictionary
	 */
	@SuppressWarnings("unchecked")
	private void rehash() {
		// get the next prime number 2x greater than current capacity
		int newSize = getNextPrime(currentCapacity);

		// first copy the old table
		TableElement<K, V>[] oldDictionary = dictionary;

		// create the new table
		dictionary = (TableElement<K, V>[]) new TableElement[newSize];

		// re-initialize counters
		numberOfElements = 0;
		currentCapacity = newSize;

		// now go through existing array and re-hash each existing valid element
		for (int i = 0; i < oldDictionary.length; i++) {
			if (oldDictionary[i] != null) {
				if (!oldDictionary[i].isRemoved()) {
					K key = oldDictionary[i].getKey();
					V value = oldDictionary[i].getValue();

					// re-hash this key:value pair
					put(key,value);
				}
			}
		}
	}

	/**
	 * Return the current load factor
	 * @return
	 */
	private double getLoadFactor() {
		return numberOfElements / (double)currentCapacity; 
	}

	/**
	 * Ensure there is capacity to perform an addition
	 */
	private void ensureCapacity() {
		double loadFactor = getLoadFactor();

		if (loadFactor >= CAPACITY_THRESHOLD)
			rehash();
	}

	public Set<K> keySet() {
		Set<K> keySet = new ArraySet<K>();

		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i] != null && !dictionary[i].isRemoved())
				keySet.add(dictionary[i].getKey());
		}

		return keySet;
	}

	public Set<V> valueSet() {
		Set<V> valueSet = new ArraySet<V>();

		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i] != null && !dictionary[i].isRemoved())
				valueSet.add(dictionary[i].getValue());
		}

		return valueSet;
	}
}
