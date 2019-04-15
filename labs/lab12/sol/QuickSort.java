
public class QuickSort <T extends Comparable<? super T>> extends SortingAlgorithm <T>  {

	@Override
	public void sort(T[] array) {
		quickSort(array, 0, array.length-1);

	}

	private static <T extends Comparable<? super T>> void quickSort(T[] a, int left, int right) {
		int l = left;
        int r = right;

        // obtain the pivot
        T pivot = a[right];

        // Divide into two arrays
        while (l <= r) {
            while (a[l].compareTo(pivot) < 0) {
                l++;
            }
            while (a[r].compareTo(pivot) > 0) {
                r--;
            }

            if (l <= r) {
               T temp = a[l];
               a[l] = a[r];
               a[r] = temp;

                //move index to next position on both sides
                l++;
                r--;
            }
        }
        // call quickSort() method recursively
        if (left < r)
            quickSort(a, left, r);
        if (l < right)
            quickSort(a, l, right);
	}


	public String toString() {
		return "Quicksort ";
	}
}

