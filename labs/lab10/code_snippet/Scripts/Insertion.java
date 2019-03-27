private static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int valueToSort = arr[i];
        int j = i;
        while (j > 0 && arr[j - 1] > valueToSort) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = valueToSort;
    }
}
                                                                                                                                }
