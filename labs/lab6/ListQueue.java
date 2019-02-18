/**
 * Implementation of Queue interface using LinkedList
 * 
 * @author Greg Gagne
 *
 * @param <T>
 */
public class ListQueue<T> implements Queue<T> {

	private AbstractList<T> queue;
	
	public ListQueue() {
		queue = new LinkedList<T>();
	}
	
	public void add(T item) {
		queue.addRear(item);
	}

	@Override
	public T remove() {
		T item = null;
		
		if (!isEmpty()) {
			item = queue.removeFront();
		}
		
		return item;
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public int size() {
		return queue.getLength();
	}

}
