
public class InsertionSort <T extends Comparable<? super T>> extends SortingAlgorithm <T>  {

	@Override
	public void sort(T[] array) {
		insertionSort(array, array.length);
		
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {
		   for (int j = 1; j < a.length; j++) {
			T key = a[j];
			   
			   int i = j - 1;
			   
			   while ( (i >= 0) && (a[i].compareTo(key) > 0)) {
				   a[i+1] = a[i];
				   i--;
			   }
			   a[i+1] = key;
		   }
	}
}
