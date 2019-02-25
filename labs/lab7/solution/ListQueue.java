import java.util.ArrayList;
import java.util.List;

public class ListQueue<T> implements Queue<T>{
	private List<T> list;
	
	public ListQueue() {
		list = new ArrayList<T>();
	}

	@Override
	public void add(T item) {
		list.add(item);
	}

	@Override
	public T remove() {
		T element = null;
		
		if (!isEmpty()) {
			element = list.remove(0);
		}
		
		return element;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

}
