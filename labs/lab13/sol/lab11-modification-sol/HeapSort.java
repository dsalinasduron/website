
public class HeapSort <T extends Comparable<? super T>> extends SortingAlgorithm <T> {

	
	public void sort(T[] array) {
		heapSort(array);
	}
	public static <T extends Comparable<? super T>> void heapSort(T[] array) {
		HeapInterface<T> heap = new MaxHeap<T>();
		
		for (int i = 0; i < array.length; i++) {
			heap.add(array[i]);
		}
		
		int j = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			array[j] = heap.remove();
			j--;
		}
	}
	
}
