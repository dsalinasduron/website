import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSet<T> implements Set<T> {
	List<T> list;

	public ListSet() {
		list = new ArrayList<T>();
	}

	@Override
	public void add(T element) {
		if (!list.contains(element)) {
			list.add(element);
		}
	}

	@Override
	public void addAll(T[] elements) {
		for (int i = 0; i < elements.length; i++) {
			if (!list.contains(elements[i])) {
				list.add(elements[i]);
			}
		}

	}

	@Override
	public boolean contains(T element) {
		return list.contains(element);
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public void remove(T element) {
		list.remove(element);

	}

	@Override
	public Set<T> union(Set<T> anotherSet) {
		Set<T> newSet = new ArraySet<T>();

		// first get what is in anotherSet and not in this
		newSet = anotherSet.difference(this);

		// now add this to the newSet
		for (int i = 0; i < getSize(); i++)
			newSet.add(list.get(i));

		return newSet;

	}

	@Override
	public Set<T> intersection(Set<T> anotherSet) {
		Set<T> newSet = new ListSet<T>();

		// simply check if an item in this set occurs in anotherSet
		// if it does, then add it to newSet

		for (int i = 0; i < getSize(); i++) {
			if (anotherSet.contains(list.get(i)))
				newSet.add(list.get(i));
		}

		return newSet;
	}

	@Override
	public Set<T> difference(Set<T> anotherSet) {
		Set<T> newSet = new ListSet<T>();

		// simply check if an item in this set does not occur in anotherSet
		// if it does, then add it to newSet

		for (int i = 0; i < getSize(); i++) {
			if (!anotherSet.contains(list.get(i)))
				newSet.add(list.get(i));
		}

		return newSet;
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}
