import java.util.List;
import java.util.ArrayList;

public class ListStack<T> implements Stack<T> {

	private List<T> list;
	int index;
	
	public ListStack() {
		index = 0;
		list = new ArrayList<T>();
	}
	
	@Override
	public void push(T item) {
		list.add(index, item);
		index++;
	}

	@Override
	public T pop() {
		if (!isEmpty()) {
			index--;
			return list.remove(index);
		}
		
		return null;
	}

	@Override
	public T peek() {
		if (!list.isEmpty()) {
			return list.get(index-1);
		}
		else
			return null;
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
