
public abstract class SortingAlgorithm <T extends Comparable<? super T>> extends
Algorithm<T> {

	@Override
	public void  apply(T[] array) {
		this.sort(array);
	}

	/**
	 * sorts the parameter array in ascending order (from smallest to largest)
	 */
	public abstract void  sort (T[] array);


public static <T extends Comparable<? super T>> boolean isSorted(Comparable[] array) {
	//public static  boolean isSorted(Comparable[] array) {
		for (int i = 1; i < array.length; i++)
			if (array[i].compareTo(array[i-1]) < 0)
				return false;

		return true;
	}

	/** Task: Swaps the array elements a[i] and a[j].
	 *  @param a  an array of objects
	 *  @param i  an integer >= 0 and < a.length
	 *  @param j  an integer >= 0 and < a.length */
	public static void swap(Object[] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	} 

	public static void compareSorts(int n) {
		SortingAlgorithm[] sorts = new SortingAlgorithm[4];

		sorts[0] = new SelectionSort();
		sorts[1] = new InsertionSort();
		sorts[2] = new MergeSort();
		sorts[3] = new QuickSort();

		Integer[][] sortArray = new Integer[4][n];
		sortArray[0] = createRandomArray(n);
		System.arraycopy(sortArray[0], 0, sortArray[1], 0, sortArray[0].length);
		System.arraycopy(sortArray[0], 0, sortArray[2], 0, sortArray[0].length);
		System.arraycopy(sortArray[0], 0, sortArray[3], 0, sortArray[0].length);

		for (int i = 0; i < sorts.length; i++) {
			long elapsedTime = sorts[i].time(sortArray[i]);
			System.out.println(sorts[i] + "  " + elapsedTime + " ms.");
		}
	}

}
