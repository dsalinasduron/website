
/**
 * Implementation of DictionaryInterface using Linear Probing
 * 
 * @author Greg Gagne - March 2015
 */

public class HashDictionaryChained<K, V> implements DictionaryInterface<K, V> {

	// initial size of hash table
	private static int DEFAULT_SIZE = 13; 

	// the number of elements in the hash table
	private int numberOfElements;

	// the hash table
	private List<TableElement<K, V>>[] dictionary;

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
		 * Two TableElement objects are equals if they both have the same key
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

	public HashDictionaryChained() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public HashDictionaryChained(int size) {
		if (size < 0)
			throw new IllegalArgumentException();

		dictionary = new LinkedList[size];

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
		int hash = hashValue(key);

		TableElement<K, V> newElement = new TableElement<K, V>(key, value);

		if (dictionary[hash] == null) {
			// if this hash table has not yet been created

			dictionary[hash] = new LinkedList<TableElement<K,V>>();
		}
		else {
			// if we are replacing a dictionary entry, it is
			// easier to first remove it then simply add it again.
			if (dictionary[hash].contains(newElement)) {
				dictionary[hash].remove(newElement);
				--numberOfElements;
			}
		}

		dictionary[hash].add(newElement);
		++numberOfElements;

		return value;
	}


	public V get(K key) {
		V value = null;
		int hash = hashValue(key);

		if (dictionary[hash] != null) {

			// iterate through all elements in the list
			for (int i = 0; i < dictionary[hash].getLength(); i++) {
				TableElement<K, V> item = dictionary[hash].get(i);
				if (key.equals(item.getKey()))
					value = item.getValue();
			}
		}

		return value;
	}

	public boolean contains(K key) {
		int hash = hashValue(key);

		if (dictionary[hash] != null) {
			for (int i = 0; i < dictionary[hash].getLength(); i++) {
				if (key.equals(dictionary[hash].get(i).getKey()))
					return true;
			}
		}

		return false;
	}

	public V remove(K key) {
		int hash = hashValue(key);
		V value = null;
		
		if (dictionary[hash] != null) {
			for (int i = 0; i < dictionary[hash].getLength(); i++) {
				if (key.equals(dictionary[hash].get(i).getKey())) {
					value = dictionary[hash].get(i).getValue();
					dictionary[hash].remove(i);
					--numberOfElements;
					break;
				}
			}
		}


		return value;
	}

	public int size() {
		return numberOfElements;
	}

	public Set<K> keySet() {
		Set<K> keySet = new ArraySet<K>();

		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i] != null) {
				// get the list 
				List<TableElement<K,V>> bucket = dictionary[i];

				for (int j = 0; j < bucket.getLength(); j++) {
					keySet.add(bucket.get(j).getKey());
				}
			}
		}

		return keySet;
	}

	public Set<V> valueSet() {
		Set<V> valueSet = new ArraySet<V>();

		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i] != null) {
				// get the list 
				List<TableElement<K,V>> bucket = dictionary[i];

				for (int j = 0; j < bucket.getLength(); j++) {
					valueSet.add(bucket.get(j).getValue());
				}
			}
		}

		return valueSet;	}
}
