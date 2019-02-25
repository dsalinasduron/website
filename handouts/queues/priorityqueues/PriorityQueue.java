public class PriorityQueue <T> implements PriorityQueueInterface<T>
{
java.util.PriorityQueue<T> pq = new java.util.PriorityQueue<T>();

   public void add(T newEntry) {
	pq.add(newEntry);
	}

   public T remove() {
	return pq.poll();
	}

   public T peek() {
	return pq.peek();
	}

   public boolean isEmpty() {
	return (pq.size() == 0);
	}

   public int getSize() {
	return pq.size();
	}

   public void clear() {
	pq.clear();
	}
} // end PriorityQueue

