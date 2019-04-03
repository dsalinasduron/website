/**
 * Implementation of DictionaryInterface using Linear Probing
 * 
 * @author Greg Gagne - April 2018
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

		private TableElement(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		/**
		 * Two TableElement objects are equal if they both have the same key
		 */
		@SuppressWarnings("unchecked")
		public boolean equals(Object other) {
			boolean flag = false;
			
			if (other instanceof TableElement) {
				TableElement<K, V> candidate = (TableElement<K, V>)other;
				
				if ( (this.getKey()).equals(candidate.getKey()) )
					flag = true;
			}
			
			return flag;
		}
				
		// appropriate getters/setters

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
	 * private helper method that returns the probing strategy
	 */
	private int probeValue(K key) {
		// for liner probing simply return 1

		return 1;
	}

	/**
	 * This calls the appropriate hashing strategy
	 */
	public V put(K key, V value) {
		return linearProbing(key, value);
	}

	/**
	 * Private helper method that implements appropriate hashing strategy
	 * @param key
	 * @param value
	 * @return
	 */
	private V linearProbing(K key, V value) {

		// re-hash if necessary
		ensureCapacity();

		// create the new element
		TableElement<K, V> element = new TableElement<K,V>(key, value);

		// get the hash value for the specified key
		int hash = hashValue(key);

		// get the probe value according to hashing strategy
		int probe = probeValue(key);

		// use a simple linear probing
		while (dictionary[hash] != null) {
			hash = (hash + probe) % currentCapacity;
		}

		dictionary[hash] = element;

		return value;

	}

	public V get(K key) {
		// YOUR CODE GOES HERE

		return null;
	}

	public boolean contains(K key) {
		// YOUR CODE GOES HERE

		return false;
	}

	public V remove(K key) {
		// YOUR CODE GOES HERE

		return null;
	}

	public int size() {
		return numberOfElements;
	}


	/**
	 * returns the next prime number that is least 2 larger than
	 * the current prime number.
	 */
	private int getNextPrime(int currentPrime) {
		// first we double the size of the current prime + 1
		currentPrime *= 2;
		currentPrime += 1;

		while (!isPrime(currentPrime))
			currentPrime++;

		return currentPrime;
	}

	/**
	 * Helper method that tests if an integer value is prime.
	 * @param candidate
	 * @return True if candidate is prime, false otherwise.
	 */
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
	private void rehash() {
		// YOUR CODE GOES HERE

		return;
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
		// YOUR CODE GOES HERE

		return null;
	}

	public Set<V> valueSet() {
		// YOUR CODE GOES HERE
		
		return null;
	}
}
